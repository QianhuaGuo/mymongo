package com.qianhua.mongo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;

    @Slf4j
    public class AES256Utils {

        public static String encryptKey = "BAOZUN-PIM-20180722-WINSTON-ABC$";

        private static final int IV_LENGTH = 32;

        //AES_256_cbc pkcs7
    private static final String ALGORITHM = "AES/CBC/PKCS7Padding";

        private AES256Utils() {
            throw new IllegalStateException("AES256Utils class");
        }

        //加密
        private static byte[] aesCbcEncrypt(byte[] srcData, byte[] key, byte[] iv) {
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = null;
            byte[] encData = null;
            try {
                cipher = Cipher.getInstance(ALGORITHM, "BC");
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
                encData = cipher.doFinal(srcData);
            } catch (Exception e) {
                log.error("AES256-CBC 加密失败！", e);
            }
            return encData;
        }

        //解密
        private static byte[] aesCbcDecrypt(byte[] encData, byte[] key, byte[] iv) {
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = null;
            byte[] decbbdt = null;
            try {
                cipher = Cipher.getInstance(ALGORITHM, "BC");
                cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
                decbbdt = cipher.doFinal(encData);
            } catch (Exception e) {
                log.error("AES256-CBC 解密失败！", e);
            }
            return decbbdt;
        }


        /**
         * byte[] 转换成 hex string
         *
         * @param bytes
         * @return
         */
        private static String bytesToHex(byte[] bytes) {
            StringBuilder buf = new StringBuilder(bytes.length * 2);
            for (byte b : bytes) { // 使用String的format方法进行转换
                buf.append(String.format("%02x", Integer.valueOf(b & 0xff)));
            }

            return buf.toString();
        }

        /**
         * 将16进制字符串转换为byte[]
         *
         * @param str
         * @return
         */
        private static byte[] toBytes(String str) {
            if (str == null || str.trim().equals("")) {
                return new byte[0];
            }

            byte[] bytes = new byte[str.length() / 2];
            for (int i = 0; i < str.length() / 2; i++) {
                String subStr = str.substring(i * 2, i * 2 + 2);
                bytes[i] = (byte) Integer.parseInt(subStr, 16);
            }

            return bytes;
        }

        /**
         * 解密
         *
         * @param cryptograph
         * @return
         */
        public static String decrypt(String cryptograph) {
            String[] cryptogArr = cryptograph.split(":");

            byte[] decryptedContent = toBytes(cryptogArr[1]);
            byte[] encryptKeyBytes = encryptKey.getBytes(StandardCharsets.UTF_8);
            byte[] iv = toBytes(cryptogArr[0]);
            byte[] result = aesCbcDecrypt(decryptedContent, encryptKeyBytes, iv);
            return new String(result, StandardCharsets.UTF_8);
        }

        /**
         * 加密
         *
         * @param content
         * @return
         */
        public static String encrypt(String content) {

            byte[] encryptedContentBytes = content.getBytes(StandardCharsets.UTF_8);
            byte[] encryptKeyBytes = encryptKey.getBytes(StandardCharsets.UTF_8);
            byte[] iv = toBytes(RandomStringUtils.randomNumeric(IV_LENGTH));
            byte[] result = aesCbcEncrypt(encryptedContentBytes, encryptKeyBytes, iv);
            if (null == result) return null;
            String ivStr = bytesToHex(iv);
            String resultStr = bytesToHex(result);
            return ivStr + ":" + resultStr;
        }
    }


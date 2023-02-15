package com.qianhua.mongo.util;

import java.util.ArrayList;
import java.util.List;

public class AesDemo {
    public static void main(String[] args) {
        String encryAccessToken = AES256Utils.encrypt("41c5c5fb04214ec2805d72d936881b37ndfj");
        System.out.println(encryAccessToken);
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        int[] l = {1,2,3,4,5};

        changeList(l);
        for (int i = 0;i<l.length;i++){
            System.out.println(l[i]);
        }

    }

    public static void changeList(int[] list){
        int size = list.length;
        for (int i = 0;i<size/2;i++){
            int tmep = list[i];
            list[i] = list[size-i-1];
            list[size-i-1] = tmep;
        }
    }
}

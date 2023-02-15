package com.qianhua.mongo.demo;

import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;

public class FieldResolution {

    TreeMap t = new TreeMap();

    static int i = 1;
    static {
        int i = 0;
        System.out.println("static:"+i);
    }
//    static int i = 1;

    interface Interface0{
        int A = 0;
    }

    interface Interface1 extends Interface0{
        int A = 1;
    }

    interface Interface2{
        int A = 2;
    }

    static class Parent implements Interface1{
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2{
        public static int A = 4;
    }

    public static void main(String[] args) {
//        System.out.println(Sub.A);
        System.out.println(i);
    }
}

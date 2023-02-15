package com.qianhua.mongo.demo;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITAL_CAPACITY];
    }

    public void push(Object obj){
        //判断栈是否满，如果栈满需要扩容
        ensureCapacity();
        //元素入栈
        elements[size++] = obj;
    }

    /**
     * 该方法没有删除栈类的对象的引用（过期引用），会导致内存泄漏
     * @return
     */
//    public Object pop(){
//        if (size == 0){
//            throw new EmptyStackException();
//        }
//        return elements[--size];
//    }

    /**
     * 正确的出栈
     * @return
     */
    public Object pop(){
        if (size == 0){
            throw new EmptyStackException();
        }
        Object element = elements[--size];
        //清空过期引用
        elements[--size] = null;
        return element;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements,2*size+1);
    }
}

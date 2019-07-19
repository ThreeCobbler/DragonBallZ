package com.dragon.demo;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author ljn
 * @date 2019/7/15.
 */
public class Stack implements Cloneable {

    private Object[] elements;//用数组来存储栈的元素
    private int size = 0;//栈中元素的个数
    private static final int DEFAULT_INITIAL_CAPACITY = 16;//默认初始化大小为16

    public Stack(){
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    //压入栈
    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }
    //弹出栈信息
    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }
    //确保栈的容量
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }
    //克隆栈对象
    @Override
    public Stack clone () throws CloneNotSupportedException{
        return (Stack) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Stack stack = new Stack();
        stack.push("Jachen");
        stack.push("Anna");
        stack.push("Jack");
        Stack cloneStack = stack.clone();
        cloneStack.pop();

        for(int i = 0;i<stack.size;i++){
            System.out.print(stack.elements[i] + ",");
        }
        System.out.println(stack.size);
    }

}

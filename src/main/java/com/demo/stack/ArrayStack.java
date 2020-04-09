package com.demo.stack;

import com.demo.array.dynamic.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array(capacity);
    }

    public ArrayStack(){
        array = new Array();
    }

    public int getSize(){
        return array.getSize();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public void push(E e){
        array.addLast(e);
    }

    public E pop(){
        return array.removeLast();
    }

    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack(2);
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        stack.push(6);
        System.out.println(stack);
        stack.push(7);
        System.out.println(stack);
        stack.push(8);
        System.out.println(stack);
        stack.push(9);
        System.out.println(stack);
        for (int i=1; i<=10; i++){
            stack.pop();
            System.out.println(stack);
        }

    }
}

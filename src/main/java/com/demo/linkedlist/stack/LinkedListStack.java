package com.demo.linkedlist.stack;

import com.demo.linkedlist.dummyhead.LinkedList;
import com.demo.stack.Stack;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/11/20 11:37 上午
 **/
public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> data;

    public LinkedListStack() {
        this.data = new LinkedList();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStack();
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

package com.demo.queue;

import com.demo.array.dynamic.Array;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/6/20 7:10 下午
 **/
public class MyArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public MyArrayQueue() {
        this.array = new Array<E>(10);
    }

    public MyArrayQueue(int capacity) {
        this.array = new Array<E>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //入队
    @Override
    public void enqueue(E element) {
        array.addLast(element);
    }

    //出队
    @Override
    public E dequeue() {
        return  array.removeFirst();
    }

    //查看队首元素
    @Override
    public E getFront() {
       return array.getLast();
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue();
        arrayQueue.enqueue(1);
        System.out.println(arrayQueue);
        arrayQueue.enqueue(2);
        System.out.println(arrayQueue);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue);
        arrayQueue.enqueue(4);
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);

    }
}

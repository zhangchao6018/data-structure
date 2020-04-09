package com.demo.queue.loopqueue;

import com.demo.array.dynamic.Array;
import com.demo.queue.Queue;

/**
 * @描述: 基于我的动态数组的循环队列 ->缩容问题未解决
 * @author: zhangchao
 * @date: 4/6/20 8:01 下午
 **/
public class MyLoopQueue<E> implements Queue<E> {
    Array<E> array;

    //队首元素的索引  当队列为空时 front == tail
    private int front;

    //队尾元素的索引
    private int tail;

    public MyLoopQueue() {
        this.array = new Array(10);
    }

    public MyLoopQueue(int capacity) {
        this.array = new Array(capacity+1);
    }

    @Override
    public int getSize() {
        return array.getSize()-1;
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        //如果没有元素
        if (tail == front){
            array.addFirst(e);
            tail = 1;
            front =0;
        }else {
            array.add(tail, e);
            tail++;
        }
    }

    @Override
    public E dequeue() {
//        if (front>=com.demo.array.getSize()){
//            throw  new IllegalArgumentException("出队失败,队列已经为空");
//        }
        E e = array.get(front);
        array.set(front, null);
//        com.demo.array.remove(front);
        front++;
        return e;
    }

    @Override
    public E getFront() {
        return array.get(front);
    }

    @Override
    public String toString() {
        return "{" +
                "front=" + front +
                ", tail=" + tail +"\n"+
                "com.demo.array=" + array +
                '}';
    }

    public static void main(String[] args) {
        MyLoopQueue<Integer> loopQueue = new MyLoopQueue(2);
        loopQueue.enqueue(1);
        System.out.println(loopQueue + "\n");
        loopQueue.enqueue(2);
        System.out.println(loopQueue + "\n");
        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");
        loopQueue.enqueue(4);
        System.out.println(loopQueue + "\n");
        loopQueue.enqueue(5);
        System.out.println(loopQueue + "\n");
        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");
        loopQueue.dequeue();
        System.out.println(loopQueue + "\n");

    }

}

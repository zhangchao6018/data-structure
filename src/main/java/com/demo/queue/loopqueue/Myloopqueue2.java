package com.demo.queue.loopqueue;

import com.demo.queue.Queue;

public class Myloopqueue2<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;   // 有兴趣的同学，在完成这一章后，可以思考一下：
                        // LoopQueue中不声明size，如何完成所有的逻辑？
                        // 这个问题可能会比大家想象的要难一点点：）

    public Myloopqueue2(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public Myloopqueue2(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    // 下一小节再做具体实现
    @Override
    public void enqueue(E e){
        //扩容   tail==front ->队列为空
        if (size!=0 && tail!=front && (tail+1)/data.length == front ){
            resize(getCapacity()*2);
        }
        if (front == tail && front==0){
            data[tail+1] = e;
            //resize(data.length*2);
            tail=2;
            front++;
        }else {
            data[tail] = e;
            tail++;
        }

        size++;
    }



    //将指针往后移
    @Override
    public E dequeue(){
        E e = data[front];
        data[front] = null;
        if (front==data.length){
            front = 0;
        }else {
            front++;
        }
        size--;
        return e;
    }

    // 获取队首元素
    @Override
    public E getFront(){
        return data[front];
    }

    //扩缩容
    private void resize(int capacity){
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        //替换原有的
        this.data = newArray;
        System.out.println("触发扩容");
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = 0; i < data.length; i++) {
            res.append(data[i]);
            if (i!=data.length-1)
            res.append(",");
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Myloopqueue2(4);
        queue.enqueue(1);
        System.out.println(queue + "\n");
        queue.enqueue(2);
        System.out.println(queue + "\n");
        queue.enqueue(3);
        System.out.println(queue + "\n");
        queue.enqueue(4);
        System.out.println(queue + "\n");
        queue.enqueue(5);
        System.out.println(queue + "\n");
        Integer dequeue = queue.dequeue();
        System.out.println(dequeue);
        System.out.println(queue + "\n");
    }
}

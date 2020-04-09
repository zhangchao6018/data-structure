package com.demo.queue.loopqueue;

import com.demo.queue.Queue;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/8/20 7:38 上午
 **/
public class MyLoopQueue3<E> implements Queue<E> {
    //存储元素的数组
    E[] data;
    //队首
    int front;
    //队尾(不含)
    int tail;
    //元素个数
    int size;

    public MyLoopQueue3(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public MyLoopQueue3(){
        this(10);
    }
    @Override
    public int getSize() {
        return size;
    }



    @Override
    public boolean isEmpty() {
        //尝试用  size==0?
        return front == tail;
    }

    //入队->
    @Override
    public void enqueue(E e) {
        //判断是否已满
        if ((tail+1)%data.length == front && front != tail){
            //需要扩容
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    //出队
    @Override
    public E dequeue() {
        E e = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size-- ;
        // 保证最小capacity为1
        if (getCapacity() == size*4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return null;
    }

    /**
     * 这种遍历方式缩容会发生索引越界
     * @param newCapacity
     */
    private void resize(int newCapacity){
        //保持原有索引位置
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = front; i != tail; i = (i+1)%data.length) {
            newData[i%newCapacity] = data[i];
        }
        data= newData;
        front = front/newData.length;
        tail = tail/newData.length;
    }

//    private void resize(int newCapacity){
//
//        E[] newData = (E[])new Object[newCapacity + 1];
//        for(int i = 0 ; i < size ; i ++)
//            newData[i] = data[(i + front) % data.length];
//
//        data = newData;
//        front = 0;
//        tail = size;
//    }

    public int getCapacity(){
        return data.length - 1;
    }

//    @Override
//    public String toString(){
//
//        StringBuilder res = new StringBuilder();
//        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
//        res.append("front [");
//        for(int i = front ; i != tail ; i = (i + 1) % data.length){
//            res.append(data[i]);
//            if((i + 1) % data.length != tail)
//                res.append(", ");
//        }
//        res.append("] tail");
//        return res.toString();
//    }
@Override
public String toString(){

    StringBuilder res = new StringBuilder();
    res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
    res.append("front [");
    for(int i = 0 ; i < tail ; i ++){
        res.append(data[i+front/data.length]);
//        if((i + 1) % data.length != tail)
            res.append(", ");
    }
    res.append("] tail");
    return res.toString();
}

    public static void main(String[] args) {
        MyLoopQueue3<Integer> queue = new MyLoopQueue3(1);
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
        }
        for(int i = 0 ; i < 10 ; i ++){

            queue.dequeue();
            System.out.println(queue);
        }
    }
}

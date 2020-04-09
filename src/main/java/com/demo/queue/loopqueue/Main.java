package com.demo.queue.loopqueue;

import com.demo.queue.Queue;

import java.util.Random;

public class Main {

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 200000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        Myloopqueue2<Integer> loopQueue2 = new Myloopqueue2();
        double time3 = testQueue(loopQueue2, opCount);
        System.out.println("mine1, time: " + time3 + " s");

        MyLoopQueue<Integer> loopQueue3 = new MyLoopQueue();
        double time4 = testQueue(loopQueue3, opCount);
        System.out.println("mine, time: " + time4 + " s");
    }
}

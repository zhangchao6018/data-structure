package com.demo.heap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array(capacity);
    }

    public MaxHeap(){
        data = new Array();
    }

    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        //将最小元素挪到头节点
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){
        while(leftChild(k) < data.getSize()){
            if(data.get(leftChild(k)).compareTo(data.get(rightChild(k)))>0){
                data.swap(k, leftChild(k));
                siftDown(leftChild(k));
            }else {
                data.swap(k, rightChild(k));
                siftDown(rightChild(k));
            }
        }
    }
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap();
        heap.add(62);
        heap.add(41);
        heap.add(30);
        heap.add(28);
        heap.add(16);
        heap.add(22);
        heap.add(13);
        heap.add(19);
        heap.add(17);
        heap.add(15);
        heap.add(52);
        heap.extractMax();
        System.out.println();
    }
}

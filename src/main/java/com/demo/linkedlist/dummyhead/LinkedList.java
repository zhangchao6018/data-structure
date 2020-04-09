package com.demo.linkedlist.dummyhead;

/**
 * @描述: 引入虚拟头结点 解决头节点特殊情况的问题, addFirst 相当于是往虚拟头节点后添加元素
 * @author: zhangchao
 * @date: 4/8/20 11:01 下午
 **/
public class LinkedList<E> {
    //虚拟头节点
    private Node dummyhead;
    private int size;

    private class Node<E>{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        Node node = new Node(e, dummyhead.next);
        this.dummyhead.next = node;
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e){
        Node<E> eNode = new Node(e);

        if (index < 0 || index>size){
            throw  new RuntimeException("index 非法 ,必须小于等于size...");
        }
        //定义前一个节点
        Node pre = dummyhead;
        for (int i = 0; i < index; i++) {
            if (pre.next != null){
                pre = pre.next;
            }
        }
        eNode.next = pre.next;
        pre.next = eNode;
        size ++;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        linkedList.add(6, 9);
        System.out.println(linkedList);

    }

}
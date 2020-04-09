package com.demo.linkedlist.basic;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/8/20 11:01 下午
 **/
public class LinkedList<E> {
    private Node head;
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
        head = null;
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
        this.head = new Node(e,head);
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e){
        Node<E> eNode = new Node(e);

        if (index < 0 || index>size){
            throw  new RuntimeException("index 非法 ,必须小于等于size...");
        }
        // 根据index 找到该位置的前一个节点
        if (index == 0){
            eNode.next = head;
            head = eNode;
            size ++;
            return;
        }

        //定义前一个节点
        Node pre = head;
        for (int i = 0; i < index-1; i++) {
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
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.addFirst(3);
//        linkedList.addFirst(4);
//        linkedList.addFirst(5);
//        linkedList.addFirst(6);
        linkedList.add(0, 9);
        System.out.println(linkedList);

    }

}

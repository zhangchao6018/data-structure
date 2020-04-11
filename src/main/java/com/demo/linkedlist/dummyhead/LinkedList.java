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
        public Node<E> next;

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
//        Node node = new Node(e, dummyhead.next);
//        this.dummyhead.next = node;
//        size++;
        add(0, e);
    }
    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
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

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node<E> target = dummyhead;
        for (int i = 0; i <= index; i++ ){
            target = target.next;
        }
        return target.e;
    }
    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if (index < 0 || index > size-1){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node<E> cur = dummyhead.next;
        for (int i = 0; i < index; i++ ){
            cur = cur.next;
        }
        cur.e = e;
    }
    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node<E> cur = dummyhead.next;
        boolean result = false;
        for (int i = 0; i < size; i++ ){
             if (cur.e.equals(e)){
                 result = true;
                 break;
             }else {
                 cur = cur.next;
             }
        }
        return result;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        // 找到该元素与其前一个元素  将前一个元素的next只指向它的next
        if (index < 0 || index > size-1){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node<E> pre = dummyhead;
        for (int i=0; i<index; i++){
            pre = pre.next;
        }
        Node<E> result = pre.next;
        pre.next = result.next;
        return result.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除元素e(全删) ->写的有点乱...
    public void removeAllElement(E e){
        Node<E> pre =dummyhead;
        while (pre!=null && pre.next!=null && pre.next.e!=null){
            if (pre.next.e.equals(e)) {
                pre.next=pre.next.next;
                if (pre.next!=null && pre.next.e!=null && pre.next.e.equals(e)){
                    pre.next=null;
                    break;
                }
            }
            pre = pre.next;
            size--;
        }
    }

//    public void removeElement(E e){
//        //遍历第一次拿到这个元素对应节点
//        Node<E> targetNode = dummyhead;
//        for (int i=0; i<size;i++){
//            targetNode = targetNode.next;
//            if (targetNode.e!=null && targetNode.e.equals(e)){
//                break;
//            }
//        }
//        //再遍历一次拿到这个元素上一个父节点
//        Node<E> preNode = dummyhead;
//        for (int i=0; i<size;i++){
//            preNode = preNode.next;
//            if (preNode.next!=null && preNode.next.equals(targetNode)){
//                break;
//            }
//        }
//        preNode.next = targetNode.next;
//        size--;
//    }

    public void removeElement(E e){
        //遍历第一次拿到这个元素的上一个节点

        Node<E> preNode = dummyhead;
        for (int i=0; i<size;i++){
            if (preNode.next.e.equals(e)) {
                break;
            }
            preNode = preNode.next;
        }

        preNode.next=preNode.next.next;
        size--;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        for(Node cur = dummyhead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
//        linkedList.add(6, 9);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getFirst());

        linkedList.set(0, 0);
        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println("移除元素");
        linkedList.removeElement(1);
        System.out.println(linkedList);

    }

}

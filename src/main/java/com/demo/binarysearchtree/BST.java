package com.demo.binarysearchtree;

/**
 * 二分搜索树
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e){
        if (root==null){
            root = new Node(e);
            size++;
        }else
        add(root, e);
    }

    private void add(Node node, E e) {
        //思考一下 为什么这两步是多余的
//        // 直接赋值
//        if (node == null){
//            System.out.println("辅助1");
//            node = new Node(e);
//            return;
//        }
//        //赋值
//        if (node.e == null) {
//            System.out.println("辅助2");
//            node = new Node(e);
//            return;
//        }
        if (node.e.compareTo(e) > 0 && node.left==null){
            node.left= new Node(e);
            size++;
            return;
         }
        else if ( node.e.compareTo(e) <0 && node.right==null){
            node.right = new Node(e);;
            size++;
            return;
        }
        if ( node.e.compareTo(e) > 0 ){
            add(node.left,e);
        }
        if ( node.e.compareTo(e) < 0 ){
            add(node.right,e);
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        bst.add(20);
        bst.add(2);
        bst.add(3);
        bst.add(51);
        bst.add(14);
        bst.add(9);
        bst.add(22);
        bst.add(38);
        bst.add(0);
        System.out.println(bst);

    }
}

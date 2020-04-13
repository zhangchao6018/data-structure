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
        add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        Node child ;
        //初始化
        if (root==null){
            return new Node(e);
        }else {
            child = add(node, e);
            if (root.e.compareTo(child.e)<0){
                //元素应该往左边放
                root.right = child;
            }else {
                //元素应该往右边放
                root.left = child;
            }
        }
       // root = node;
        return child;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(0);
        System.out.println(bst);

    }
}

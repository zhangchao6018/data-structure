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
        }else
        add(root, e);
    }

    private void add(Node node, E e) {
        if (node.e == null) {
            node.e = e;
            return;
        }
        if (node.e.compareTo(e) > 0 && node.left!=null){
            node = node.left;
            add(node, e);
            return;
         }
        else if ( node.e.compareTo(e) <0 && node.right!=null){
            node = node.right;
            add(node, e);
            return;
        }
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

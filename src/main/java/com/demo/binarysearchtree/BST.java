package com.demo.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
//        if (root==null){
//            root = new Node(e);
//            size++;
//        }else
        root = add(root, e);
    }

    /*private void add(Node node, E e) {
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
    }*/
    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }
    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }
    // 看以node为根的二分搜索树中是否包含元素e, 递归算法

    /**
     *
     * @param node 相对根节点
     * @param e 元素
     * @return
     */
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if (node.e.compareTo(e) == 0){
            return true;
        }
        if (node.e.compareTo(e) < 0)
            return contains(node.right,e);
        if (node.e.compareTo(e) > 0)
            return contains(node.left,e);
        return false;
    }


    /**
     * 二分搜索树的前序遍历
     *     先父节点 再左 再右 ->  搜索
     */
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 二分搜索树的中序遍历
     *      先处理左 再处理父 后处理右 ->元素是从小到大有序的
     */
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    /**
     * 二分搜索树的后序遍历
     *  先处理孩子节点
     *      使用场景: 释放内存
     */
    public void postOrder(){
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的非递归前序遍历
    public void preOrderNR(){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (pop.right!=null)
            stack.push(pop.right);
            if (pop.left!=null)
            stack.push(pop.left);
        }
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder(){
        if (root==null)
            return;
        Queue<Node> q = new LinkedList();
        q.add(root);
        while (q.peek()!=null){
            Node poll = q.poll();
            System.out.println(poll.e);
            if (poll.left!=null)
            q.add(poll.left);
            if (poll.right!=null)
            q.add(poll.right);
        }

    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
      return minimum(root).e;

    }
    private Node minimum(Node node){
        if (node.left==null)
            return node;
        else
            return minimum(node.left);
    }

    /**
     *寻找二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return removeMin(root);
    }

    private E removeMin(Node node){
        if (node.left==null){
            Node res = node;
            node= node.right;
            System.out.println("--------");
            size--;
            return res.e;
        }
        if ( node.left.left==null && node.left.right==null) {
            Node res = node.left;
            node.left = null;
            size--;
            return res.e;
        }
        if ( node.left.left==null && node.left.right!=null) {
            Node res  = new Node(null);
            res.e=node.left.e;
            Node right = node.left.right;
            //垃圾回收
            node.left.right=null;
            node.left.e = right.e;
            size--;
            return res.e;
        }
        return removeMin(node.left);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {

       ////////////////////////////
       //         15             //
       //       /    \           //
       //      10     30         //
       //     / \     / \        //
       //    3  13   25  35      //
       //   / \     /    / \     //
       //  1   4  21    32  50   //
       //                 \      //
       //                  34    //
       ///////////////// //////////
        BST<Integer> bst = new BST();
        //int[] nums = {15, 10, 30, 3, 25, 13,35,4,32,50,21,34,1};
        int[] nums = {15};
        for(int num: nums)
            bst.add(num);
        System.out.println(bst);
        System.out.println(bst.contains(4));
        System.out.println("前序");
        bst.preOrder();
        System.out.println("中序");
        bst.inOrder();
        System.out.println("后序");
        bst.postOrder();
        System.out.println("非递归遍历");
        bst.preOrderNR();
        System.out.println("层序遍历");
        bst.levelOrder();
        Integer minimum = bst.minimum();
        System.out.println("最小值:"+minimum);
        Integer maximum = bst.maximum();
        System.out.println("最大值:"+maximum);
        Integer integer = bst.removeMin();
        System.out.println("被移除的最小元素:"+integer);
        bst.inOrder();
    }
}

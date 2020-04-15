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

    // 二分搜索树的前序遍历
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

    // 二分搜索树的中序遍历
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

    // 二分搜索树的后序遍历
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

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        BST<Integer> bst = new BST();
        int[] nums = {5, 3, 6, 8, 4, 2};
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

    }
}

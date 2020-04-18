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
    public E removeMin1(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return removeMin1(root);
    }

    private E removeMin1(Node node){
//        if (node.left==null){
//            Node res = new Node(node.e);
//            // node= node.right 思考:这种写法为什么错了?
//            node.e= node.right==null?null:node.right.e;
//            node.right = node.right==null?null:node.right.right;
//            size--;
//            return res.e;
//        }
        //以上写法 在只有一个根节点的情况会出错
        if (node.left==null){
            Node res = new Node(node.e);
            if (size==1){//处理特殊情况
                root =null;
                size--;
            }else {
                // node= node.right 思考:这种写法为什么错了?
                node.e= node.right==null?null:node.right.e;
                node.right = node.right==null?null:node.right.right;
            }
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
        return removeMin1(node.left);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     * @return
     */
    public E removeMin2(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        E minimum = minimum();

        Node targetFather = findTargetFather(root, minimum);
        if (targetFather == null){
            root = root.right==null?null:root.right;
            size--;
        }else {
            targetFather.e = targetFather.right==null?null:targetFather.right.e;
            targetFather.right = targetFather.right==null?null:targetFather.right.right;
            size--;
        }
        return minimum;
    }
    /**
     * find to be deleted node‘s father node
     *      if none null -> {15,16}
     *      if null -> {15}
     * @param node
     * @param e
     * @return
     */
    private Node findTargetFather(Node node,E e){
        if (node.e.compareTo(e) == 0){
            return null;
        }
        if (node.left !=null && node.left.e.compareTo(e) == 0){
            return node;
        }
        return findTargetFather(node.left,e);
    }

    /**
     * find to be deleted node
     *      condition1:
     *          left
 *          condition2:
     *          right
     *      condition3:
     *          root
     *
     * @param node
     * @param e
     * @return
     */
    private Node toBeDeletedNode(Node node, E e){
        if (node.e.compareTo(e) == 0){
            return node;
        }
        if (node.left!=null ){
            return toBeDeletedNode(node.left,e);
        }
        else /* (node.right!=null)*/
            return toBeDeletedNode(node.right,e);
    }

    public E removeMin(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        E minimum = minimum();
        root = removeMin(root);
        return minimum;
    }
    public Node removeMin(Node node){
        if(node.left == null){
            Node right = node.right;
            node.right=null;
            size--;
            return right;
        }
        node.left= removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        E maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    private Node removeMax(Node node) {
        if (node.right==null){
            Node left = node.left;
            node.left=null;
            size --;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove2(E e){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        root = remove2(root,e);
    }

    //target左右节点都不为空  target替换成右边子树的最小值
    private Node remove2(Node root, E e) {
        if (root==null){
            return null;
        }
        if (root.e.compareTo(e)>0){
            //错误操作:  root =  remove(root.left,e); ->整个结果是空
            root.left =  remove2(root.left,e);
        }
        if (root.e.compareTo(e)<0){
            root.right =  remove2(root.right,e);
        }else {  //root.e.compareTo(e)==0
            //此时root即为待删除节点
            if (root.left==null){
                Node right = root.right;
                root.right = null;
                root = right;
                size--;
            }else if (root.right==null){
                Node left = root.left;
                root.left = null;
                root = left;
                size--;
            }
            //左右节点都不为空  移除节点替换成右子树的最小值
            else {
                BST<E> rightBST = new BST();
                rightBST.root=root.right;
                //设置为1 纯粹是为了让removeMin方法不报错  更优雅的方法见remove(E e)
                rightBST.size=1;
                //该元素即为替换后的元素
                E replace = rightBST.removeMin();
                root.e = replace;
                size--;
            }
        }
        return root;
    }
    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点((同样也可以用找比待删除节点小的左子树最大元素代替)
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
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
       ////////////////////////////
        BST<Integer> bst = new BST();
        int[] nums = {15, 10, 30, 3, 25, 13,35,4,32,50,21,34,1};
//        int[] nums = {15,16};
//        int[] nums = {15};
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
//        Integer integer = bst.removeMin();
//        System.out.println("被移除的最小元素:"+integer);
//        System.out.println("移除结果：");
//        Integer max = bst.removeMax();
//        System.out.println("被移除的最大元素:"+max);
//        System.out.println("移除结果：");
        bst.remove(30);
        System.out.println("移除指定元素result:");
        bst.inOrder();
    }
}

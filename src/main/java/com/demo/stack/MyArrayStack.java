package com.demo.stack;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/6/20 10:39 上午
 **/
public class MyArrayStack<E> implements Stack {
    private E[] data;

    private int size;



    public MyArrayStack() {
        //初始化一个长度为10的数组
        this.data = (E[]) new Object[8];
        this.size = size;
    }
    public MyArrayStack(int capacity) {
        //初始化一个长度为10的数组
        this.data = (E[]) new Object[capacity];
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }
    //顶部添加元素
    public void push(Object element) {
        if (size==data.length){
            resize(size*2);
        }
        data[size]= (E) element;
        size++;
    }

    //取出栈顶元素
    public E pop() {
        if (size==0){
            return null;
        }

        E res = data[size-1];
        data[size-1]=null;
        size--;
        if (size == data.length/4){
            resize(data.length/2);
        }
        return res;
    }
   //查看栈顶元素
    public E peek() {
        return data[size-1];
    }
    //扩容
    private void resize(int capacity ) {
        E[] newArray = (E[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        this.data = newArray;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("capacity: "+data.length+" ");
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        //userTest();
        intTest();

    }
    private static void intTest() {
        Stack<Integer> stack = new MyArrayStack(2);
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        stack.push(6);
        System.out.println(stack);
        stack.push(7);
        System.out.println(stack);
        stack.push(8);
        System.out.println(stack);
        stack.push(9);
        System.out.println(stack);
        for (int i=1; i<=10; i++){
            stack.pop();
            System.out.println(stack);
        }


    }

    private static void userTest() {
        Stack<User> stack = new MyArrayStack();
        User user1 = new User("1", "张三");
        User user2 = new User("2", "李四");
        User user3 = new User("3", "王五");
        User user4 = new User("4", "赵六");
        User user5 = new User("5", "七七");
        stack.push(user1);

        stack.push(user2);
        System.out.println(stack);
        stack.push(user3);
        System.out.println(stack);
        stack.push(user4);
        System.out.println(stack);
        stack.push(user5);
        System.out.println(stack);
//        User pop = com.demo.stack.pop();
//        System.out.println(com.demo.stack);
    }
}

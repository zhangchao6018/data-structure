package com.demo.array.generic;

/**
 * 基于java的泛型数组
 */
public class GenericArray<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public GenericArray(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public GenericArray(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在所有元素后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }

    //在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e){
        if (data.length==index){
            throw  new IllegalArgumentException("添加失败,数组已满,无法添加");
        }
        if (index<0 || index > size){
            throw  new IllegalArgumentException("添加失败,索引越界");
        }
        //将指定索引的元素往后挪一个位置
        for (int i = size-1; i >= index; i--) {
            data[i+1]=data[i];
        }
        data[index] =e;
        //维护一下size
        size++;
    }

    // 获取index索引位置的元素 如果不对索引进行非空判断,
    public E get(int index){
        if (index<0 || index > size-1){
            throw  new IllegalArgumentException("获取失败,索引越界");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index ,E e){
        if (index<0 || index > size-1){
            throw  new IllegalArgumentException("设置失败,索引越界");
        }
        data[index] = e;
    }
    // 查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if (index<0 || index >size-1){
            throw  new IllegalArgumentException("删除失败,索引越界");
        }
        E res = data[index];
        for (int i = index; i < size-1 ; i--) {
             data[i]=data[i+1];
        }
        // 优化->gc
        data[size]=null;
        //这一步很重要
        size--;
        return res;
    }
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray(4);
//        com.demo.array.addLast(1);
//        System.out.println(com.demo.array);
//        com.demo.array.addLast(2);
//        System.out.println(com.demo.array);
//        com.demo.array.addLast(3);
//        System.out.println(com.demo.array);
//        com.demo.array.addLast(4);
//        System.out.println(com.demo.array);
//        com.demo.array.addLast(5);
//        System.out.println(com.demo.array);
//
//        //往指定索引插入一个元素
//        com.demo.array.add(5,10);
//        System.out.println(com.demo.array);
//        com.demo.array.set(5, -1);
//        com.demo.array.removeLast();
//        System.out.println(com.demo.array);

        array.addLast(1);
        System.out.println(array);
        array.addLast(2);
        System.out.println(array);
        array.addLast(3);
        System.out.println(array);
        array.addLast(4);
        System.out.println(array);

        array.removeLast();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);

    }

}

package com.demo.sys.insertionsort;

import com.demo.sys.linearsearch.LinearSearch2;

import java.util.Arrays;

/**
 * 描述:
 * 插入排序-支持泛型
 * @Author: zhangchao
 * @Date: 8/13/20 11:35 下午
 **/
public class MyInsertionSort {
    public static <E extends Comparable<E>> void sort(E[] arr){
        //1. 循环不变量: 已排序[0,i)  未排序(i,arr.length]
        //forWhile(arr);
        //代码更加简洁
        //doubleLoop(arr);
        //性能优化
        //doubleLoopEx(arr);

        //2.循环不变量: 未排序[0,i)  已排序(i,arr.length]
        doubleLoopExReverse(arr);
    }
    private static <E extends Comparable<E>> void doubleLoopExReverse(E[] arr) {
        // Integer[] arr = {11,5,59,11,3,8,18};
        for (int i =arr.length-1; i>=0; i--){
            int j;
            E temp = arr[i];
            for ( j =i; j<arr.length-1 ; j++  ){
                if (temp.compareTo(arr[j+1])>0){
                    arr[j] = arr[j+1];
                }else {
                    break;
                }
            }
            arr[j] =temp;
        }
    }

    private static <E extends Comparable<E>> void doubleLoopEx(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int x = i;
            for (int j=i; j>0 ;j--){
                if ( temp.compareTo(arr[j-1])<=0){
                    preMoveBack(arr,j);
                    x--;
                }
                else{
                    break;
                }
            }
            if ( x<i){
                arr[x] = temp;
            }
        }
    }

    /**
     * 将j前一个元素赋值给i(不是交换)
     * @param arr
     * @param j
     */
    private static <E extends Comparable<E>> void preMoveBack(E[] arr, int j) {
        arr[j] =arr[j-1];
    }

    private static <E extends Comparable<E>> void doubleLoop(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j=i; j>0 && arr[j].compareTo(arr[j-1])<0;j--){
                swap(arr,j,j-1);
            }
        }
    }
    private static <E extends Comparable<E>> void forWhile(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //记录当前元素索引
            int j =i;
            while (true){
                if(j==0){
                    //已在第一位,不用排序
                    break;
                }
                if (arr[j].compareTo(arr[j-1])<=0){
                    //向前挪
                    swap(arr,j,j-1);
                    j--;
                }else {
                    break;
                }
            }
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int j, int i) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {11,5,59,11,3,8,18};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        LinearSearch2.User[] arrUser = new LinearSearch2.User[]{new LinearSearch2.User("张三",18),
                new LinearSearch2.User("李四",10),
                new LinearSearch2.User("王五",15),
                new LinearSearch2.User("赵六",12),
                new LinearSearch2.User("rose",19),
                new LinearSearch2.User("jack",1),
        };
        sort(arrUser);
        for (LinearSearch2.User user : arrUser) {
            System.out.println(user);
        }
    }
}

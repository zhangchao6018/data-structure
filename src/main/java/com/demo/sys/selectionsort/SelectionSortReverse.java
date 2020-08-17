package com.demo.sys.selectionsort;

import com.demo.sys.linearsearch.LinearSearch2;

import java.util.Arrays;

/**
 * 描述: 选择排序--支持泛型
 * 循环不变量为以下的实现方式
 * arr[i...n)未排序  arr[0...i) 已排序
 *
 * @Author: zhangchao
 * @Date: 8/11/20 11:51 下午
 **/
public class SelectionSortReverse {
    public static <E extends Comparable> void   sort(E [] arr){
        for (int i = arr.length-1; i>=0; i--){
            int maxIdx = i;
            for (int j =i; j>=0; j--){
                if (arr[j].compareTo(arr[maxIdx])>0){
                    maxIdx = j;
                }
            }
            swap(arr,i,maxIdx);
        }
    }

    private static <E extends Comparable>  void swap(E [] arr, int i, int targetIndex) {
        E temp = arr[i];
        arr[i] = arr[targetIndex];
        arr[targetIndex] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {11,5,59,11,3,8,18};
        sort(arr);
        System.out.println(Arrays.toString(arr));



        LinearSearch2.User[] arrUser = new LinearSearch2.User[]{new LinearSearch2.User("张三",1),
                new LinearSearch2.User("李四",10),
                new LinearSearch2.User("王五",15),
                new LinearSearch2.User("赵六",12),
                new LinearSearch2.User("rose",19),
                new LinearSearch2.User("jack",18),
        };
        sort(arrUser);
        for (LinearSearch2.User user : arrUser) {
            System.out.println(user);
        }
    }

}

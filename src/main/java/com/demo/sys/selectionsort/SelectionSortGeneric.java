package com.demo.sys.selectionsort;

import com.demo.sys.linearsearch.LinearSearch2;

import java.util.Arrays;

/**
 * 描述: 选择排序--支持泛型
 *
 * @Author: zhangchao
 * @Date: 8/11/20 11:51 下午
 **/
public class SelectionSortGeneric {
    public static <E extends Comparable> void   sort(E [] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) <=0){
                    minIndex =j;
                }
            }
            //交换位置
            if (minIndex != i){
                swap(arr,i,minIndex);
            }
        }
    }

    private static <E extends Comparable>  void swap(E [] arr, int i, int minIndex) {
        E temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
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

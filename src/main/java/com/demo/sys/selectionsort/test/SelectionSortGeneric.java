package com.demo.sys.selectionsort.test;

import com.demo.sys.util.ArrayGenerator;
import com.demo.sys.util.SortingHelper;

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
        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }

}

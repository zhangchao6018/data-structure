package com.demo.sys.selectionsort;

import java.util.Arrays;

/**
 * 描述:
 *
 * @Author: zhangchao
 * @Date: 8/11/20 11:51 下午
 **/
public class SelectionSort {
    public  void sort(int[] arr){
        //1.新建数组排序
        //newArr(arr);
        //2.1 原地排序(不新建数组)
        //selfSortWhileLoop(arr);
        //2.2 双重循环
        selfSortDoubleLoop(arr);
    }

    private void selfSortDoubleLoop(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j]<= arr[minIndex]){
                    minIndex =j;
                }
            }
            //交换位置
            if (minIndex != i){
                swap(arr,i,minIndex);
            }
        }

    }

    private void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    private void selfSortWhileLoop(int[] arr) {
        int index = 0;
        while (index < arr.length){
            //当前循环最小的索引值
            int minIdx = -1;
            //当前循环拿到的最小的值
            int minVal = Integer.MAX_VALUE;
            for (int i = index; i < arr.length; i++) {
                if (arr[i]<=minVal){
                    minIdx =i;
                    minVal = arr[i];
                }
            }
            //循环结束 交换位置
            int temp = arr[index];
            arr[index] =minVal;
            arr[minIdx] =temp;
            index++;
        }
    }

    private void newArr(int[] arr) {
        int[] sortedArr = new int[arr.length];
        //遍历的次数,也即排序树组当前索引
        int index = 0;

        while (index<arr.length){
            int min = Integer.MAX_VALUE;
            int perIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]<=min){
                    min = arr[i];
                    perIndex=i;
                }
            }
            sortedArr[index] = min;
            arr[perIndex] = Integer.MAX_VALUE;
            index++;
        }

        //赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {11,5,59,11,3,8,18};
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}

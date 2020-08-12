package com.demo.sys.linearsearch;

/**
 * 描述:
 * 最简单的线性查找
 *
 * 输入一个数组和一个元素,返回数组中该元素的索引,不存在返回-1
 * @Author: zhangchao
 * @Date: 8/10/20 10:13 上午
 **/
public class LinearSearch {
    private LinearSearch(){

    }
    public static int solution(int[] arr , int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = new int []{1,8,10,5,44,78,23,3,9,21};
        int target = 21;
        System.out.println(LinearSearch.solution(arr, target));
    }
}

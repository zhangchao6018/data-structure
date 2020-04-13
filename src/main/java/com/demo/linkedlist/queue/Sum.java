package com.demo.linkedlist.queue;

/**
 * @描述: 用递归的方式求和数组
 * @author: zhangchao
 * @date: 4/12/20 12:55 下午
 **/
public class Sum {
    public static int  sum(int[] arr){
//        if (arr.length<1){
//            return 0;
//        }
        int result = 0;
        int[] smallArr = new int[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            result = arr[0];
            if (i!=0){
                smallArr[i-1] = arr[i];
            }
        }
        if (smallArr.length>0){
            result += sum(smallArr);
        }
        return result;
    }

    public static int  sum2(int[] arr){
        return smallSum(arr,0);
    }

    private static int smallSum(int[] arr, int i) {
        if (arr.length == i)
            return 0;

        int result = arr[i];
        result+=smallSum(arr, i+1);
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int sum = sum2(arr);
        System.out.println(sum);
    }
}

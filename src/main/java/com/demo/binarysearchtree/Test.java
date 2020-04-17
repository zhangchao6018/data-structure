package com.demo.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @Author: zhangchao22
 * @Date: 2020/4/16 13:49
 **/
public class Test {

    public static void  change(List<String> param){
        param = null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        change(list);
        System.out.println(list);
    }
}

package com.demo.sys.linearsearch;

/**
 * 描述:
 * 最简单的线性查找
 *
 * 输入一个数组和一个元素,返回数组中该元素的索引,不存在返回-1
 * @Author: zhangchao
 * @Date: 8/10/20 10:13 上午
 **/
public class LinearSearch2 {
    private LinearSearch2(){
    }
    public static <E> int  solution(E[] arr, E target){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer [] arr = new Integer []{1,8,10,5,44,78,23,3,9,21};
        int target = 21;
        System.out.println( LinearSearch2.solution(arr, target));

        User [] arrUser = new User []{new User("张三",1),
                new User("李四",10),
                new User("王五",15),
                new User("赵六",12),
                new User("rose",19),
                new User("jack",18),
        };
        User targetUser = new User("jack",18);
        System.out.println(LinearSearch2.solution(arrUser, targetUser));

    }
public static class User implements Comparable<User>{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //自定义对象需要重写equals()
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (!(obj instanceof User)){
            return false;
        }
        User toCompare = (User) obj;
        //省去了参数校验...
        return (this.age == toCompare.getAge() && this.name.equals(((User) obj).name));
    }

    @Override
    public int compareTo(User obj) {
//        if (this.getAge()==obj.getAge()){
//            return 0;
//        }
//        if (this.getAge() > (((User) obj).getAge())){
//            return 1;
//        }else {
//            return -1;
//        }
        return this.age-obj.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
}

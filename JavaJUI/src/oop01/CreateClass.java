package oop01;

public class CreateClass {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "张三";
        p1.age = 18;
        p1.show();


        int[] arr = new int[10];
        System.out.println(arr);//地址值?
        char[] arr1;
        String str1= "hello,world!";
        arr1 = str1.toCharArray();
        System.out.println(arr1); //地址值?,Ansewer：打印内容
    }
}

class Person {

    public String name;
    public int age;

    public void show() {
        System.out.println("我的名字是" + name + "，今年：" + age + "岁啦！");
    }

}
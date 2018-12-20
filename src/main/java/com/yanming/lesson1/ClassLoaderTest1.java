package com.yanming.lesson1;

/**
 * @author yanming
 * @version 1.0.0
 * @description
 * @date 2018/12/20 16:30
 **/
public class ClassLoaderTest1 {

    private static ClassLoaderTest1 singletonTest = new ClassLoaderTest1();

    public static int counter1;

    public static int counter2 = 0;



    public ClassLoaderTest1() {
        counter1++;
        counter2++;
    }

    public static ClassLoaderTest1 getSingletonTest() {

        return singletonTest;
    }


    public static void main(String[] args) {

        ClassLoaderTest1 singletonTest = ClassLoaderTest1.getSingletonTest();
        System.out.println(singletonTest.counter1);
        System.out.println(singletonTest.counter2);
    }
}

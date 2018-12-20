package com.yanming.lesson1;


// JVM类加载分为5个过程：加载->链接(验证+准备+解析)->初始化(使用前的准备)->使用->卸载

// 加载：将.class文件（并不一定是.class。可以是ZIP包，网络中获取）中的二进制字节流读入到JVM中

// 连接： 连接分三步： 验证  准备  解析

/**
 * 验证： 验证主要确保加载进来的字节流符合JVM规范
 * 准备：为静态变量在方法区分配内存，并设置默认初始值！
 * 解析：是虚拟机将常量池内的符号引用替换为直接引用的过程
 */

// 初始化：主要是根据程序中的赋值语句主动为类变量赋值，主动赋值语句

class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();
    public static int value1;
    public static int value2 = 0;

    private Singleton1() {
        value1++;
        value2++;
    }

    public static Singleton1 getInstance() {
        return singleton1;
    }

}

/**
 * 1 首先执行main中的Singleton singleton = Singleton.getInstance();
 * 2 类的加载：加载类Singleton
 * 3 类的验证
 * 4 类的准备：为静态变量分配内存，设置默认值。这里为singleton(引用类型)设置为null,value1,value2（基本数据类型）设置默认值0
 * 5 类的初始化（按照赋值语句进行修改）：
 * 执行private static Singleton singleton = new Singleton();
 * 执行Singleton的构造器：value1++;value2++; 此时value1，value2均等于1
 * 执行
 * public static int value1;
 * public static int value2 = 0;
 * 此时value1=1，value2=0
 */

class Singleton2 {
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
        value1++;
        value2++;
    }

    public static Singleton2 getInstance2() {
        return singleton2;
    }

}

/**
 * 1 首先执行main中的Singleton2 singleton2 = Singleton2.getInstance2();
 * 2 类的加载：加载类Singleton2
 * 3 类的验证
 * 4 类的准备：为静态变量分配内存，设置默认值。这里为value1,value2（基本数据类型）设置默认值0,singleton2(引用类型)设置为null,
 * 5 类的初始化（按照赋值语句进行修改）：
 * 执行
 * public static int value2 = 0;
 * 此时value2=0(value1不变，依然是0);
 * 执行
 * private static Singleton singleton = new Singleton();
 * 执行Singleton2的构造器：value1++;value2++;
 * 此时value1，value2均等于1,即为最后结果
 */

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println("Singleton1 value1:" + singleton1.value1);
        System.out.println("Singleton1 value2:" + singleton1.value2);

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);
    }
}


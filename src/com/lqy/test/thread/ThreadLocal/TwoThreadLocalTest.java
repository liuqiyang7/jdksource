package com.lqy.test.thread.ThreadLocal;

/**
 *
 * threadLocal看起来和全局变量没什么区别，但是在并发的情况下，ThreadLocal是线程隔离的，不会出现数据混乱的问题
 *
 * @author liuqy
 * @date 2021/4/18 3:30 下午
 */

public class TwoThreadLocalTest {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        setTwoValue();
//        twoThreadLocal();
        getThreadLocalValue();
    }

    /**
     * 测试设置两个值
     * 后面设置的值会覆盖之前的值
     *
     * 结果
     * aaa
     * bbb
     *
     */
    public static void setTwoValue(){
        threadLocal.set("aaa");
        System.out.println(threadLocal.get());
        threadLocal.set("bbb");
        System.out.println(threadLocal.get());
    }

    /**
     * 测试new出来两个不同的ThreadLocal存储值会怎么样
     *
     * 结果
     * java.lang.ThreadLocal@29453f44
     * java.lang.ThreadLocal@5cad8086
     * pipi
     * 100
     *
     * 结论：一个Thread中可以使用多个ThreadLocal
     *
     */
    public static void twoThreadLocal(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("pipi");
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(100);
        System.out.println(threadLocal);
        System.out.println(threadLocal1);
        System.out.println(threadLocal.get());
        System.out.println(threadLocal1.get());
    }

    /**
     * 配合setTwoValue去测试能不能拿到值
     *
     * 结果：如果说是new一个ThreadLocal对象的话拿到的是null值
     * 如果是直接从上面的全局threadLocal中get的话拿到的值不是空
     *
     * 结论：所以ThreadLocal只能是作为一个线程安全的全局变量来使用
     *
     */
    public static void getThreadLocalValue(){
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        String s = threadLocal.get();
        System.out.println("s = " + s);
    }
}

package com.lqy.test.thread.ThreadLocal;

/**
 *
 * 测试ThreadLocal的基本特性
 *
 * @author liuqy
 * @date 2021/4/17 4:44 下午
 */

public class ThreadLocalSimple {
    private String content;
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static ThreadLocalSimple simple = new ThreadLocalSimple();
    public static void main(String[] args) {
        testMultiThread();
    }

    /**
     * 1.测试多线程操作一个数据的情况下，数据会不会出现混乱
     * 测试结果
     * 线程4--->线程4的数据
     * 线程2--->线程2的数据
     * 线程1--->线程1的数据
     * 线程3--->线程3的数据
     * 线程0--->线程3的数据
     * 结论：会有多线程下的数据不安全的问题
     *
     * 2.测试使用给对象加synchronized锁的方式
     * 结论：数据安全，也可以达到目的，但是比较消耗性能，代码变成了串行，是以时间换空间的方式
     * synchronized比较侧重于多个线程之间访问资源的同步
     *
     * 3.修改get和set方法，使用threadLocal
     * 结论：没有数据错乱的问题,是以空间换时间的方式，可以让程序有更好的并发性，侧重与让多个线程之间相互隔离
     */
    public static void testMultiThread(){
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                simple.setContent(Thread.currentThread().getName()+"的数据");
                System.out.println(Thread.currentThread().getName()+"--->"+simple.getContent());
                //加锁
                /*synchronized (ThreadLocalSimple.class){
                    simple.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println(Thread.currentThread().getName()+"--->"+simple.getContent());
                }*/
            });
            thread.setName("线程"+i);
            thread.start();
        }
    }

    /**
     * 这里修改了get 和 set方法，之前是直接操作content的值，现在把值存储在threadLocal中
     * @return
     */
    public String getContent() {
        return content;
//        return threadLocal.get();
    }
    public void setContent(String content) {
        this.content = content;
//        threadLocal.set(content);
    }
}

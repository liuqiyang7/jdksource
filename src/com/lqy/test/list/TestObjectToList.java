package com.lqy.test.list;

import java.util.*;

/**
 * @author liuqy
 * @date 2021/4/11 6:32 下午
 */

public class TestObjectToList {
    public static void main(String[] args) {
        int i = 1;
        List<Integer> integerList = Collections.singletonList(i);
        Integer[] ins = new Integer[]{1,3,5};
        Iterator<Integer> iterator = integerList.iterator();
        List<Integer> integers = Arrays.asList(i);
        List<Integer> integers1 = Arrays.asList(ins);


        System.out.println("integers = " + integers);
        System.out.println("integerList = " + integerList);
    }
}

package com.cinbo.test;

import java.util.Date;

/**
 * @author chen yinbo
 * @version 1.0
 * @date 2020/8/15 10:49
 */
public class TestMain {

    public static void main(String[] args) {

        date2long();
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        int num = 100000000;
        for (int i = 0; i < num; i++) {
            BubbleSort(9,8,7,6,5,4,3,2,1);
        }
        //打印耗时时间
        System.out.println(System.currentTimeMillis() - start);
    }

    //排序
    public static void BubbleSort(int... arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static long rotateLeft(long i, int distance) {
        return (i << distance) | (i >>> -distance);
    }

    public static void date2long(){
        Date dt = new Date();
        long todtimestamp = dt.getTime();
        todtimestamp = todtimestamp * 1000;
        todtimestamp += 2208988800000000l; //add 70years
        todtimestamp = rotateLeft(todtimestamp,12);
        System.out.println(todtimestamp);
        System.out.println(Long.toString(todtimestamp));
    }
}

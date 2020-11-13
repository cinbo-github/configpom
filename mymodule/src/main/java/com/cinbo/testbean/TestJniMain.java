package com.cinbo.testbean;

import org.springframework.stereotype.Component;

@Component("testJniMain")
public class TestJniMain {

    public native static void HelloWord();

    public native static String cToJava();

    static{
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary( "MyNative" );
    }

    public TestJniMain(){
        HelloWord();
        System.out.println("初始化TestJniMain，String from native:"+cToJava());
    }

    public static void main(String[] args) {
        HelloWord();
        System.out.println(cToJava());

    }
}

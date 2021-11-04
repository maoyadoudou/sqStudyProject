package com.mydd.algorithm;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        boolean flag = mmpi("Hello World");
        if (flag) {
            System.out.println("haha");
        }
    }

    private static Boolean mmpi(String a) {
        return a.length() > 5;
    }
}

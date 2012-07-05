package com.pedronveloso.java.benchs.Utils;

/**
 * User: Pedro Veloso
 * Date: 7/5/12
 * Time: 6:31 PM
 * <p/>
 * Why have a different class from Reflection tests? Because we need to exclude the Virtual Machine warm-up variable.
 */
public class DirectCallTests {

    public static void directCallMethod() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void directCallMethod2() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void directCallMethod3() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void directCallMethod4() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void directCallMethod5() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }
}

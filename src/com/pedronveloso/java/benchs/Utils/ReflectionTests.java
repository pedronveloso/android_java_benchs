package com.pedronveloso.java.benchs.Utils;

/**
 * User: Pedro Veloso
 * Date: 7/5/12
 * Time: 6:10 PM
 * <p/>
 * This class is used to test Direct Calls VS Java Reflection performance and overhead
 */
public class ReflectionTests {

    public static void reflectionMethod() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    // All methods from here on are just to make the # of methods bigger for this class, they are never used really
    // useful for testing ProGuard performance as well.

    public static void reflectionMethod1() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void reflectionMethod2() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void reflectionMethod3() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void reflectionMethod4() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

    public static void reflectionMethod5() {
        //just some random calculations
        int a = 2, b = 3;
        a = a + b;
    }

}

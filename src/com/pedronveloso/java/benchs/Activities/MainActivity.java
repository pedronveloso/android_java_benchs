package com.pedronveloso.java.benchs.Activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.pedronveloso.java.benchs.R;
import com.pedronveloso.java.benchs.Utils.DirectCallTests;
import com.pedronveloso.java.benchs.Utils.ReflectionTests;
import com.pedronveloso.java.benchs.Utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private long startTime;
    private static final int CARDINAL_RUN_LOOPS = 1000;
    private static final int ARRAY_SIZE = 10000;

    private ArrayList<Integer> dummyArray;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new TestReflectionCalls().execute(1);
    }

    /**
     * Reflection method call
     */
    private class TestReflectionCalls extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {
            Utils.debugFunc("will now test Reflection calls to a class.", Log.VERBOSE);
            startTime = System.currentTimeMillis();
            try {
                Method m;
                for (int i = 0; i < CARDINAL_RUN_LOOPS; i++) {
                    m = ReflectionTests.class.getDeclaredMethod("reflectionMethod");
                    m.invoke(null);
                }

            } catch (NoSuchMethodException e) {
                Utils.debugFunc("Reflection test failed! NoSuchMethodException.", Log.ERROR);
            } catch (InvocationTargetException e) {
                Utils.debugFunc("Reflection test failed! InvocationTargetException.", Log.ERROR);
            } catch (IllegalAccessException e) {
                Utils.debugFunc("Reflection test failed! IllegalAccessException.", Log.ERROR);
            }
            return 0;
        }


        protected void onPostExecute(Integer result) {
            Utils.debugFunc(CARDINAL_RUN_LOOPS + " Reflection method calls took: " + (System.currentTimeMillis() - startTime), Log.DEBUG);
            new TestDirectCalls().execute(1);
        }
    }


    /**
     * Direct method call
     */
    private class TestDirectCalls extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {
            Utils.debugFunc("will now test Direct calls to a class.", Log.VERBOSE);
            startTime = System.currentTimeMillis();
            for (int i = 0; i < CARDINAL_RUN_LOOPS; i++) {
                DirectCallTests.directCallMethod();
            }
            return 0;
        }


        protected void onPostExecute(Integer result) {
            Utils.debugFunc("Direct method calls took: " + (System.currentTimeMillis() - startTime), Log.DEBUG);
            new TestSimpleForLoop().execute(1);
        }
    }


    /**
     * Simple For Loop
     */
    private class TestSimpleForLoop extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {
            //fill the array once
            dummyArray = new ArrayList<Integer>(ARRAY_SIZE);
            for (int i = 0; i < ARRAY_SIZE; i++) {
                dummyArray.add(0);
            }
            Utils.debugFunc("will now test Simple For Loop.", Log.VERBOSE);
            startTime = System.currentTimeMillis();
            for (int i = 0; i < ARRAY_SIZE; i++) {
                dummyArray.set(i, 1);
            }
            return 0;
        }


        protected void onPostExecute(Integer result) {
            Utils.debugFunc("Simple For Loop took: " + (System.currentTimeMillis() - startTime), Log.DEBUG);
            new TestForEachLoop().execute(1);
        }
    }


    /**
     * Simple For Loop
     */
    private class TestForEachLoop extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {
            Utils.debugFunc("will now test For Each Loop.", Log.VERBOSE);
            startTime = System.currentTimeMillis();
            for (Integer elem : dummyArray) {
                elem = 2;
            }
            return 0;
        }


        protected void onPostExecute(Integer result) {
            Utils.debugFunc(CARDINAL_RUN_LOOPS + " For Each Loop took: " + (System.currentTimeMillis() - startTime), Log.DEBUG);
        }
    }
}

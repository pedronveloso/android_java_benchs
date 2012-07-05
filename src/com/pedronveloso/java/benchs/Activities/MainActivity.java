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

public class MainActivity extends Activity {

    private long startTime;
    private static final int CARDINAL_RUN_LOOPS = 10000;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new TestReflectionCalls().execute(1);
    }

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
            Utils.debugFunc(CARDINAL_RUN_LOOPS + " Direct method calls took: " + (System.currentTimeMillis() - startTime), Log.DEBUG);
        }
    }
}

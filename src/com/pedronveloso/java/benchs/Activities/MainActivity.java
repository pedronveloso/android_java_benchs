package com.pedronveloso.java.benchs.Activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import com.pedronveloso.java.benchs.R;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    private class TestReflectionCalls extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {
            return 0;
        }


        protected void onPostExecute(Long result) {
        }
    }
}

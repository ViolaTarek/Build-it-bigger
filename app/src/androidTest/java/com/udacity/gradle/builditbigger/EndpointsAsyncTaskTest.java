package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    String testResultString = null;

    @Test
    public void testTask() {

        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext());
        task.setListner(new EndpointsAsyncTask.taskListener() {
            @Override
            public void onComplete(String resultString) {
                if (!resultString.equals(""))
                    testResultString = resultString;
            }
        }).execute();

        try {
            String result =task.execute().get();
            assertNotNull(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
package com.udacity.gradle.builditbigger;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.InstrumentationInfo;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.example.jokesandroidlibrary.JokesActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;



import java.io.IOException;

import static android.content.ContentValues.TAG;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>,Void,String> {
    public static MyApi myApiService = null;
    private Context context;
    private String text;
    private taskListener mListner;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.7:1234/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJokeService().execute().getData();
        } catch (IOException e) {
            Log.d(TAG,e.getMessage());
            return "Can not load joke right now, Try again later! :D ";

        }
    }




    @Override
    protected void onPostExecute(String result) {
        try {
            if (mListner != null)
                this.mListner.onComplete(result);
        }catch (Exception e){
            e.printStackTrace();
            this.mListner.onComplete("");
        }

        Intent intent = new Intent(context, JokesActivity.class);
            intent.putExtra("gce_result", result);
        context.startActivity(intent);
    }

    public static interface taskListener{
        public void onComplete(String resultString);
    }

    public EndpointsAsyncTask setListner(taskListener listner){
        this.mListner = listner;
        return this;
    }


}
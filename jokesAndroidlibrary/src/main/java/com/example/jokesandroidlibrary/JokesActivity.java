package com.example.jokesandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, JokesFragment.newInstance())
                    .commitNow();
        }

    }
}

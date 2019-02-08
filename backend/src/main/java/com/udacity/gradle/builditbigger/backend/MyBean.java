package com.udacity.gradle.builditbigger.backend;


import com.example.jokesjavalib.JokeClass;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        JokeClass jokeClass = new JokeClass();
        myData = jokeClass.getJokes();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}
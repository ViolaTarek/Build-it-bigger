package com.example.jokesjavalib;

import java.util.Random;

public class JokeClass {
    private String jokes[]={"Doctor: I'm sorry but you suffer from a terminal illness and have only 10 to live.\n Patient: What do you mean, 10? 10 what? Months? Weeks?! \n Doctor: Nine.",
            "Wife: It’s our wedding anniversary in a week, darling. How do you think we should celebrate? \n- Husband: With a minute of silence."
            ,"What would 0 say to 8 ? - Nice belt "
            ,"Why is 6 afraid of 7? -Because 7 is a registered 6 offender."
            ,"What do you call a magic dog? A labracadabrador."
            ,"I used to be addicted to soap, but I'm clean now :'D"
    };

    public String getJokes() {
        Random random = new Random();

        String randomJoke = jokes[random.nextInt(jokes.length)];

        return  randomJoke;
    }

    public JokeClass() {
    }
}

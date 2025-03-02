package org.example;

import java.util.Arrays;

public class Player {
    int attempts;
    String[] guesses = {"","","","",""};

    Player(){
        attempts = 0;
    }
    void addAttempt(){
        this.attempts +=1;
    }
    void addGuess(String guess){
        this.guesses[this.attempts-1] = guess;
    }
    void reset(){
        this.attempts = 0;
        Arrays.fill(this.guesses,"");
    }
}

package org.example;

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
}

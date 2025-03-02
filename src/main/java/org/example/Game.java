package org.example;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    boolean gameActive;
    Scanner scanner = new Scanner(System.in);
    Player p = new Player();
    Word w = new Word();
    String userGuess;
    ArrayList<String> words = new ArrayList<String>();

    void askToPlayAgain(){
        System.out.println("Do you wish to play again? y/n");
        String answer = scanner.nextLine();
        if(!answer.equals("y")){
            this.gameActive = false;
        }else{
            p.reset();
            startGame();
        }
    }
    void startGame(){
        JsonNode data = JsonFileReader.readJsonFromFile("words.json").get("words");
        if (data.isArray()) {
            for (JsonNode word : data) {
                words.add(word.asText());
            }
        }
        w.selectWord(words);
        this.gameActive = true;
        while(gameActive){
            do {
                System.out.println("Enter your guess: ");
                if(p.attempts > 0){
                    for(int i =0; i < p.attempts; i++){
                        w.checkCharacters(p.guesses[i]);
                        System.out.println();
                    }
                }
                int linesToPrint = 5 - p.attempts;
                for(int i = 0; i < linesToPrint; i++){
                    System.out.println("_"+"_"+"_"+"_"+"_");
                }
                userGuess = scanner.nextLine();
                while(userGuess.length() != 5 ){
                    System.out.println("Input needs to be 5 characters long, please re-enter a word");
                    userGuess = scanner.nextLine();
                }
                p.addAttempt();
                p.addGuess(userGuess);
            } while (!userGuess.equals(w.correctWord) && p.attempts < 5);

            if(userGuess.equals(w.correctWord)){
                System.out.println(
                        ConsoleColors.GREEN+"Congratulations, you won the game in "+p.attempts+ " "+ "tries!"+
                                ConsoleColors.RESET + "");

            }else{
                System.out.println(ConsoleColors.RED+"Game Over! You lost!"+ConsoleColors.RESET + "");
                System.out.println(ConsoleColors.RED+"The word was "+ w.correctWord + ConsoleColors.RESET + "");
            }

            askToPlayAgain();
        }
    }
}

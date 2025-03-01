package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player p = new Player();
        Word w = new Word();
        String userGuess;
        System.out.println(p.attempts);
        ArrayList<String> words = new ArrayList<String>();

        JsonNode data = JsonFileReader.readJsonFromFile("words.json").get("words");
        if (data.isArray()) {
            for (JsonNode word : data) {
                words.add(word.asText());
            }
        }
        w.selectWord(words);
        System.out.println(w.correctWord);

        do {
            if(p.attempts > 0){
                for(int i =0; i < p.attempts; i++){
                    //System.out.println(p.guesses[i]);
                    w.checkCharacters(p.guesses[i]);
                    System.out.println();
                }
            }
            int linesToPrint = 5 - p.attempts;
            for(int i = 0; i < linesToPrint; i++){
                System.out.println("_"+"_"+"_"+"_"+"_");
            }
            userGuess = scanner.nextLine();
            p.addAttempt();
            p.addGuess(userGuess);
        } while (!userGuess.equals(w.correctWord) && p.attempts < 5);

        if(userGuess.equals(w.correctWord)){
            System.out.println("Congratulations, you won the game in "+p.attempts+ " "+ "tries!");
        }else{
            System.out.println("Game Over! You lost!");
        }


    }
}
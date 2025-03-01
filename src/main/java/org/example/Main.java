package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player p = new Player();
        Word w = new Word();
        System.out.println(p.attempts);
        ArrayList<String> words = new ArrayList<String>();

        JsonNode data = JsonFileReader.readJsonFromFile("words.json").get("words");
        if(data.isArray()) {
            for( JsonNode word : data) {
                words.add(word.asText());
            }
        }
        System.out.println(words);
        w.selectWord(words);
        System.out.println(w.correctWord);


    }
}
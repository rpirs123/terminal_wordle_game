package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void shouldSelectAWordWithFiveLetters(){
        Word word = new Word();
        ArrayList<String> words = new ArrayList<>();
        words.add("prügi");
        words.add("hei");
        words.add("tere");
        word.selectWord(words);
        assertEquals(5, word.correctWord.length());
    }
}
package org.example;

import java.util.ArrayList;

public class Word {
    String correctWord;

    void selectWord(ArrayList<String> arr){

        int index = (int)(Math.random() * arr.size());
        System.out.println("index "+ index);
        System.out.println("selected word:  "+ arr.get(index));
        this.correctWord = arr.get(index);
    }
}

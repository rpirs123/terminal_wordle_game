package org.example;

public class Word {
    String correctWord;

    void selectWord(String[] arr){

        int index = (int)Math.random() * (arr.length + 1) ;
        this.correctWord = arr[index];
    }
}

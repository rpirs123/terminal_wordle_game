package org.example;

import java.util.ArrayList;

public class Word {
    String correctWord;

    void selectWord(ArrayList<String> arr){
        int index = (int)(Math.random() * arr.size());
        System.out.println("selected word:  "+ arr.get(index));
        this.correctWord = arr.get(index);
    }
    void checkCharacters(String word){
        for(int i =0; i != word.length(); i++){
            char c = word.charAt(i);
            char cMain = this.correctWord.charAt(i);
            if(c == cMain){
                System.out.print(ConsoleColors.GREEN +c + ConsoleColors.RESET + "");
            }else if(this.correctWord.contains(String.valueOf(c))){
                System.out.print(ConsoleColors.YELLOW +c + ConsoleColors.RESET + "");
            }else{
                System.out.print(ConsoleColors.RED + c + ConsoleColors.RESET + "");

            }
        }
    }
}

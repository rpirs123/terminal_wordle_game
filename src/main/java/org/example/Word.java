package org.example;

import java.util.ArrayList;

public class Word {
    String correctWord;

    void selectWord(ArrayList<String> arr){

         do{
           int index = (int)(Math.random() * arr.size());
            this.correctWord = arr.get(index);
       }while(this.correctWord.length() != 5);

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

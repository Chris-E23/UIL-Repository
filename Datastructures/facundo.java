package Datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class facundo {

    public static void main(String[] args) throws FileNotFoundException{

        Scanner s = new Scanner(new File("Datastructures\\facundo.dat"));
        int lines = Integer.parseInt(s.nextLine());
        while(s.hasNext()){
            System.out.println(shuffle(s.next(), Integer.parseInt(s.next())));
        }
    }

    public static String shuffle(String deck, int shuffleAmount){
        String[] cards= deck.split("");    
        String[] arr = new String[cards.length];
        for(int d = 0; d < shuffleAmount; d++){
             for(int i = 0; i < deck.length(); i++){
               arr[i] = arr[i];
               arr[i+1] = arr[arr.length/2+1];
               
            }
    }
        String thing = "";
        for(String s : arr){
            thing += s;
        }
    
        return thing;
    }
   
    
}

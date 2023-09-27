package Datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class facundo {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner s = new Scanner(new File("Datastructures\\facundo.dat"));
        int lines = Integer.parseInt(s.nextLine());
        while(s.hasNext()){
            String h = s.next();
            int num = Integer.parseInt(s.next());
            for(int i = 0; i < num; i++){
                h = shuffle(h);
            }
           System.out.println(h);
        }
    }
    public static String shuffle(String deck){
        int length = 0;
        String cards = "";
         if(deck.length()%2 == 0){
            length = deck.length()/2;
            String holder = deck.substring(0, length-1);
            holder += deck.substring(length);
            holder += deck.substring(length-1, length);
            for(int i = 0; i < length; i++){
                cards += holder.substring(i+length-1, i+length);
                if(i != length-1)
                    cards += holder.substring(i,i+1);
            }
            cards += deck.substring(length-1, length);
            }
        else{
                length = deck.length()/2;
                String holder = deck.substring(0, length);
                holder += deck.substring(length+1);
                holder += deck.substring(length, length+1);
                 for(int i = 0; i < length; i++){
                    cards += holder.substring(i,i+1);
                    cards += holder.substring(i+length, i+length+1);
            }
            cards += deck.substring(length, length+1);
            } 
        return cards;
    }
   
    
}

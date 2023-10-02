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
        int length = deck.length()/2;
        String cards = "";
        String holder = ((deck.length() & 1) == 1) ? deck.substring(0, length) + deck.substring(length+1) + deck.substring(length, length+1) : deck.substring(0, length-1) + deck.substring(length) + deck.substring(length-1, length);
         for(int i = 0; i < length; i++){
                if(((deck.length() & 1) == 1)){
                    cards+=holder.substring(i, i+1) + holder.substring(i+length, i+length+1);
                }
                else{
                    cards += holder.substring(i+length-1, i+length);
                if(i != length-1)
                    cards += holder.substring(i,i+1);
                }
            }
            cards += ((deck.length() & 1) == 1) ? deck.substring(length, length+1) : deck.substring(length-1, length);
        return cards;
    }
}

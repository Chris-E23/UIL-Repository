package Datastructures;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Haru {
    
   public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("Datastructures\\haru.dat"));

        //for loop checking 
        int length = Integer.parseInt(s.nextLine());
      
        
        while(s.hasNext()){
            ArrayList<int[]> spikecoords = new ArrayList<>();
            int i = Integer.parseInt(s.next());
            System.out.print(i);
            int[][] coords1 = new int[i][2];
            int[] one = {Integer.parseInt(s.next()), Integer.parseInt(s.next())};
            coords1[0] = one;
            String d1 = s.next();
           int[][] coords2 = new int[i][2];
            int[] two = {Integer.parseInt(s.next()), Integer.parseInt(s.next())};
            coords2[0] = two;
            String d2 = s.next();
           
            System.out.print(Arrays.toString(coords1));

            for(int d = 1; d < i; d++){
                switch(d1.substring(d, d+1)){
                    case "D":
                        int[] newcoords1 = {coords1[d-1][0], coords1[d-1][1]-1};
                        System.out.println(Arrays.toString(coords1));
                        System.out.println
                }
                
                    

            }
            
            



        }

   }
}

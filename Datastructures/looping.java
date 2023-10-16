package Datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class looping {
    
    public static void main(String[] args){

        int thing3 = 0;
        do{
            thing3 += 1;
            System.out.println(thing3);
        }
        while(thing3 == 1);
        int thing = 1;

        switch(thing){
            case 1:
            System.out.println("this is 1");
                break;
            
            default:
                break;
        }

        for(int i = 0; i < 10; i++){
          
            /*if(i == 3){
             continue;  
            //System.out.println(thing2);
            }
            */

            //System.out.println(i);
              String thing2 = (i%2 == 0) ? "even" : "odd";
              System.out.println(thing2);
        }

        int[] arr = {4,3,6,1,2};
       
        //Arrays.sort(arr);
        
        
        for(int d : arr){
            System.out.println(d);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(1);

        Collections.sort(list);

        System.out.print(list);


        

    }
}

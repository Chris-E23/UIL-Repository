package Datastructures;

import java.util.*;

public class lists {
    
    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(4);
        int[] arr = new int[list.size()];
        int i =0;
        for(Integer s : list){
           
            System.out.println(s);
            arr[i] = s;
            i++;
        }
        
        System.out.println(Arrays.toString(arr));
        




    }
}

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;
public class run{

    public static void main(String[] args) throws IOException{ 
        Scanner s = new Scanner(new File("arusha.dat"));
        int testcases = Integer.parseInt(s.nextLine());
        

        for(int i = 0; i < testcases; i++){
            String edit = s.next();
            String arrange = s.next();
            
            for(int d =0; d < arrange.length(); d++){

                switch(arrange.substring(d, d+1)){

                    case "L":
                        edit = edit.substring(1) + edit.substring(0,1);
                       
                        break;
                    case "R":
                         edit = edit.substring(edit.length()-1) + edit.substring(0, edit.length()-1);
                         break;

                }

            }
             out.printf("\n%s", edit);


        }

        

            
    }


} 
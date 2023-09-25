package regularexpressions; //never have packages in actual UIL competitions

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.util.regex.Matcher; 
public class emailchallenge {
    

    public static void main(String[] args) throws FileNotFoundException{

        Scanner s = new Scanner(new File("regularexpressions\\emails.txt"));

        ArrayList<String> lines = new ArrayList<>();

        while(s.hasNextLine()){
            lines.add(s.nextLine());
        }
        
        for(int i = 0; i < lines.size(); i++){
            Pattern p = Pattern.compile("^([a-zA-Z0-9\\._-])+@([a-zA-Z]+)\\.([a-zA-z]+)$"); //always have fricking anchors, because this code doesn't work without them.
            Matcher m = p.matcher(lines.get(i));
            boolean matchfound = m.find();
            if(matchfound)
                System.out.printf("\n%s", lines.get(i));
            

        }


    }
}

package regex;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import regex.regex;
public class emailchallenge {
    
    public static void main(String args[]) throws FileNotFoundException{
         Scanner s = new Scanner(new File("C:\\Users\\chris_3pokugv\\Documents\\uilrepo\\UIL-Repository\\regex\\emails.txt"));
         ArrayList<String> emails = new ArrayList<>();

         while(s.hasNext()){
            emails.add(s.next());
         }

         for(int i =0; i <emails.size(); i++){
              Pattern p = Pattern.compile(emails.get(i));

         }
         



    }
   


}

package regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    

    public static void main(String[] args){
    
    String[] numbers = {"914.582.3013", "873.334.2589", "521.589.3147", "625.235.3698", "895.568.2145", "745.256.3369"};
    String[] dates = {"Jan 5th 1987", "Dec 26th 2010", "Mar 2nd 1923", "Oct 1st 2008", "Aug 3rd 2009", "June 10th 2001"};
   
    for(int i = 0; i < numbers.length; i++){
        Pattern p = Pattern.compile("[0-9]{3}\\.");
        Matcher m = p.matcher(numbers[i]);
        boolean found = m.matches();
        String newline; 
        newline = m.replaceAll("xxx.");
        System.out.println(newline);
        
        
    }
    for(String date : dates){
        Pattern p2 = Pattern.compile("([a-zA-Z]{3})\s([0-9]{1,2})[a-z]{2}\s[0-9]{2}([0-9]{2})");
        Matcher m2 = p2.matcher(date);
        boolean found = m2.matches();
        String newDate = ""; 
        if(found){
            newDate += m2.group(2) + "-" + m2.group(1) + "-" + m2.group(3);
            System.out.println(newDate);

        }

    }
        

    }

}

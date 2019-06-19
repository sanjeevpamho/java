package way.to.go.commonProblems;
import java.io.*;
import java.util.regex.*;

public class PhnSplitRegEx {

    public static void main(String[] args) throws IOException{
        
        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("\n Enter number of lines : ");
        int n = Integer.parseInt(dis.readLine());

        
        String regex = "-| ";
        
        for(int i=0; i<n; i++){

           System.out.print("\n Enter a phn no : ");
           String srchStr = dis.readLine();
            //Pattern p = Pattern.compile(regex);
           // Matcher m = p.matcher(srchStr);

           String[] group = srchStr.split(regex);
            
           System.out.print("Countrycode="+group[0]+",LocalAreaCode="+group[1]+",Number="+group[2]);
            

        }

        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
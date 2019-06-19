package way.to.go.commonProblems;
import java.io.*;
import java.util.regex.*;

public class PanRegEx {

    public static void main(String[] args) throws IOException{
        
        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("\n Enter number of lines : ");
        int n = Integer.parseInt(dis.readLine());
        
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]";
        
        for(int i=0; i<n; i++){

           System.out.print("\n Enter PAN Number : ");
           String srchStr = dis.readLine();
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(srchStr);
            
            boolean isFound = false;

            while(m.find()){
                isFound = true;
            }
            
            if(!isFound){
                System.out.print("No\n");
            }else{
                System.out.print("Yes\n");
            }
            

        }
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
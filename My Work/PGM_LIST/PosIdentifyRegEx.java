package way.to.go.commonProblems;
import java.io.*;
import java.util.regex.*;

public class PosIdentifyRegEx {

    public static void main(String[] args) throws IOException{
        
        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("\n Enter number of lines : ");
        int n = Integer.parseInt(dis.readLine());
        
        String regex = "hackerrank";
        
        for(int i=0; i<n; i++){

           System.out.print("\n Enter a sentance : ");
           String srchStr = dis.readLine();
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(srchStr);

            int start = 0;
            int end = 0;
            
            boolean isFound = false;

            while(m.find()){
                System.out.print("\n String "+m.group()+" found at start index "+m.start()+" and ending at "+m.end()+"\n");
                isFound = true;

                start = m.start();
                end = m.end();

            }
            if(start==0 && end==srchStr.length()){
               System.out.print("String is at starting at ending 0 \n");
             }
            else if(start==0 && end!=srchStr.length())
             {
               System.out.print("string is at start 1 \n");
             }else if(end == srchStr.length() && start!=0){
               System.out.print("String is at end 2 \n");
             }else if(start!=0 && end!=srchStr.length()){
               System.out.print("scrchStr is neither starting nor ending with string -1 \n");
             }
            
            if(!isFound){
                System.out.print("Not found\n");
            }
            

        }
        
    }
}
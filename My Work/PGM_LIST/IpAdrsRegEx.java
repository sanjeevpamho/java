package way.to.go.commonProblems;
import java.io.*;
import java.util.regex.*;

public class IpAdrsRegEx {

    public static void main(String[] args) throws IOException{
        
        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("\n Enter number of lines : ");
        int n = Integer.parseInt(dis.readLine());
        
        String ipv4regex = "^(25[0-5]|2[0-4][0-9]|[01][0-9]{0,2}|[0-9]{0,2})\\.(25[0-5]|2[0-4][0-9]|[01][0-9]{0,2}|[0-9]{0,2})\\.(25[0-5]|2[0-4][0-9]|[01][0-9]{0,2}|[0-9]{0,2})\\.(25[0-5]|2[0-4][0-9]|[01][0-9]{0,2}|[0-9]{0,2})$";

        String ipv6regex = "^([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}$";
        
        for(int i=0; i<n; i++){

           System.out.print("\n Enter IP Address : ");
           String srchStr = dis.readLine();
            Pattern p = Pattern.compile(ipv4regex);
            Matcher m = p.matcher(srchStr);
            
            boolean isIpv4 = false;
            boolean isIpv6 = false;

            while(m.find()){
                isIpv4 = true;
            }

            p = Pattern.compile(ipv6regex);
            m = p.matcher(srchStr);
            
            while(m.find()){
                isIpv6 = true;
            }
            if(isIpv4){
                System.out.print("IPv4\n");
            }else if(isIpv6){
                System.out.print("IPv6\n");
            }else{
                System.out.print("Neither\n");
            }

        }
        
    }
}
/*Alice has a binary string, B , of length n. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".

In one step, Alice can change a 0 to a 1 (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string
 as beautiful.

Input : 0101010
Output : 2

Input : 01100
Output : 0

Input : 0100101010
Output : 3
*/
package way.to.go.commonProblems;

import java.util.Scanner;

public class BeautifulBinaryString {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
	     int n = in.nextInt();
	     String B = in.next();
	     System.out.println("2--- B : "+B);
	     char[] arr = B.toCharArray();
	     int cnt=0;
	     
	     for(int i=0; i<arr.length-2; i++){
	    	 System.out.println(" i : "+i);
	    	 if(arr[i]=='0' && arr[i+1]=='1' && arr[i+2]=='0'){
	    		 System.out.println("inside 1st if");
	    		 if(i+3!=arr.length && arr[i+3]=='1'){
	    			 System.out.println("in if");
	    			 arr[i+2] = 1;
	    			 cnt++;
	    		 }else{
	    			 System.out.println("in else");
	    			 arr[i+2]=1;
	    			 cnt++;
	    		 }
	    		 i=i+2;
	    	 }
	     }
	     
	     System.out.println("cnt : "+cnt);
		
	}

}

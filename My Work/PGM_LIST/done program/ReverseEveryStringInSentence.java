package way.to.go.commonProblems;

import java.util.Scanner;

public class ReverseEveryStringInSentence {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Enter a string");
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		int cnt = 0;
		int i;
		
		for(i=0; i<arr.length; i++){
			
			if(arr[i] == ' '){
				for(int j=i; cnt>=0; cnt--, j--)
					System.out.print(arr[j]);
				cnt=0;
				System.out.print(" ");
			}else{
				cnt++;
			}
		}
		
		for(int j=arr.length-1; cnt>0;cnt--, j--){
			System.out.print(arr[j]);
		}
	
		
       /* Second way of reversing every string in a sentence without using extra space
        * for(i=0; i<str.length(); i++){
			
			if(str.charAt(i) == ' '){
				for(int j=i; cnt>=0; cnt--, j--)
					System.out.print(str.charAt(j));
				cnt=0;
				System.out.print(" ");
			}else{
				cnt++;
			}
		}
		
		for(int j=str.length()-1; cnt>0;cnt--, j--){
			System.out.print(str.charAt(j));
		}*/
	}

}

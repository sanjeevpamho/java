// Replace every space with '%20'

package way.to.go.commonProblems;

import java.util.Scanner;

public class ReplaceEverySpace {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n Enter a string");
		String str = sc.nextLine();
		int numOfSpace=0;
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == ' ')
				numOfSpace++;
		}
		
		int size = str.length()+2*numOfSpace;
		
		char[] newStr = new char[size];
		
		for(int i=str.length()-1; i>=0; i--){
			if(str.charAt(i) == ' '){
				newStr[--size] = '0';
				newStr[--size] = '2';
				newStr[--size] = '%';
			}else
				newStr[--size] = str.charAt(i);
		}
		
		System.out.println("\n Modified string : ");
		for(int i = 0; i<newStr.length; i++)
			System.out.print(newStr[i]);
	
	}

}

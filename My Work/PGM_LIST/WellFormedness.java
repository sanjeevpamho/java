package way.to.go.commonProblems;

import java.util.Scanner;
import java.util.Stack;

class ValidateWellFormedness{
	char ch,temp;

	
	public void checkWellFormednes(String[] values){
		for(int i=0; i<values.length; i++){
			String s = values[i];
			
            Stack<Character> st = new Stack<Character>();
            boolean isTrue = true;
            for(int j=0; j<s.length(); j++){
                char ch = s.charAt(i);
                if(ch=='(' || ch=='{' || ch=='[')
                    st.push(ch);
                else if(!st.isEmpty()) {
                        char temp = (char)st.pop();
                        if(!((ch==')' && temp=='(') || (ch=='}' && temp=='{') || (ch==']' && temp=='['))){
                           isTrue=false;
                           break;
                    }
                    
                }else{
                    isTrue=false;
                    break;
                }
            }
            if(!st.isEmpty() || !isTrue)
                System.out.println("NO");
            else if(isTrue)
                System.out.println("YES");
        
		}
		 
	}
}

public class WellFormedness {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("\n enter num of strings to be entered : ");
		int n = sc.nextInt();
		
		String[] values = new String[n];
		for(int i=0; i<values.length; i++){
			System.out.print("\n Enter string "+i+" : ");
			values[i] = sc.next();
		}
		

		ValidateWellFormedness validateWellFormedness = new ValidateWellFormedness();
		validateWellFormedness.checkWellFormednes(values);
	}

}

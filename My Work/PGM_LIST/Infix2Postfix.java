package way.to.go.commonProblems;

// running in online IDE

import java.util.*;
import java.io.*;

class StackApplication
{
	int Priority(char ch)
	{
		switch(ch)
		{
		case '$':
		case '^':
			return 3;
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		default:
			return 0;
		}
	}

	boolean isOperator(char ch)
	{
		if(ch=='^' || ch=='$' || ch=='/' || ch=='*' || ch=='+' || ch=='-')
			return true;
		else
			return false; 
	}

	void ConvertInfi2Post(String exp)
	{
		Stack st = new Stack();

		char ch,temp;
		char arr[] = exp.toCharArray();

		System.out.print("\n Postfix equivalent is : ");

		for(int i=0; i<arr.length; i++)
		{
			ch = arr[i];

			if(ch=='(')
                          {
				temp = (Character)st.push(ch);
			  }
			else
			{
				if(isOperator(ch))
				{
					while(!st.empty() && Priority((Character)st.peek())>=Priority(ch))
					{
						System.out.print(st.peek());
						temp = (Character)st.pop();
					}
					temp = (Character)st.push(ch);
				}
				else if(ch==')')
				{
					while(!st.empty() && (Character)st.peek()!='(')
					{
						System.out.print(st.peek());
						temp = (Character)st.pop();
					}
					temp = (Character)st.pop();
				}
				else
					System.out.print(ch);
			}            
		}
		while(!st.empty())
		{
			System.out.print(st.peek());
			temp = (Character)st.pop();
		}
	}
}


class Infix2Postfix
{
  public static void main(String args[]) throws IOException
   {
     DataInputStream dis = new DataInputStream(System.in);

     System.out.print("\n Enter Infix expression :");
     String exp = dis.readLine();

     StackApplication sa = new StackApplication();
     sa.ConvertInfi2Post(exp);

   }
}
package way.to.go.commonProblems;
import java.io.*;

class Stack
{
  int top=-1;

  boolean isUnderFlow()
   {
     if(top==-1)
       return true;
     return false;
   }

  boolean isOverFlow(int sz)
   {
     if(top==sz-1)
       return true;
     return false;
   }

  void Push(int arr[], int val)
   {
	if(!isOverFlow(arr.length))
	 {
           top = top+1;
           arr[top] = val;
           //System.out.print("\n Value pushed into stack : "+val);
	 }
	else
	{
	   System.out.print("\n Stack Overflow!!!");
	}
      // System.out.println("\n");
   }

  int Pop(int arr[])
   {

	if(!isUnderFlow())
	 {
           //System.out.print("\n Value poped out of stack : "+arr[top]);
           top = top-1;
	 }
	else
	{
	   System.out.print("\n Stack Underflow!!!");
	}
       //System.out.println("\n");
   return arr[top+1];
   }

}


class Evaluation
{
   int oprnd1, oprnd2, res;

   boolean isOperator(String str)
    {
	if(str.equals("^") || str.equals("$") || str.equals("/") || str.equals("*") || str.equals("+") || str.equals("-"))
		return true;
	else
		return false; 
    }

   void evaluate(String exp)
   {
	   Stack st = new Stack();

	   String arr[] = exp.split(" ");

	   int stArr[] = new int[arr.length]; 

	   for(int i=0; i<arr.length; i++)
	   {
		   String temp = arr[i];

		   //System.out.print("2-------- arr["+i+"] : "+temp+ "------------ isOperator : "+isOperator(temp));

		   if(isOperator(temp) && st.isUnderFlow())
		   {
			   System.out.print("\n incorrect postfix expression!!!");
			   return;
		   }
		   else if(isOperator(temp))
		   {
			   if(!st.isUnderFlow())
				   oprnd1 = st.Pop(stArr);
			   else
				   return;

			   if(!st.isUnderFlow())
				   oprnd2 = st.Pop(stArr);
			   else
				   return;

			   switch(temp)
			   {
			   case "^":
			   case "$":
				   res = oprnd2^oprnd1;
				   break;
			   case "/":
				   res = oprnd2/oprnd1;
				   break;
			   case "*":
				   res = oprnd2*oprnd1;
				   break;
			   case "+":
				   res = oprnd2+oprnd1;
				   break;
			   case "-":
				   res = oprnd2-oprnd1;
				   break;
			   default:
				   System.out.print("\n Incorrect operator order");
				   return;
			   }
			   st.Push(stArr,res);
		   }
		   else
		   {
			   res = Integer.parseInt(temp);
			   st.Push(stArr,res);
		   }
	   }
	   res = st.Pop(stArr);
	   System.out.print("\n Value of postfix expression : "+res);

   }
}

class PostfixEvaluation
{
  public static void main(String args[]) throws IOException
   {
     Evaluation e = new Evaluation();

     DataInputStream dis = new DataInputStream(System.in);

     System.out.print("\n Enter postfix expression(space between every operator and operand) : ");
     String exp = dis.readLine();

     e.evaluate(exp);

   }
}
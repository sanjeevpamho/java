package way.to.go.commonProblems;

import java.util.*;

class StackTemp
{
  int top=-1;
  int data = 0;

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

  void push(int arr[])
   {
     Scanner sc = new Scanner(System.in);

	if(!isOverFlow(arr.length))
	 {
           System.out.print("\n Enter value : ");
           data = sc.nextInt();
           top = top+1;
           arr[top] = data;
           System.out.print("\n Value pushed into stack : "+data);
	 }
	else
	{
	   System.out.print("\n Stack Overflow!!!");
	}
       System.out.println("\n");
   }

  void pop(int arr[])
   {

	if(!isUnderFlow())
	 {
           System.out.print("\n Value poped out of stack : "+arr[top]);
           top = top-1;
	 }
	else
	{
	   System.out.print("\n Stack Underflow!!!");
	}
       System.out.println("\n");
   }

  void Display(int arr[])
   {
    if(!isUnderFlow())
     {
      System.out.print("\n Top-->");
      for(int temp=top; temp>=0; temp--)
        System.out.print(arr[temp]+" ");
     }
    else
     {
       System.out.print("\n No elements in stack to display");
     }
    System.out.println("\n");
   }
}

class StackImplementaion
{
  public static void main(String args[])
   {
     StackTemp st = new StackTemp();
     Scanner sc = new Scanner(System.in);

     System.out.print("\n Enter size of stack : ");
     int size = sc.nextInt();

     int stArr[] = new int[size];
     int ch = 0;

     do
      {
        System.out.print("\n\t\t Stack Operations");
        System.out.print("\n\t\t   1. Push");
        System.out.print("\n\t\t   2. Pop");
        System.out.print("\n\t\t   3. Display Contents");
        System.out.print("\n\t\t   4. Exit");
        System.out.print("\n\n Enter your choice : ");
        ch = sc.nextInt();

        switch(ch)
         {
	   case 1 :
                st.push(stArr);
		break;
	   case 2 :
		st.pop(stArr);
		break;
	   case 3 :
		st.Display(stArr);
		break;
	   case 4 :
		System.out.print("\n Exiting...");
		System.exit(0);				
	   default:
		System.out.print("\n Invalid input. please provide a correct value");
         }
      }while(ch != 4);
   }
}
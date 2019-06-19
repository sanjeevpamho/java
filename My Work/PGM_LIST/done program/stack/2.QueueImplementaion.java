package way.to.go.commonProblems;

import java.util.*;
  
class Queue
 {
   int front=0;
   int rear=-1;
   int data=0;

   boolean isEmpty()
    {
      if(front==rear+1)
        return true;
      return false;
    }

   boolean isFull(int sz)
    {
      if(rear==sz-1)
        return true;
      return false;
    }

   void Insert(int arr[])
    {
      Scanner sc = new Scanner(System.in);

      if(!isFull(arr.length))
	{
	  System.out.print("\n Enter data : ");
	  data = sc.nextInt();
	  rear = rear+1;
          arr[rear] = data;
	  System.out.print("\n "+data+" inserted\n");
	}
       else
	{
	  System.out.print("\n Queue is full...!!!\n");
	}
    }

   void Delete(int arr[])
    {
      if(!isEmpty())
	{
	  System.out.print("\n "+arr[front]+" deleted\n");
          front = front+1;

	}
       else
	{
	  System.out.print("\n Queue is empty...!!!\n");
	}
    }

   void Display(int arr[])
    {
      if(!isEmpty())
	{
 	  System.out.print("\n Front-->");
	  for(int i=front; i<=rear; i++)
	    System.out.print(arr[i]+" ");
	  System.out.print("<--Rear\n");
	}
       else
	{
	  System.out.print("\n Queue is empty. Nothing to display...\n");
	}
    }
 }

class QueueImplementaion
{
  public static void main(String args[])
   {
     Queue q= new Queue();
     Scanner sc = new Scanner(System.in);

     System.out.print("\n Enter size of queue : ");
     int size = sc.nextInt();

     int qArr[] = new int[size];
     int ch = 0;

     do
      {
        System.out.print("\n\t\t Queue Operations");
        System.out.print("\n\t\t   1. Insert");
        System.out.print("\n\t\t   2. Delete");
        System.out.print("\n\t\t   3. Display Contents");
        System.out.print("\n\t\t   4. Exit");
        System.out.print("\n\n Enter your choice : ");
        ch = sc.nextInt();

        switch(ch)
         {
	   case 1 :
                q.Insert(qArr);
		break;
	   case 2 :
		q.Delete(qArr);
		break;
	   case 3 :
		q.Display(qArr);
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
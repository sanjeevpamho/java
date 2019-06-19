package way.to.go.commonProblems;

import java.io.*;
import java.math.*;
import java.util.*;

class Series
{
  public static void main(String args[]) throws IOException
   {
     Scanner sc = new Scanner(System.in);

     System.out.print("\n Enter number of lines : ");
     int t = sc.nextInt();

     for(int i= 0; i<t; i++)
      {
        System.out.print("\n Enter value of a, b and n : ");
        int a = sc.nextInt();
        int b = sc.nextInt();;
        int n = sc.nextInt();;

        if(n>=1 && n<=15){
        for(int j=1; j<=n; j++)
         {
           int value=0;
           for(int k=0; k<j; k++)
              value = value + (int)(Math.pow(2,k)*b);
           value = a + value;
           System.out.print(value+" ");
         }
        }
       System.out.print("\n");

      }
   }
}
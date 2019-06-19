// count factorial numbers in given range [low, high]
// e.g 2! = 2
// 3! = 6
// 4! = 24

package way.to.go.commonProblems;

import java.util.*;

class CountFactorialInRange
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);

    System.out.print("\n Enter lower limit : ");
    int low = sc.nextInt();

    System.out.print("\n Enter higher limit : ");
    int high = sc.nextInt();

    int fact=1, i=1, res=0;

    while(fact<low)
     {
       fact = fact*i;
       i++;
     }

    System.out.print("\n Factorial numbers in range["+low+" "+high+"] : ");

    while(fact<=high)
     {
       System.out.print(fact+" ");
       res++;
       fact = fact*i;
       i++;
     }

    System.out.print("\n Toatl factorial numbers : "+res);

  }
}
// to count total numbers having 4 as a digit in range 1 to n

package way.to.go.commonProblems;

import java.util.*;

class Count4AsDigit
{
 public static void main(String aregs[])
  {
    Scanner sc = new Scanner(System.in);

    System.out.print("\n Enter number : ");
    int no = sc.nextInt();

    int count = 0;

    for(int j=4; j<=no; j++)
    {
    	int i = j;
    	while(i!=0)
    	{
    		if(i%10 == 4)
    		{
    			count++;
    			break;
    		}
    		i = i/10;
    	}
    }

   System.out.print("\n Total Numbers having 4  as a digit in range[1, "+no+"] : "+count);

  }
}
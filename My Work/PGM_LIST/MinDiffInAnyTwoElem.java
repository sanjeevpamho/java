package way.to.go.commonProblems;

import java.util.Arrays;
import java.util.Scanner;

/*  Given an unsorted array, find the minimum difference between any pair in given array.
 *  Examples : Input : {1, 5, 3, 19, 18, 25}; Output : 1 Minimum difference is between 18 and 19
 */

class FindDifference{

	int minDifference(int arr[], int n)
	{
		for(int i=0; i<n;i++)
			  System.out.print(arr[i]+" ");
		
		int minimum= Integer.MAX_VALUE;
		
		for(int i=n-1; i>0; i--)
		{
			//System.out.println("\n ------------"+arr[i]+"     "+arr[i-1]+"  : "+(arr[i]-arr[i-1]));
			if((arr[i]-arr[i-1])<minimum)
				minimum = arr[i]-arr[i-1];
		}

		return minimum;

	}
}

public class MinDiffInAnyTwoElem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n Enter size of array : ");
		int n = sc.nextInt();

		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			System.out.print("\n Enter elements of array : ");
			arr[i]=sc.nextInt();
		}
		sc.close();

		Arrays.sort(arr);
		
		FindDifference fd = new FindDifference();
		int min = fd.minDifference(arr, n);
		System.out.print("\n----------- minimum difference : "+min);

	}

}

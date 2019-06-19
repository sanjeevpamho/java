package way.to.go.commonProblems;

import java.util.Arrays;
import java.util.Scanner;

/* Given a sorted array of positive integers, rearrange the array alternately 
 * i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.
 * Examples: Input : arr[] = {1, 2, 3, 4, 5, 6, 7} Output : arr[] = {7, 1, 6, 2, 5, 3, 4}

*/

class Rearrangement{
	
	void rearrange(int arr[], int n){
		
		int j,num;
		
		for(int i=0; i<n; i++){

			int temp = arr[i];

			while(temp>0){

				if(i<n/2)
					j=(2*i)+1;
				else
					j=2*(n-i-1);

				if(i==j){
					arr[i] = -temp;
					break;
				}

				num = arr[j];
				arr[j] = temp;
				temp = num;

				arr[j] = -arr[j];
				i=j;

			}

		}

		for(int i=0;i<n; i++)
			arr[i] = Math.abs(arr[i]);

		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");

	}
}

public class ArrayInMaxMinForm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("\n Enter size of array : ");
		//int n = sc.nextInt();
		
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};//new int[n];
		int n = arr.length;
		
		/*for(int i=0; i<n; i++){
			System.out.print("\n Enter elements of array : ");
			arr[i]=sc.nextInt();
		}*/
		sc.close();
		
		//Arrays.sort(arr);
		
		Rearrangement r = new Rearrangement();
		r.rearrange(arr, n);
		
		
	}

}

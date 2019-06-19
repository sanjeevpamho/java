

import java.util.Scanner;

public class GFG {

	public static void main(String[] args) {

		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};

		Scanner sc = new Scanner(System.in);
		System.out.println("\n enter count to reverse array : ");
		int count = sc.nextInt();
		sc.close();


		for(int i=0; i<arr.length; i=i+count){
			int k = count;

			if(i+k > arr.length){
				break;
			}

			for(int j=0; j<k/2 ; j++){
				int temp = arr[i+k-1-j];
				arr[i+k-1-j] = arr[i+j];
				arr[i+j] = temp;
				
			}

		}

		System.out.println();

		for(int i=0; i<arr.length; i++){

			System.out.print(arr[i]+" ");
		}

	
	}

}

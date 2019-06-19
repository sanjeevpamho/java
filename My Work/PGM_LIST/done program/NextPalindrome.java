package way.to.go.commonProblems;

/*Given a number, find the next smallest palindrome larger than this number.
For example, if the input number is “2 3 5 4 5″, the output should be “2 3 6 3 2″.
And if the input number is “9 9 9″, the output should be “1 0 0 1″.
*/

class NextPalindromeUtility{
	
	public boolean isAll9s(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i]!=9)
				return false;
		}
		
		return true;
	}
	
	public void generateNextPalindrome(int arr[]){
		int len = arr.length;


		boolean leftSmaller = false;
		int mid = len/2;
		int i = mid-1;
		int j = (len%2==1)?mid+1:mid;

		//System.out.println("i : "+i+"------ j : "+j);

		while(i>=0 && arr[i]==arr[j]){
			i--;
			j++;
		}

		if(i<0 || arr[i]<arr[j])
			leftSmaller = true;

		while(i>=0){
			arr[j] = arr[i];
			j++;
			i--;
		}

		if(leftSmaller){
			int carry = 1;
			i = mid-1;

			if(len%2 == 1){
				arr[mid] += carry;
				carry = arr[mid] / 10;
				arr[mid] %= 10;
				j = mid + 1;
			}else
				j = mid;

			while(i>=0){
				arr[i] += carry;
				carry = arr[i]/10;
				arr[i] %= 10;
				arr[j] = arr[i];
				j++; i--;
			}
		}


	}
	
}

public class NextPalindrome {

	public static void main(String[] args) {
		//  , {1,2,5,2,1}, {9,9,9}
		int arr[] = new int[]{1,2,5,3,2,2};

		NextPalindromeUtility np = new NextPalindromeUtility();

		if(np.isAll9s(arr)){
			System.out.print("1");
			for(int i=1; i<arr.length; i++)
				System.out.print("0");
			System.out.print("1");
		}else{

			np.generateNextPalindrome(arr);

			System.out.println("Next palindrome : ");
			for(int i=0; i<arr.length; i++)
				System.out.print(arr[i]);

		}
	}

}

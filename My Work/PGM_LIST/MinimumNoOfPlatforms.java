package way.to.go.commonProblems;

import java.util.Arrays;

/*
Given arrival and departure times of all trains that reach a railway station,
find the minimum number of platforms required for the railway station so that no train waits.
*/

class MinimumNoOfPlatformFinder{
	
	int findMinimumNoOfPlatforms(int arr[], int dep[]){
		int noOfPlatforms=1, res=1, i=1, j=0;
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		while(i<arr.length && j<dep.length){
			if(arr[i]<dep[j]){
				res++;
				i++;
				
				if(res>noOfPlatforms)
					noOfPlatforms = res;
				
			}else{
				res--;
				j++;
			}
			
		}
		
		return noOfPlatforms;
	}
}

public class MinimumNoOfPlatforms {

	public static void main(String[] args) {
		
		int arrival[] = new int[]{900, 940, 950, 1100, 1500, 1800};
		int departure[] = new int[]{910, 1200, 1120, 1130, 1900, 2000};
		
		MinimumNoOfPlatformFinder mnp = new MinimumNoOfPlatformFinder();
		System.out.println("Minimum no of platforms required : "+mnp.findMinimumNoOfPlatforms(arrival, departure));

	}

}

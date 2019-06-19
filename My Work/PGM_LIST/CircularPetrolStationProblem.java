// Find the first circular tour that visits all petrol pumps

/*
Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.

1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Calculate the first point from where a truck will be able to complete the circle 
(The truck will stop at each petrol pump and it has infinite capacity)

e.g

input 1 =>

int petrol[]   ={1, 2, 3, 4, 5}
int distance[] ={1, 3, 2, 4, 5}

Output = 3


input 2 =>

int petrol[]   ={4, 6, 7, 4}
int distance[] ={6, 5, 3, 5}

Output = 2


*/
package way.to.go.commonProblems;

public class CircularPetrolStationProblem {

	public static void main(String[] args) {
		
		int[] petrol = {4, 6, 7, 4};
		int[] distance ={6, 5, 3, 5};
		
		if(petrol.length != distance.length)
			return;
		
		int total=0, start=0, avlPetrol=0;
		
		for(int i=0; i<petrol.length; i++){
			int remaining = petrol[i]-distance[i];
			
			if(avlPetrol >= 0){
				avlPetrol += remaining;
			}else{
				avlPetrol = remaining;
				start = i+1;
			}
			
			total += remaining;
		}
		
		if(total >= 0){
			System.out.println("Path exists at starting point : "+start);
		}else{
			System.out.println("Path does not exists");
		}
	}

}

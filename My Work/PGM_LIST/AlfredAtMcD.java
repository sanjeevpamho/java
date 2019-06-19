package way.to.go.commonProblems;

// Alfred has x1, x2, x3 and x4 coins of 1, 2, 5 and 10 respectively. Find out the number of ways in which he can pay a amount of A

class NumOfWaysCalculation{
	int x1, x2, x3, x4, A;
	int numOfWays=0;
	
	public NumOfWaysCalculation(int x1, int x2, int x3, int x4, int A) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.A = A;
	}
	
	public int calculateNumOfWays(){
		
		
		return numOfWays;
	}
}

public class AlfredAtMcD {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,5,10};
		
		NumOfWaysCalculation nc = new NumOfWaysCalculation(10, 10, 10, 10, 5);
		System.out.println("\n Num of Ways : "+nc.calculateNumOfWays());

	}

}

package way.to.go.commonProblems;

import java.math.BigInteger;

public class Factorial100UsingBigInteger {

	public static void main(String[] args) {

		
		BigInteger fact = new BigInteger("1");
		
		for(int i=1; i<=100; i++){
			fact = fact.multiply(new BigInteger(i+""));
		}
		
		System.out.println("fact of 100 : "+fact.toString());
		System.out.println("numbers fact of 100 : "+fact.toString().length());
		
	
	}

}

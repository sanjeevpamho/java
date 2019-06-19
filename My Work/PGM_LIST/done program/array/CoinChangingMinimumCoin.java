package code.bind;


import java.text.Format;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 08/12/2013
 * @author Tushar Roy
 *
 * Given a total and coins of certain denomination with infinite supply, what is the minimum number
 * of coins it takes to form this total.
 *
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 *
 * Youtube video -
 * Bottom up Dynamic Programing Approach
 * https://www.youtube.com/watch?v=NJuKJ8sasGk
 */
public class CoinChangingMinimumCoin {
	/**
	 * Bottom up way of solving this problem.
	 * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
	 * can be very low negative number
	 * Returns Integer.MAX_VALUE - 1 if solution is not possible.
	 * 
	 * T[i]=Min(T[i],1+T[i-coins[j]]);
	 */
	public HashMap minimumCoinBottomUp(int total, int coins[]){
		HashMap< Integer, Integer> hm=new HashMap<Integer, Integer>();
		int T[] = new int[total + 1];
		int R[] = new int[total + 1];
		T[0] = 0;
		for(int i=1; i <= total; i++){
			T[i] = Integer.MAX_VALUE-1;
			R[i] = -1;
		}
		for(int j=0; j < coins.length; j++){
			for(int i=1; i <= total; i++){
				if(i >= coins[j]){
					if (T[i - coins[j]] + 1 < T[i]) {
						T[i] = 1 + T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}

		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return hm;
		}
		int start = R.length - 1;
		System.out.print("Coins used to form total ");
		while ( start != 0 ) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			
			if(hm.containsKey(coins[j])){
				hm.put(coins[j], hm.get(coins[j])+1);
			}
			else
			{
				hm.put(coins[j], 1);
			}
			start = start - coins[j];
		}
		System.out.print("\n");
	
		return hm;
	}

	

	public static void main ( String args[] ) {
		int total = 5;
		int coins[] = {7, 3, 2, 6};

		CoinChangingMinimumCoin cc = new CoinChangingMinimumCoin();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();


		map = cc.minimumCoinBottomUp(total, coins);

		System.out.println("MAP:"+map);
		

	}
}
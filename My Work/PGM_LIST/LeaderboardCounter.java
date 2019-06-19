/* NDTV building an widget for RIO olympics added to their website, where the widget takes an list of entries.
Each entry corresponds to the event final result where countries are given in order as gold, silver and bronze respectively.
You need to build the leaderboard for olympics.

Country which gets more gold, tops the list. If two countries has same number of gold then country with more silver should 
be preferred and so on. COuntries with same number of medals should be displayed in alphabetical order.

Input : First line contains a single number N. Following N lines consists of 3 country codes seperated by space per line.

Output : Display 1 country per line. Print all countries who won the medals.

Sample Input =>
5
USA USR JPN
USA CHN JPN
CHN USA USR
HUN USR USA
AUS HUN CHN


Sample Output =>
USA 2 1 1
CHN 1 1 1
HUN 1 1 0
AUS 1 0 0
USR 0 2 1
JPN 0 0 2
*/

package way.to.go.commonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Country {
	String name;
	int gold, silver, bronze;
	
	Country(){
		name = "";
		gold = 0;
		silver = 0;
		bronze = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	
}

public class LeaderboardCounter {

	public static void main(String[] args) {

		HashMap<String, Country> res = new HashMap<String, Country>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no of lines : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++){
			System.out.println("Enter country codes ");
			String str = sc.nextLine();
			String[] arr = str.split(" ");

			for(int j=0; j<3; j++){
				String cCode = arr[j].toUpperCase();

				if(res.isEmpty() && j==0){
					Country c = new Country();
					c.setName(cCode);
					c.setGold(c.getGold()+1);
					res.put(cCode,c);
				}else{

					Country c;
					if(res.containsKey(cCode)){
						c = res.get(cCode);
					}
					else{
						c = new Country();
						c.setName(cCode);
						res.put(cCode, c);
					}

					if(j==0){
						c.setGold(c.getGold()+1);
					}else if(j==1){
						c.setSilver(c.getSilver()+1);
					}else if(j==2){
						c.setBronze(c.getBronze()+1);
					}
				}	

			}
			
		}
		
		Set<Entry<String, Country>> set = res.entrySet();
		List<Entry<String, Country>> list = new ArrayList<Map.Entry<String,Country>>(set);
		
		Collections.sort(list, new Comparator<Map.Entry<String,Country>>() {
			public int compare(Map.Entry<String,Country> o1, Map.Entry<String,Country> o2){
				
				Country c1 = o1.getValue();
				Country c2 = o2.getValue();
				
				if(c1.getGold() > c2.getGold() || (c1.getGold() == c2.getGold() && c1.getSilver() > c2.getSilver()) 
						|| (c1.getGold() == c2.getGold() && c1.getSilver() == c2.getSilver() && c1.getBronze() > c2.getBronze()))
					return -1;
				else if(c1.getGold() == c2.getGold() && c1.getSilver() == c2.getSilver() && c1.getBronze() == c2.getBronze())
					return 0;
				else
				    return 1;
			}
		});
		
		for(Map.Entry<String, Country> c : list){
			String key = c.getKey();
			Country country = c.getValue();
			System.out.println("\n "+key+" "+country.getGold()+" "+country.getSilver()+" "+country.getBronze());
		}
	}

}



// input = acxz

package way.to.go.commonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class A{
	
	public void meth(){
		System.out.println("in A");
	}
}

class B extends A{
	
	public void meth(){
		System.out.println("in B");
	}
}


class Testing {
	

	public static void main(String args []) throws Exception{
		
		B b = new B();
		b.meth();
		
		/*Map<String, TreeSet<Integer>> m;
		
		
		System.out.println("Minimum : "+Math.min(5, 6));
		*/
		
	/*	HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("anu", new Integer(3));
		map.put("ram", new Integer(5));
		map.put("pritam", new Integer(9));
		map.put("vidya", new Integer(9));
		map.put("haris", new Integer(2));
		map.put("sanjeev", new Integer(3));
		
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				int v1 = o1.getValue();
				int v2 = o2.getValue();
				
				if(v1>v2)
					return 1;
				else if(v1==v2 )
					return 0;
				else
					return -1;
			}
		});
		
		for(Map.Entry<String, Integer> val : list){
			System.out.println(val.getKey()+" : "+val.getValue());
		}
		
		System.out.println("--- : "+list.get(list.size()-1).getKey());
		
	*/	
		/*int a=4;
		int b=0;
		int c;
		
		try{
			c= a/b;
			System.out.println("Try");
		}catch(Exception e){
			System.out.print("Exception");
		}finally{
			System.out.println("Finally");
		}*/
		
		/*try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter a number : ");
			int n = sc.nextInt();
			
			if(n<4 || (n>4 && n<7))
				System.out.println("No");
			else{
				if(n%4==0 || n%4==3 || n%7==0 || n%7==4 || n%11==0 || n%7==4 || n%11==4 || n%11==7 || n%11==8)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			System.out.println("exit");
		}
		*/
		/*String s = "You;had:Had done,this-before.i	do";
		
		String[] str = s.split(" |,|;"); //s.split("[\\s,;:.-]+");
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i=0; i<str.length; i++){
			System.out.println("-------------- str : "+str[i]);
			if(map.containsValue(str[i])){
				System.out.println(" First repeated value : "+str[i]); 
				break;
			}else
				map.put(i, str[i]);
		}
		
		System.out.println("no element is repeated");
		*/
		//long num = System.currentTimeMillis();
		
		
		//System.out.println("2---------- random : "+num%10);
		
		
		
		//System.out.println(no+"  --  "+a);
		
		/*int petrol[] ={1, 2, 3, 4, 5}; //{4, 6, 7, 4};
		int distance[] ={1, 3, 2, 4, 5}; //{6, 5, 3, 5};
		
		if(petrol.length != distance.length)
			return;
		
		int total=0, sumRemaining=0, start=0;
		
		for(int i=0; i<petrol.length; i++){
			
			int remaining = petrol[i] - distance[i];
			
			if(sumRemaining >= 0){
				sumRemaining = sumRemaining + remaining;
			}else{
				sumRemaining = remaining;
				start = i;
			}
			
			total = total + remaining;
		}
		
		if(total >= 0)
			System.out.println("Starting point : "+(start+1));
		else
			System.out.println("No path exists");
	*/	
	}
}

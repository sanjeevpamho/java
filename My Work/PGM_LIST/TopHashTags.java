/***
 *  You will be receiving tweets posted at the end of each hour in the format given below.Write a program to find the top N hashtags
 *  trended for the hour.
 *  
 *  
 *  Input::First line contains two numbers M and N seperated by space,where M is the number of tweets and N is the number of hashtag to 
 *         be displayed in output.
 *         Following M lines contains one tweet(140 Character) per line with or without hashtags.
 *       
 *   Output::Print top N hashtags trende in the tweets (One hashtag per line),where more number of occurance (case insensitive)of hashtag
 *           top the list.
 *           if two hashtag appear same number of times then alphabetical order should be used.
 *           
 *             
 *             
 *     Sample Input::
 *     4 2
       #Rahul century in first match #INDvsWI #TestMatch
       #INDvsWI gonna be #Washout #TestMatch series for #WI #INDRockz
       FIFTY for Wriddhiman Saha! His third int Tests. Gets there in 135 balls!
       #GST passed in parliment. Good move from #INDGov #INDRockZ    
       
       Sample OutPut::
       #INDRockz
       #INDvsWI
 * 
 * 
 ***/

package way.to.go.commonProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TopHashTags {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> res = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		
		int noOfLines = sc.nextInt();
		int noOfOutputString = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<noOfLines; i++){
			String line = sc.nextLine();
			if(line.contains("#")){
				String[] arr = line.split(" ");
				for(int j=0; j<arr.length; j++){
					String str = arr[j];
					if(str.startsWith("#")){
						if(res.containsKey(str)){
							Integer val = res.get(str);
							val = val+1;
							res.put(str, val);
						}else{
							res.put(str, 1);
						}
					}
				}
			}
		}
		
		Set<Entry<String, Integer>> set = res.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {	
				if(o1.getValue()>o2.getValue())
					return -1;
				else if(o1.getValue()==o2.getValue())
					return 0;
				else
					return 1;
			}
		});
		
		int i =0;
		for(Map.Entry<String, Integer> e : list){
			if(i<noOfOutputString)
				System.out.println(e.getKey()+" "+e.getValue());
			else 
				break;
			i++;
		}

	}

}

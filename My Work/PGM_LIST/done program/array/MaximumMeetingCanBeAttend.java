package com.prit.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumMeetingCanBeAttend {
	
	public static void printList(List lista) {
		for(int i=0;i<lista.size();i++) {
			Interval obj=(Interval) lista.get(i);
			System.out.println(obj.start+" "+obj.end);
			
		}
	}
	
	public static void main(String[] args) {
		
	/*	int[] start= {5,2,5};
		int[] end= {7,4,6};*/
		
		/*int[] start= {2,5,7};
		int[] end= {8,6,8};*/
		
		int[] start= {2,3,4,5};
		int[] end= {9,7,8,6};
		
		List<Interval> list=new ArrayList<Interval>();
		for(int i=0;i<start.length;i++) {
			Interval itv=new Interval();
			itv.start=start[i];
			itv.end=end[i];
			list.add(itv);
		}
		System.out.println("Before Sorting.......:::");
		printList(list);
		Collections.sort(list,new Comparator<Interval>() {
	    	
	    	public int compare(Interval obj1,Interval obj2) {
	    		return obj1.start-obj2.start;
	    	}
	    });
	  System.out.println("Sorted List By Start Time..");
	  printList(list);
	  Collections.sort(list,new Comparator<Interval>() {
	    	
	    	public int compare(Interval obj1,Interval obj2) {
	    		return obj1.end-obj2.end;
	    	}
	    });
	  System.out.println("Sorted List By End Time..");
	  printList(list);
	  
	  int count=1;
	  Interval pre=list.get(0);
	  for(int i=1;i<list.size();i++) {
		  Interval curr=list.get(i);
		  
		   if(curr.start>pre.end) {
			   count++;
			   pre=curr;
		   }
	  }
	  
	  System.out.println("Possible Meeting ::"+count);
	  
	  
	}

}

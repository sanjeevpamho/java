/* https://www.youtube.com/watch?v=cr6Ip0J9izc 

if(doNotOverlap then 
T[i]=Math.max(T[i],T[j]+jobs[i].profit);

*/
package code.bind;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Job{
	int start;
	int end;
	int profit;
	Job(int start,int end,int profit){
		this.start= start;
		this.end = end;
		this.profit= profit;
	}
}

class FinishTimeComparator implements Comparator<Job>{
	public int compare(Job arg0, Job arg1) {
		if(arg0.end <= arg1.end){
			return -1;
		}else{
			return 1;
		}
	}

}
public class JobSchedulingMaximumProfit {

	public ArrayList<Job> maximum(Job[] jobs){
		int T[] = new int[jobs.length];
		FinishTimeComparator comparator = new FinishTimeComparator();
		Arrays.sort(jobs, comparator);
		for(int i=0;i<T.length;i++){
			T[i]=jobs[i].profit;
		}
		for(int i=1;i<jobs.length;i++){

			for(int j=0;j<i-1;j++){
				if(jobs[i].start >= jobs[j].end){
					T[i]=Math.max(T[i],T[j]+jobs[i].profit);
				}
			}
		}

		int maxVal = Integer.MIN_VALUE;
		for (int val : T) {
			if (maxVal < val) {
				maxVal = val;
			}
		}
		int pos=-1;
		for(int i=0;i<T.length;i++){
			if(T[i]==maxVal){
				pos=i;
				break;
			}
		}
		int profitLeft=0;
		ArrayList<Job> al=new ArrayList<Job>();
		if(pos != -1){
			al.add(jobs[pos]);
			profitLeft=maxVal-jobs[pos].profit;
			for(int i=0;i<jobs.length && profitLeft >0;i++){
				if(jobs[i].profit ==profitLeft){
					al.add(jobs[i]);
				}
			}

		}
		return al;


	}

	public static void main(String args[]){
		Job jobs[] = new Job[6];
		jobs[0] = new Job(1,3,5);
		jobs[1] = new Job(2,5,6);
		jobs[2] = new Job(4,6,5);
		jobs[3] = new Job(6,7,4);
		jobs[4] = new Job(5,8,11);
		jobs[5] = new Job(7,9,2);
		JobSchedulingMaximumProfit mp = new JobSchedulingMaximumProfit();
		ArrayList<Job> al=mp.maximum(jobs);
		
		
		for(Job job: al){
			System.out.println("(" +job.start+","+job.end+") and profit is:"+job.profit );
		}
		
	}
}
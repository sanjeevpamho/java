import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.chart.XYChart.Series;


public class FileRead {

	static  int count=0;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		File file=new File("src/number_sheet");
		BufferedReader in=null;
		BufferedReader infortotalResult=null;
		in=new BufferedReader(new FileReader(file));
		infortotalResult=new BufferedReader(new FileReader(file));
		Double answer=0.00;
		Double mean=0.00;
		mean=meanFxn(in);
		System.out.println("mean is:::"+mean+":::count is :::"+count);
		answer=seriesSum(infortotalResult, count, mean);
		System.out.println("answer is ::"+answer);

	}
	public static double meanFxn(BufferedReader in) throws Exception{

		String line;
		Double total=0.00;
		while((line=in.readLine())!=null){
			//	System.out.println("line::"+line);

			String[] sub1=line.split(",");
			//	System.out.println("elements are::");			
			for(int i=0;i<sub1.length;i++){
				if(sub1[i].length()==0){
					//	System.out.println("continue here");
					continue;
				}
				//System.out.println(sub1[i]);
				total=total+Double.parseDouble(sub1[i]);
				count++;


			}

		}

		System.out.println("total is::"+total+":::count::"+count);

		return (total/count);
	}
	public static double seriesSum(BufferedReader infortotalResult,int count,Double mean) throws Exception{
		Double my_result=0.00;
		String line;
		//	System.out.println("mean::"+mean);
		while((line=infortotalResult.readLine())!=null){
			String[] commaSplit=line.split(","); 
			for(int i=0;i<commaSplit.length;i++){

				if(commaSplit[i].length()==0){
					continue;
				}
				//	System.out.println(commaSplit[i]);
				my_result=my_result+((Double.parseDouble(commaSplit[i])-mean)*(Double.parseDouble(commaSplit[i])-mean));
			}
		}
		//System.out.println("my_result::"+my_result);
		my_result=(Math.sqrt(my_result))/count;
		return my_result;

	}


}

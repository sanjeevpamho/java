package way.to.go.multithreading;

import java.util.*;



public class TestArray{

void print(int r, int c, int[][] arr){
	int row=r;
	int col=c;
	int rowCnt=0;
	int colCnt=0;
	
	while(rowCnt<row && colCnt<col){
		// print 1st row from remaining rows

		for(int i=colCnt; i<col; i++)
			System.out.println(arr[rowCnt][i]);
		rowCnt++;
		
		// print last col from remaining col
		for(int i=rowCnt; i<row; i++)
			System.out.println(arr[i][col-1]);
		col--;
		
		// print last row from remaining rows
		if(rowCnt<row){
			for(int i=col-1; i>=colCnt; i--)
				System.out.println(arr[row-1][i]);
			row--;
		}
		
		// print 1st col from remaining col
		if(colCnt<col){
			for(int i=row-1; i>=rowCnt;i--)
				System.out.println(arr[i][colCnt]);
			colCnt++;
		}

	}
}
	
	
	
	public static void main(String[] arg)
	{
		int num = 1034;
		System.out.println("p----------- : "+(num & 3));
	}

}

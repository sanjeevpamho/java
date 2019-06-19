package way.to.go.commonProblems;

class SpiralMatrix
{
  int row, col, cntRow, cntCol;

  void print(int r, int c, int arr[][])
  {
    row = r;
    col = c;
    cntRow = 0;
    cntCol = 0;

    while(cntRow < row && cntCol < col)
    {
      // Print 1st row from remaining rows

      for(int i=cntCol; i<col; i++)
        System.out.print(" "+arr[cntRow][i]);
      cntRow++;


      // Print last column from remaining columns

      for(int i=cntRow; i<row; i++)
        System.out.print(" "+arr[i][col-1]);
      col--;


      // Print last row from remaining rows

      if(cntRow<row)
       {
        for(int i=col-1; i>=cntCol; i--)
          System.out.print(" "+arr[row-1][i]);
        row--;
       }


      // Print 1st column from remaining columns

      if(cntCol<col)
       {
         for(int i=row-1; i>=cntRow; i--)
          System.out.print(" "+arr[i][cntCol]);
         cntCol++;
       }
    }
  }
}


class PrintSpiralMatrix
{
  public static void main(String args[])
  {
   int[][] arr = new int[][]{
                             {1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12},
                             {13, 14, 15, 16},
                             {17, 18, 19, 20}
                            };

   System.out.print("\n Number of rows : "+arr.length);
   System.out.print("\n Number of cols : "+arr[0].length);

   System.out.println("\n Entered matrix ==>");

   for(int i=0; i<arr.length; i++)
    {
      System.out.println();
      for(int j=0; j<arr[0].length; j++)
       {
         System.out.print(" "+arr[i][j]);
       }
    }

   System.out.print("\n\n Spiral printing ==> ");
                              
   SpiralMatrix sm = new SpiralMatrix();
   sm.print(arr.length, arr[0].length, arr);
  }
}
package way.to.go.commonProblems;

class RotateMatrixBy180
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

   int row = arr.length;
   int col = arr[0].length;

   System.out.print("\n Number of rows : "+row);
   System.out.print("\n Number of cols : "+col);

   System.out.println("\n Entered matrix ==>");

   for(int i=0; i<row; i++)
    {
      System.out.println();
      for(int j=0; j<col; j++)
       {
         System.out.print(" "+arr[i][j]);
       }
    }

   int[][] trans = new int[row][col];

   for(int i=0; i<row; i++)
    {
      for(int j=0; j<col; j++)
       trans[row-i-1][col-j-1] = arr[i][j];
    } 

   row = trans.length;
   col = trans[0].length; 

   System.out.print("\n\n Number of new rows : "+row);
   System.out.print("\n Number of new cols : "+col); 


  System.out.println("\n\n After 180 clock wise degree rotation ==> ");

  for(int i=0; i<row; i++)
   {
      System.out.println();
      for(int j=0; j<col; j++)
       {
         System.out.print(" "+trans[i][j]);
       }
   }
                              

  }
}
package way.to.go.commonProblems;

class RotateMatrixBy90AntiClock
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

   int[][] trans = new int[col][row];

   for(int i=0; i<col; i++)
    {
      for(int j=0; j<row; j++)
       trans[col-i-1][j] = arr[j][i];
    } 

   row = trans.length;
   col = trans[0].length; 

   System.out.print("\n\n Number of new rows : "+row);
   System.out.print("\n Number of new cols : "+col); 


  System.out.println("\n\n After 90 anticlock wise degree rotation ==> ");

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
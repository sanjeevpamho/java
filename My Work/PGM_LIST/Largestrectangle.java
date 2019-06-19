package way.to.go.commonProblems;
import java.io.*;

class Largestrectangle
{
  public static void main(String args[]) throws IOException
  {
	  DataInputStream dis = new DataInputStream(System.in);

	  System.out.print("\n Enter no of buildings : ");
	  int no = Integer.parseInt(dis.readLine());

	  System.out.print("\n Enter height of buildings : ");
	  String height = dis.readLine();

	  String arr[] = height.split(" ");
	  int max=0, area=1;
	  for(int i=0; i<arr.length; i++)
	  {
		  int count=0;
		  for(int j=i; j<arr.length; j++)
		  {
			  if(Integer.parseInt(arr[i])<=Integer.parseInt(arr[j]))
				  count++;
			  else
				  break;
		  }
		  for(int j=i-1; j>=0; j--)
		  {
			  if(Integer.parseInt(arr[i])<=Integer.parseInt(arr[j]))
				  count++;
			  else
				  break;
		  }

		  area = Integer.parseInt(arr[i]) * count;
		  System.out.print("\n Area : "+area);
		  if(area>max)
			  max = area;
	  }

	  System.out.print("\n Max Area : "+max);
  }
}
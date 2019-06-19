package way.to.go.commonProblems;

import java.io.*;

class StringTokenizer
{
  public static void main(String args[]) throws IOException
   {
     DataInputStream dis = new DataInputStream(System.in);

     System.out.print("\n Enter string : ");
     String str = dis.readLine();

     str = str.trim();
     System.out.print("\n length : "+str.length());

     if(str.length() !=0){
     String regex = "\\s+|[,]{1,}\\s*|[']{1,}\\s*|[?]{1,}\\s*|[.]{1,}\\s*|[!]{1,}\\s*|[@]{1,}\\s*|[_]{1,}\\s*|[ ]{1,}\\s*";
     String arr[] = str.split(regex);
     System.out.print("Length of string : "+arr.length+"\n");

     for(String str1 : arr){
       System.out.print(str1+"\n");
     }
    }else
      System.out.print("0");
   }
}
package way.to.go.commonProblems;

class ArrayMultiplication
{
  int multiply(int i, int arr[], int sz)
   { 
     int carry = 0, fact=1;

     //System.out.print("\n i = "+i);

     for(int j=0; j<sz; j++)
      {
        fact = arr[j] * i + carry;
        arr[j] = fact%10;
        carry = fact/10;
      }

    while(carry!=0)
     {
       arr[sz] = carry%10;
       carry = carry/10;
       sz++;
     }
    return sz;
   }
}

class Factorial100
{
  public static void main(String args[])
  {
    ArrayMultiplication am = new ArrayMultiplication();

    int res[] = new int[160];
    res[0]=1;
    int size=1;

    for(int i=2; i<=100; i++)
      size = am.multiply(i, res, size);

    System.out.print("\n Factorial of 100 : ");
    for(int i=size-1; i>=0; i--)
        System.out.print(res[i]);
    System.out.print("\n Length of result : "+size);
  }
}
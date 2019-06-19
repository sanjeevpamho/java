package way.to.go.multithreading;

import java.util.Scanner;

class PrintOddFactor extends Thread
{
	PrintTableUsing2Threads printTableUsing2Threads;
	int num;
	
	public PrintOddFactor(PrintTableUsing2Threads printTableUsing2Threads, int num) {
		this.printTableUsing2Threads=printTableUsing2Threads;
		this.num = num;
	}
	
	public void run(){
		try{
			synchronized (printTableUsing2Threads) {
				for(int i=1; i<=10;i=i+2){
					while(printTableUsing2Threads.status!=1)
						printTableUsing2Threads.wait();
					if(i%2 != 0){	
						System.out.print("\n "+Thread.currentThread().getName()+"\t "+num+" * "+i+" = "+num*i);
						Thread.sleep(1000);
						printTableUsing2Threads.status=2;
						printTableUsing2Threads.notifyAll();
					}
				}
				
			}
			
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}

class PrintEvenFactor extends Thread
{
	PrintTableUsing2Threads printTableUsing2Threads;
	int num;
	
	public PrintEvenFactor(PrintTableUsing2Threads printTableUsing2Threads, int num) {
		this.printTableUsing2Threads = printTableUsing2Threads;
		this.num = num;

	}
	
	public void run(){
		try{
			synchronized (printTableUsing2Threads) {
				for(int i=2; i<=10; i=i+2){
					while (printTableUsing2Threads.status!=2) {
						printTableUsing2Threads.wait();
					}
					
					if(i%2==0){
						System.out.print("\n "+Thread.currentThread().getName()+"\t "+num+" * "+i+" = "+num*i);
						Thread.sleep(1000);
						printTableUsing2Threads.status=1;
						printTableUsing2Threads.notifyAll();
					}
				}
			}
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}

public class PrintTableUsing2Threads {

	int status=1;
	static int num;
	public static void main(String[] args) {
		PrintTableUsing2Threads printTableUsing2Threads = new PrintTableUsing2Threads();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter no to print table : ");
		num = sc.nextInt();
		
		PrintOddFactor printOddFactor = new PrintOddFactor(printTableUsing2Threads, num);
		PrintEvenFactor printEvenFactor = new PrintEvenFactor(printTableUsing2Threads, num);
		
		printOddFactor.setName("Thread 1");
		printOddFactor.start();
		
		printEvenFactor.setName("Thread 2");
		printEvenFactor.start();

	}

}

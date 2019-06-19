package way.to.go.multithreading;

import java.util.Scanner;

class PrintTable implements Runnable{

	int num;
	int status;
	
	PrintTable(int num, int status){
		this.num = num;
		this.status = status;
	}
	
	
	@Override
	public void run() {
		try{
			synchronized ((Integer)status) {
				for(int i=1; i<=10; i=i+2){

					while (status!=1) {
						this.wait();
					}
					System.out.print("\n"+Thread.currentThread().getName()+"\t "+num+" * "+i+" = "+num*i);
					Thread.sleep(1000);	
					if(i%2 != 0){
						this.status=2;						
						this.notifyAll();	
					}				
				}

			}

			synchronized ((Integer)status) {
				for(int i=2; i<=10; i=i+2){
					while (status!=2) {
						this.wait();
					}

					System.out.print("\n"+Thread.currentThread().getName()+"\t "+num+" * "+i+" = "+num*i);
					Thread.sleep(1000);
                    if(i%2 == 0){
						this.status=1;
						this.notifyAll();	
                    }
				}

			}


		}catch(Exception e){
			System.out.println(e.getMessage());
		}


	}
	
}

public class PrintTableUsing2ThreadsNew {

	static int status=1;
	public static void main(String[] args) {
		PrintTableUsing2ThreadsNew printTableUsing2ThreadsNew = new PrintTableUsing2ThreadsNew();
		
		Scanner sc = new Scanner(System.in);
		System.out.print(" Enter number to print table : ");
		int num = sc.nextInt();
		
		
		Thread t1 = new Thread(new PrintTable(num, status), "Thread 1");
		Thread t2 = new Thread(new PrintTable(num, status), "Thread 2");
		
		t1.start();
		t2.start();

	}

}

package way.to.go.multithreading;

class PrintZero extends Thread{

	PrintUsing3Threads printUsing3Threads;
	
	PrintZero(PrintUsing3Threads printUsing3Threads){
		this.printUsing3Threads=printUsing3Threads;
	}

	@Override
	public void run() {
		try{
			synchronized (printUsing3Threads) {
				for(int i=0; i<10; i++){
					while(printUsing3Threads.status!=1){
						printUsing3Threads.wait();
					}
					System.out.print("0");
					if(i%2==0)
						printUsing3Threads.status=2;
					else
						printUsing3Threads.status=3;
					printUsing3Threads.notifyAll();
				}
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
}

class PrintOdd extends Thread{

    PrintUsing3Threads printUsing3Threads;
	
    PrintOdd(PrintUsing3Threads printUsing3Threads){
		this.printUsing3Threads=printUsing3Threads;
	}	

	@Override
	public void run() {
		try{
			synchronized (printUsing3Threads) {
				for(int i=1; i<10; i=i+2){
					while (printUsing3Threads.status!=2) {
						printUsing3Threads.wait();
					}

					System.out.print(i);
					printUsing3Threads.status=1;
					printUsing3Threads.notifyAll();
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}


class PrintEven extends Thread{

	PrintUsing3Threads printUsing3Threads;

	PrintEven(PrintUsing3Threads printUsing3Threads){
		this.printUsing3Threads=printUsing3Threads;
	}


	@Override
	public void run() {
		try{
			synchronized (printUsing3Threads) {
				for(int i=2; i<10; i=i+2){
					while (printUsing3Threads.status!=3) {
						printUsing3Threads.wait();
					}	
					System.out.print(i);
					printUsing3Threads.status=1;
					printUsing3Threads.notifyAll();

				}
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

public class PrintUsing3Threads {
	int status=1;
	public static void main(String[] args) {
		
		PrintUsing3Threads printUsing3Threads = new PrintUsing3Threads();
		
		PrintZero t1 = new PrintZero(printUsing3Threads);
		PrintOdd t2 = new PrintOdd(printUsing3Threads);
		PrintEven t3  = new PrintEven(printUsing3Threads);
		
		t1.start();
		t2.start();
        t3.start();
		

	}

}

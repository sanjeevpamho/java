package way.to.go.commonProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class FileOperation{

	public void writeToFile(BufferedWriter bw){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Emp Id : ");
		String id = sc.next();

		System.out.println("Enter Emp name : ");
		String name = sc.next();

		System.out.println("Enter Emp salary : ");
		String sal = sc.next();

		String data = id+"@"+name+"@"+sal;

		try{
			bw.write(data);
			bw.newLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void readFromFile(BufferedReader br){
		String data = "";
		try{
			while((data = br.readLine())!=null){
				String arr[] = data.split("@");
				System.out.println("Id : "+arr[0]+" Name : "+arr[1]+" Salary : "+arr[2]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public String getSpecificData(BufferedReader br, String str){
		String data = "";
		
		try{
			while((data = br.readLine())!=null){
				String arr[] = data.split("@");

				System.out.println("----- str :"+str);
				System.out.println("------arr[0]"+arr[0]);
				if(str.equals(arr[0])){
					data = "ID : "+arr[0]+" Name : "+arr[1]+" Salary : "+arr[2];
					System.out.println("------------- data to be returned : "+data);
					break;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return data;
	}
}

public class DatabaseImplementationUsingFileSystem {

	public static void main(String[] args) {
		
		FileOperation fileOp = new FileOperation();

		Scanner sc = new Scanner(System.in);
		String data = "";

		try{
/*			FileWriter fw = new FileWriter("D:\\temp.txt");
			System.out.println("2----------- file created");

			BufferedWriter bw = new BufferedWriter(fw);
			
			fileOp.writeToFile(bw);
			
			bw.close();
			fw.close();*/
			
			FileReader fr = new FileReader("D:\\temp.txt");

			BufferedReader br = new BufferedReader(fr);
			
			fileOp.readFromFile(br);
			
			System.out.println("Enter emp id to get corresponding details : ");
			data = sc.next();
			
			data = fileOp.getSpecificData(br, data);
			System.out.println("Retrieved data : \n"+data);
			
			fr.close();
			br.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

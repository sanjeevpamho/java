package way.to.go.commonProblems;


class Test{
	
	public void add(int a, int b){
		int c = a+b;
		System.out.println("-------- in int : "+c);
	}
	
	public void add(Integer a, Integer b){
		Integer c = a+b;
		System.out.println("-------- in Integer : "+c);
	}
}

class Test1 extends Test{
	public void add(Integer a, Integer b){
		System.out.println("2------- in extended version");
	}
}

public class SimpleMatrixSummation {

	public static void main(String[] args) {
		
		Test t = new Test();
		t.add(new Integer(1), new Integer(1));
		
		/*double d = 2;
		System.out.println("--------------- d : "+d);*/
		
		// TODO Auto-generated method stub

	}

}

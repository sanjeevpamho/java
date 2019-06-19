// Find whether a path exists with given sum from root to leaf node in a binary tree


package way.to.go.ds.tree;

class CheckExistenceOfPath{
	
	public boolean doesPathExixts(Node root, int sum){
		
		if(root==null)
			return false;
		
		if(root.left==null && root.right==null && root.data==sum)
			return true;
		else
			return (doesPathExixts(root.left, sum-root.data) || doesPathExixts(root.right, sum-root.data));
		
	}
	
}

public class IsPathExistsWithGivenSum {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);
		
		CheckExistenceOfPath ce = new CheckExistenceOfPath();
		System.out.println("Does path exixts with sum 21 : "+ce.doesPathExixts(root, 21));
	}

}

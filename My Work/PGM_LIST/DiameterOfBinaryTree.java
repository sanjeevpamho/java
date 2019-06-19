// Diameter of tree is defined as A longest path or route between any two nodes in a tree. The path may or may not pass through the root.

package way.to.go.ds.tree;

class Diameter{
	
	int getHeight(Node root){
		
		if(root==null)
			return 0;
		
		return (Math.max(getHeight(root.left), getHeight(root.right))+1);
					
	}
	
	public int getDiameter(Node root){
		
		if(root==null)
			return 0;
		
		// if path passes through the root
		int len1 = getHeight(root.left) + getHeight(root.right) + 1;
		
		// path does not pass through the root
		int len2 = Math.max(getDiameter(root.left), getDiameter(root.right));
		
		return Math.max(len1, len2);
	}
	
}

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		
		/*Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left  = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(7);

		root.left.left.left  = new Node(8);
		root.left.left.right  = new Node(9);
		root.left.right.left  = new Node(10);
		root.left.right.right  = new Node(11);
		root.right.right.left  = new Node(14);
		root.right.right.right  = new Node(15);

		root.left.left.left.left  = new Node(16);
		root.left.left.left.right  = new Node(17);
		root.right.right.right.right  = new Node(18);*/
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);
		
		Diameter d = new Diameter();
		int diameter = d.getDiameter(root);
		
		System.out.println("2----------- Diameter of binary tree : "+diameter);
	
	}

}

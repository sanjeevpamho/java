// Find the height of binary tree
// Height ==> The height of a node is the number of edges on the longest path from the node to a leaf

package way.to.go.ds.tree;

class Height{
	
	public int getHeight(Node root){
		
		if(root==null)
			return 0;
		
		return (1+Math.max(getHeight(root.left), getHeight(root.right)));
	}
}

public class HeightOfTree {

	public static void main(String[] args) {
		
		Node root = new Node(1);

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
		root.right.right.right.right  = new Node(18);
		
		Height h = new Height();
		int height = h.getHeight(root);
		
		System.out.println("2----------- height of tree : "+height);
	}

}

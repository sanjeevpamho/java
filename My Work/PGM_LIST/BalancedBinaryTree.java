// check if tree is balanced or not
// A balanced tree is a tree in which difference between heights of sub-trees of any node in the tree is not greater than one.

package way.to.go.ds.tree;

class CheckBalancedTree{
	
	int getHeight(Node root){
		if(root==null)
			return 0;
		return(1+Math.max(getHeight(root.left), getHeight(root.right)));
	}
	
	public boolean isTreeBalanced(Node root){
		if(root==null)
		  return true;
		
		int diff = getHeight(root.left) - getHeight(root.right);
		
		if(Math.abs(diff)>1)
			return false;
		else
			return (isTreeBalanced(root.left) && isTreeBalanced(root.right));
	}
}

public class BalancedBinaryTree {

	public static void main(String[] args) {
		
		CheckBalancedTree cbt = new CheckBalancedTree();
		
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);
		
		System.out.println("2----------- is tree balanced : "+cbt.isTreeBalanced(root));

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

		
		System.out.println("2----------- is tree balanced : "+cbt.isTreeBalanced(root));
	
	}

}

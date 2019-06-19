	/*  Print all root leaf paths in the given tree
	 * 
	 *       1
	       /   \ 
	      2      3
	    /   \    
	   4     5
	 /      /
	8      6
	        \
	         7
	         
 
*/


package way.to.go.ds.tree;


class RootToLeaf{
	
	public void getRootToLeafPath(Node root){
		int res[] = new int[256];
		allPaths(root, res, 0);
	}
	
	void allPaths(Node root, int[] res, int len){
		
		if(root==null)
			return;
		
		res[len] = root.data;
		len++;
		
		if(root.left == null & root.right == null ){
			printArray(res, len);
		}
			allPaths(root.left, res, len);
			allPaths(root.right, res, len);
		
		
	}
	
	void printArray(int res[], int len){
		System.out.print("Path : ");
		for(int i=0; i<len; i++)
			System.out.print(res[i]+" ");
		System.out.println();
	}
	
}

public class RootToLeafAllPaths {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);
		
		RootToLeaf rtl = new RootToLeaf();
		rtl.getRootToLeafPath(root);
	}

}

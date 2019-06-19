// Print path from root to given node

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.Collections;

class FindPath{
	
	// recursive
	public ArrayList<Integer> getRootToNodePath(Node root, Node dest){
		ArrayList<Integer> path =  new ArrayList<Integer>();
		rootToNodePath(root, dest, path);
		return path;
	}
	
	boolean rootToNodePath(Node root, Node dest, ArrayList<Integer> path){
		if(root==null)
			return false;
		
		if(root==dest || rootToNodePath(root.left, dest, path) || rootToNodePath(root.right, dest, path)){
			path.add(root.data);
			return true;
		}
		
		return false;
	}
	
	// non recursive
	public ArrayList<Integer> getPath(Node root, Node dest){
		ArrayList<Integer> res =  new ArrayList<Integer>();
		int temp = printPath(root, dest, res);
		res.add(root.data);
		return res;
	}
	
	int printPath(Node root, Node dest, ArrayList<Integer> res){
		
		if(root==null)
			return 0;
		
		if(root.left!=null)
			if(printPath(root.left, dest, res)==1)
			{
				res.add(root.left.data);
				return 1;
			}
		
		if(root.right!=null)
			if(printPath(root.right, dest, res)==1)
			{
				res.add(root.right.data);
				return 1;
			}
		
		if(root==dest){
			//System.out.println("root.data : "+root.data);
			//res.add(root.data);
			return 1;
		}
		return 0;
	}
}

public class PathFromRootToNode {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		Node n1 = new Node (4);
		root.left.left = n1;
		root.left.right = new Node (5);
		Node n2 = new Node (8);
		root.left.right.right = n2;
		root.left.right.left = new Node (7);
		
		ArrayList<Integer> res =  new ArrayList<Integer>();
		
		FindPath fp = new FindPath();
		res = fp.getPath(root, n2);
		Collections.reverse(res);
		
		System.out.println("Path 1 : "+res);
		
		res = fp.getRootToNodePath(root, n2);
		Collections.reverse(res);
		System.out.println("Path 2 : "+res);
		
	}

}

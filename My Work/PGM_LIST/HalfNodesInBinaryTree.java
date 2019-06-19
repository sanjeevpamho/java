// Find leaf nodes in a given binary tree
// Nodes having only one child(left child or right child but not both) are called half nodes

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class HalfNode{
	
	public ArrayList<Integer> getHalfNodes(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		
		while(!q.isEmpty()){
			Node cur = q.poll();
			
			if(cur!=null){
				
				if((cur.left==null && cur.right!=null) || (cur.left!=null && cur.right==null))
					res.add(cur.data);
				
				if(cur.left!=null)
					q.offer(cur.left);
				
				if(cur.right!=null)
					q.offer(cur.right);
			}
		}
		
		return res;
	}
}

public class HalfNodesInBinaryTree {

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
		
		HalfNode hn = new HalfNode();
		ArrayList<Integer> res = hn.getHalfNodes(root);
		
		System.out.println("2----------- Leaf nodes of tree are : ");
		
		for(Integer n:res)
			System.out.print(n+" ");
	
	}

}

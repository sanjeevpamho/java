// Find maximum in binary tree

package way.to.go.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

class FindMax{
	
	public int getMax(Node root){
		int max = Integer.MIN_VALUE;
		
		if(root==null)
			return max;
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		
		while(!q.isEmpty()){
			Node cur = q.poll();
			if(cur!=null && cur.data>max)
				max = cur.data;
			
			if(cur.left!=null)
				q.offer(cur.left);
			
			if(cur.right!=null)
				q.offer(cur.right);
		}
		
		return max;
	}
}

public class MaxInBinaryTree {

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
		root.right.right.right  = new Node(35);

		root.left.left.left.left  = new Node(16);
		root.left.left.left.right  = new Node(17);
		root.right.right.right.right  = new Node(21);
		
		FindMax fm = new FindMax();
		int res = fm.getMax(root);
		
		System.out.println("2------------------- maximum in binary tree : "+res);
		
	}

}

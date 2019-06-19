// Print all the nodes of a binary tree in zig-zag order
// Zig-Zag Traversal of given binary tree is --->1 3 2 4 5 6 7

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ZigZag{

	public ArrayList<Integer> doTraversal(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Node> st = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();
		boolean isLeftToRight = true;
		Node cur = null;
		
		q.offer(root);
		q.offer(null);
		
		while(!q.isEmpty()){
			cur = q.poll();
			
			if(cur!=null){
				if(isLeftToRight)
					res.add(cur.data);
				else
					st.push(cur);
				
				if(cur.left!=null)
					q.offer(cur.left);
				if(cur.right!=null)
					q.offer(cur.right);
			}else{
				if(!q.isEmpty()){
					q.offer(null);
					isLeftToRight = !isLeftToRight;
					while(!st.isEmpty())
						res.add(st.pop().data);
				}
			}
			
		}

		return res;
	}

}

public class ZigZagTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);


		ZigZag zz = new ZigZag();
		ArrayList<Integer> res = zz.doTraversal(root);

		System.out.print("\n Zig-Zag Traversal is : --->");
		for(Integer n:res){
			System.out.print(n+" ");
		}

	}

}

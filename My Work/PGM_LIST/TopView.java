// Print top view of binary tree
// Top view of given tree is--->4 2 1 3 7 

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class PrintTopView{

	public ArrayList<Integer> doTraversal(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> st = new Stack<Node>();
		Node cur = root;
		
		while(cur!=null){
			st.push(cur);
			cur = cur.left;
		}
		
		while(!st.isEmpty())
			res.add(st.pop().data);
		
		cur = root.right;
		
		while(cur!=null){
			q.offer(cur);
			cur = cur.right;
		}
		
		while(!q.isEmpty())
			res.add(q.poll().data);

		return res;
	}

}

public class TopView {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);


		PrintTopView ptv = new PrintTopView();
		ArrayList<Integer> res = ptv.doTraversal(root);

		System.out.print("\n Top view is : --->");
		for(Integer n:res){
			System.out.print(n+" ");
		}

	}

}

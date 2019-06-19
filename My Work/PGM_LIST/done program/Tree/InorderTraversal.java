// Print in-order traversal of binary tree

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.Stack;


class Inorder{

	public ArrayList<Integer> doTraversal(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		boolean done = false;
		Stack<Node> st = new Stack<Node>();
		Node cur = root;
		while(!done){
			if(cur!=null){
				st.push(cur);
				cur = cur.left;
			}else{
				if(st.isEmpty())
					done=true;
				else{
					cur=st.pop();
					res.add(cur.data);
					cur = cur.right;
				}
			}
		}

		return res;
	}

}

public class InorderTraversal {

	public static void main(String[] args) {

        Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Inorder io = new Inorder();
		ArrayList<Integer> res = io.doTraversal(root);

		System.out.print("\n Inorder Traversal is : --->");
		for(Integer n:res){
			System.out.print(n+" ");
		}

	
	}

}

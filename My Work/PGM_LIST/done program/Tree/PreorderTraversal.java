// Print pre-order traversal of binary tree

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.Stack;

class Preorder{

	public ArrayList<Integer> doTraversal(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Node> st = new Stack<Node>();
		st.push(root);
		
		while(!st.isEmpty()){
			Node cur = st.pop();
			if(cur!=null){
				res.add(cur.data);
				
				if(cur.right!=null)
					st.push(cur.right);
				
				if(cur.left!=null)
					st.push(cur.left);
			}
		}

		return res;
	}

}


public class PreorderTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);


		Preorder po = new Preorder();
		ArrayList<Integer> res = po.doTraversal(root);

		System.out.print("\n Preorder Traversal is : --->");
		for(Integer n:res){
			System.out.print(n+" ");
		}

	
	}


}

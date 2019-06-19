// Print post order traversal of binary tree

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.Stack;

class Postorder{

	public ArrayList<Integer> doTraversal(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Node> st = new Stack<Node>();
		Node prev = null;
		Node cur = null;
		st.push(root);
		
		while(!st.isEmpty()){
			cur = st.peek();
			
			if(prev==null || prev.left==cur || prev.right==cur){
				if(cur.left!=null)
					st.push(cur.left);
				else if(cur.right!=null)
					st.push(cur.right);
			}else if(cur.left==prev){
				if(cur.right!=null)
					st.push(cur.right);
			}else{
				res.add(cur.data);
				st.pop();
			}
			prev=cur;
		}

		return res;
	}

}

public class PostorderTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);


		Postorder po = new Postorder();
		ArrayList<Integer> res = po.doTraversal(root);

		System.out.print("\n Postorder Traversal is : --->");
		for(Integer n:res){
			System.out.print(n+" ");
		}

	}

}

// Print level order traversal of binary tree

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class LevelOrder{

	public ArrayList<Integer> doTraversal(Node root){
		
		if(root==null)
			return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		q.offer(null);

		while(!q.isEmpty()){
			Node temp = q.poll();

			if(temp!=null){
				res.add(temp.data);

				if(temp.left!=null)
					q.offer(temp.left);

				if(temp.right!=null)
					q.offer(temp.right);
			}else{
				if(!q.isEmpty())
					q.offer(null);
			}
		}

		return res;
	}

}

public class LevelOrderTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);


		LevelOrder lo = new LevelOrder();
		ArrayList<Integer> res = lo.doTraversal(root);

		System.out.print("\n Level Order Traversal is : --->");
		for(Integer n:res){
			System.out.print(n+" ");
		}

	}

}

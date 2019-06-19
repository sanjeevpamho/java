// Given a binary tree, print nodes of extreme corners of each level but in alternate order.
// Output will be 1->2->7 or 1->3->4

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class PrintExtremesInAlternateOrder{
	
	public ArrayList<Integer> doTraversal(Node root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if(root==null)
			return null;
		
		boolean isTrue = true;
		Node cur = null;
		Node prev = null;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		
		while(!q.isEmpty()){
			cur = q.poll();

			if(cur!=null){
				if(isTrue){
					res.add(cur.data);
					isTrue = !isTrue;
				}

				if(cur.left!=null)
					q.add(cur.left);
				if(cur.right!=null)
					q.add(cur.right);

			}else{
				if(prev!=null)
				  res.add(prev.data);
				
				if(!q.isEmpty()){
					q.offer(null);
					isTrue = !isTrue;
				}
			}
			if(cur!=null && cur!=root)
			   prev=cur;
		}
		
		return res;
	}
}

public class ExtremesInAlternateOrder {

	public static void main(String[] args) {

		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);*/
		
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
	    root.right.right.right.right  = new Node(31);


		PrintExtremesInAlternateOrder ptv = new PrintExtremesInAlternateOrder();
		ArrayList<Integer> res = ptv.doTraversal(root);
		
		for(Integer n:res){
			System.out.print(n+" ");
		}

		System.out.print("\n Extremes in alternate order are : --->");
		boolean isLeft = true;
		for(int i=0; i<res.size()-2; i++){
			Integer n=0;
			if(i<=1)
			    n = res.get(i);
			else if(i+2<res.size()){
				n = res.get(i+2);
				if(!isLeft){
					i=i+2;
				}else
					isLeft = !isLeft;
			}
			System.out.print(n+" ");
		}

	}

}

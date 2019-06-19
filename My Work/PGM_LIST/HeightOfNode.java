// Find the height of given node in the tree

package way.to.go.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

class NodeHeight{
	
	public int getNodeHeight(Node root, Node ele){
		
		if(root==null)
			return 0;
		
		int height = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		
		while(!q.isEmpty()){
			Node cur = q.poll();
			if(cur!=null){
				if(cur==ele)
					break;
				if(cur.left!=null)
					q.offer(cur.left);
				if(cur.right!=null)
					q.offer(cur.right);
			}else{
				if(!q.isEmpty()){
					height++;
					q.offer(null);
				}
			}
		}
		
		return height;
	}
}

public class HeightOfNode {

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
		
		NodeHeight nh = new NodeHeight();
		int height = nh.getNodeHeight(root, new Node(15));
		
		System.out.println("2----------- height of node : "+height);
	
	}

}

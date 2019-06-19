// FInd in-order successor of a node in a binary tree
// In-order successor of a node is the next node in the in-order traversal of the tree.
//For the last node in a tree, in-order successor will be NULL

package way.to.go.ds.tree;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode{
	char data;
	TreeNode left;
	TreeNode right;
	public TreeNode(char data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Find{
	
	public ArrayList<Character> getInorder(TreeNode root){
		ArrayList<Character> res = new ArrayList<Character>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		boolean isDone = false;
		
		while(!isDone){
			if(root!=null){
				st.push(root);
				root = root.left;
			}else{
				if(st.isEmpty()){
					isDone = true;
					break;
				}else
				{
					root = st.pop();
					res.add(root.data);
					root = root.right;
				}
			}
		}
		
		return res;
	}
	
	public Character getInorderSuccessor(TreeNode root, TreeNode x){

		ArrayList<Character> res = getInorder(root);
		boolean found = false;

		for(Character c : res){
			if(found){
				return c;
			}

			if(c==x.data)
				found = true;
		}
		
		return null;
	}
}

public class InorderSuccessor {

	public static void main(String[] args) {

		TreeNode root = new TreeNode('a');
		root.left = new TreeNode('b');
		root.right = new TreeNode('c');
		root.left.left = new TreeNode('d');
		root.left.right = new TreeNode('e');
		TreeNode x = new TreeNode('x');
		root.left.right.left = new TreeNode('i');
		root.left.right.left.right = new TreeNode('j');
		root.left.right.left.right.right = x;
		root.right.left = new TreeNode('f');
		TreeNode y = new TreeNode('g');
		root.right.right = y;

		Find f = new Find();
		Character res = f.getInorderSuccessor(root, x);
		System.out.println("Inorder successor of "+x.data+" is : "+res);
		
		res = f.getInorderSuccessor(root, y);
		System.out.println("Inorder successor of "+y.data+" is : "+res);

	}
}

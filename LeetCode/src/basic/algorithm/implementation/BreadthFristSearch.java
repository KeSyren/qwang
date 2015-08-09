package basic.algorithm.implementation;

import java.util.*;
import leetcode.datastructure.TreeNode;

public class BreadthFristSearch {
	//BFS uses Queue data structure
	public void breadthFirstSearch(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) return;
		queue.add(root);
		
		TreeNode temp;
		
		while(!queue.isEmpty()) {
			temp = queue.poll(); // remove the node form the queue;
			System.out.println(temp.val);
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
}

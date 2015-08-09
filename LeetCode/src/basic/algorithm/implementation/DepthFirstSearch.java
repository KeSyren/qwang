package basic.algorithm.implementation;

import java.util.*;

import leetcode.datastructure.TreeNode;

public class DepthFirstSearch {
	// DFS uses Stack data structure
	public void depthFirstSearch(TreeNode root) {
		if(root == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		System.out.println(root.val);
	
		
	}
	
	
	
	
}

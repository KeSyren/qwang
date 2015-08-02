package easy.binarytree.operation;

import java.util.*;
import leetcode.datastructure.TreeNode;

public class BinaryTreePreorderTraversal {
	
	public List<Integer> predorderTraversal(TreeNode root) {
		
		List<Integer> result = new ArrayList<Integer>();
		if(null == root) return result;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.empty()) {
			TreeNode cur = stack.pop();
			result.add(cur.val);
			
			if(cur.right != null) {
				stack.push(cur.right);
			}
			
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
		return result;
	}
	
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		helper(root, result);
		return result;
	}
	
	public void helper(TreeNode root, List<Integer> re) {
		if(root == null) return;
		re.add(root.val);
		helper(root.left, re);
		helper(root.right, re);
	}
	
	
	
}

package easy.binarytree.operation;

import java.util.*;
import leetcode.datastructure.TreeNode;

public class BinaryTreeInorderTraversal {
	List<Integer> treeNodes = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root){
		if(null == root) {
			return treeNodes;
		}
		if(root.left != null) {
			inorderTraversal(root.left);
		}
		 
		treeNodes.add(root.val);
		 
		if(root.right != null){
			inorderTraversal(root.right);
		}
		
		return treeNodes;
	}
}

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
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode l1 = new TreeNode(1);
		TreeNode r1 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		
		TreeNode l2 = new TreeNode(0);
		TreeNode r2 = new TreeNode(10);
		l1.left = l2;
		l1.right = r2;
		
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
		List<Integer> result = bt.inorderTraversal(root);
		System.out.println(result);
		
	}
}

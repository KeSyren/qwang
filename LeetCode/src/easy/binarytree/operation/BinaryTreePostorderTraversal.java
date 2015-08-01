package easy.binarytree.operation;
import java.util.*;
import leetcode.datastructure.TreeNode;

public class BinaryTreePostorderTraversal {
	List<Integer> results = new ArrayList<Integer>();
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null) {
			return results;
		}
		
		if(root.left != null){
			postorderTraversal(root.left);
		}
		
		if(root.right != null) {
			postorderTraversal(root.right);
		}
		
		results.add(root.val);
		return results;
	}
}

package basic.algorithm.binarytree;

import java.util.Stack;

public class NonRecursivePreInPostOrderTraversal {

	public static void preOrderUnRecur(TreeNode root) {
		System.out.print("pre-order: ");
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				System.out.print(root.value + " ");

				if (root.right != null) {
					stack.push(root.right);
				}
				if (root.left != null) {
					stack.push(root.left);
				}
			}
		}
		System.out.println();
	}

	public static void inOrderUnRecur(TreeNode root) {
		System.out.print("in-order: ");
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || root != null) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					System.out.print(root.value + " ");
					root = root.right;
				}
			}

		}
		System.out.println();
	}

	// use two stacks to implement
	public static void postOrderUnRecur(TreeNode root) {
		System.out.print("post-order: ");
		if (root != null) {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();

			s1.push(root);
			while (!s1.isEmpty()) {
				root = s1.pop();
				s2.push(root);
				if (root.left != null) {
					s1.push(root.left);
				}
				if (root.right != null) {
					s1t.push(root.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		
		preOrderUnRecur(a1); 
		inOrderUnRecur(a1);
		postOrderUnRecur(a1);
		
	}
}

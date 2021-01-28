package basic.algorithm.binarytree;

import java.util.Stack;

/**
 * 
 * 左子树的值都比它小，右子树的值都比它大
 * nonrecursive way
 * in order traversal is ascending  
 * @author qingwang
 *
 */
public class IsBinarySearchTree {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public static boolean isBST(Node head) {
		int preValue = Integer.MIN_VALUE;
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					if (head.value >= preValue) {
						preValue = head.value;
					} else {
						return false;
					}
					head = head.right;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node a1 = new Node(11);
		Node a2 = new Node(5);
		Node a3 = new Node(15);
		Node a4 = new Node(5);
		Node a5 = new Node(8);
		Node a6 = new Node(12);
		Node a7 = new Node(17);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		
		System.out.print(isBST(a1));
		
	}
	
}

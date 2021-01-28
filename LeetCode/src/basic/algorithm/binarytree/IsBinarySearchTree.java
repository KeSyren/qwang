package basic.algorithm.binarytree;

import java.util.Stack;

/**
 * 
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:

 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
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
	
	public static Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		else {
			if (value <= node.value) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		}
		return node;
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

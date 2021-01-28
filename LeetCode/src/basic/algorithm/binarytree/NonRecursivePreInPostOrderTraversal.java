package basic.algorithm.binarytree;

import java.util.Stack;

public class NonRecursivePreInPostOrderTraversal {

	public static void preOrderUnRecur(Node root) {
		System.out.print("pre-order: ");
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
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

	public static void inOrderUnRecur(Node root) {
		System.out.print("in-order: ");
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
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
	public static void postOrderUnRecur(Node root) {
		System.out.print("post-order: ");
		if (root != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();

			s1.push(root);
			while (!s1.isEmpty()) {
				root = s1.pop();
				s2.push(root);
				if (root.left != null) {
					s1.push(root.left);
				}
				if (root.right != null) {
					s1.push(root.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		Node a7 = new Node(7);
		
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

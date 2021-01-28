package basic.algorithm.binarytree;

public class FindPredecessor {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getPredecessor(Node node) {
		if(node == null) return null;
		
		if (node.left!= null) {
			return getRightMost(node.left); // find the rightmost in the left subtree
		} else {
			Node parent = node.parent;
			while (parent != null && parent.right != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	public static Node getRightMost(Node node) {
		if (node == null) {
			return node;
		}
		
		if (node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Node head = new Node(6);
		
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		Node a7 = new Node(7);
		
		a1.left = a2;
		a1.right = a3;
		a1.parent = null;
		
		a2.left = a4;
		a2.right = a5;
		a2.parent = a1;
		
		a3.left = a6;
		a3.right = a7;
		a3.parent = a1;
		
		a4.left = null;
		a4.right = null;
		a4.parent = a2;
		
		a5.left = null;
		a5.right = null;
		a5.parent = a2;
		
		a6.left = null;
		a6.right = null;
		a6.parent = a3;
		
		a7.left = null;
		a7.right = null;
		a7.parent = a3;
		
		//in-order: 4 2 5 1 6 3 7 
		System.out.print(getPredecessor(a2).value);
	}
}

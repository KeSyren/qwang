package basic.algorithm.binarytree;
	
class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int data) {
		this.value = data;
		this.left = null;
		this.right = null;
	}
}

public class PreInPostOrderTraversal {
	
	public static void preOrderRecur(Node head) {
		if(head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}
	
	public static void postOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		
		postOrderRecur(head.left);
		postOrderRecur(head.right);
		System.out.print(head.value + " ");
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
		
		preOrderRecur(a1); 
		System.out.println();
		inOrderRecur(a1);
		System.out.println();
		postOrderRecur(a1);
		
	}
}

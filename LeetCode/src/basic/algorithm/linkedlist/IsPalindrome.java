package basic.algorithm.linkedlist;

import java.util.Stack;

public class IsPalindrome {
	
	public static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	// needs n extra space
	public static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();

		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		while (head != null) {
			if (head.value != stack.pop().value)
				return false;
			head = head.next;
		}
		return true;
	}

	// needs n/2 extra space
	public static boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// needs O(1) extra space
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head; // slow pointer
		Node n2 = head; // fast pointer
		while (n2.next != null && n2.next.next != null) { // find mid node
			n1 = n1.next; // n1 -> mid
			n2 = n2.next.next; // n2 -> end
		}
		n2 = n1.next; // n2 -> right part first node
		n1.next = null; // mid.next -> null
		Node n3 = null;
		while (n2 != null) {
			n3 = n2.next; // n3 -> save next node
			n2.next = n1;
			n1 = n2; // n1 move
			n2 = n3; // n2 move
		}
		n3 = n1; // n3 -> save last node
		n2 = head; // n2 -> left first node

		boolean res = true;
		while (n1 != null && n2 != null) { // check palindrome
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next; // left to mid
			n2 = n2.next; // right to mid
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) { // recover list
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}

	public static void main(String args[]) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(2);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		boolean condition = isPalindrome1(one);
		System.out.println("isPalidrome :" + condition);
	}
}

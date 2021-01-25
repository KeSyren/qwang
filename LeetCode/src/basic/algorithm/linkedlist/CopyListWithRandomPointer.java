package basic.algorithm.linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	static class Node {
		int val;
		Node next;
		Node rand;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.rand = null;
		}
	}
	
	// hash map 
	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();

		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		while (cur != head) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		
		return map.get(head);
	}
	
	public static Node copyListWithRand2(Node head) {
		if(head == null) {
			return null;
		}
		
		Node cur = head;
		Node next = null;
		
		// copy node and link to every node
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.val);
			cur.next.next = next;
			cur = next;
		}
		
		cur = head;
		Node curCopy = null;
		// set copy node rand
		while(cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null?cur.next.rand:null;
			cur = next;
		}
		Node res = head.next;
		cur = head;
		// split
		while(cur!=null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null? next.next: null;
			cur = next;
		}
		return res;
	}
	
}

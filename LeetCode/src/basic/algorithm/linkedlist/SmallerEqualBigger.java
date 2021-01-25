package basic.algorithm.linkedlist;

import basic.algorithm.linkedlist.IsPalindrome.Node;

public class SmallerEqualBigger {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static Node listPartition1(Node head, int pivot) {
		if (head == null)
			return head;
		Node cur = head;
		int i = 0;

		// count the length of link
		while (cur != null) {
			i++;
			cur = cur.next;
		}

		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {

		}

		return null;
	}

	public static void arrPartition(Node[] nodeArr, int pivot) {
		int less = -1;
		int more = nodeArr.length;
		int cur = 0;
		while (cur < more) {
			if (nodeArr[cur].val < pivot) {
				swap(nodeArr, ++less, cur++);
			} else if (nodeArr[cur].val == pivot) {
				cur++;
			} else {
				swap(nodeArr, --more, cur);
			}
		}
	}

	public static void swap(Node[] arr, int i, int j) {
		Node tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static Node listPartition2(Node head, int pivot) {
		Node sH = null;  // small head
		Node sT = null;  // small tail
		Node eH = null;  // equal head
		Node eT = null;  // equal tail
		Node bH = null;  // big head
		Node bT = null;  // big tail
		
		Node next  = null; // save next node
		// every node distributed to three lists
		while (head != null) {
			next = head.next;
			head.next = null;
			if(head.val < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.val == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// reconnect small and equal
		if (sT != null) {
			sT.next = eH;
			eT = (eT == null) ? sT : eT;
		}
		
		if (eT != null) {
			eT.next = bH;
		}
		
		return sH != null ? sH : (eH != null) ? eH : bH;
	}
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked list:");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
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
		
		Node head = listPartition2(one, 1);
		printLinkedList(head);
	}
}

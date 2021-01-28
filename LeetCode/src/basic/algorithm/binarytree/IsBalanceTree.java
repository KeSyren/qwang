package basic.algorithm.binarytree;

public class IsBalanceTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static class ReturnData {
		public boolean isB;
		public int h;
		
		public ReturnData(boolean isB, int h) {
			this.isB = isB;
			this.h = h;
		}
	}
	
	public static boolean isBalance(Node head) {
		return process(head).isB;
	}
	
	
	public static ReturnData process(Node head) {
		if(head == null) return new ReturnData(true, 0);
		ReturnData leftData = process(head.left);
		if (!leftData.isB) {
			return new ReturnData(false, 0);
		}
		
		ReturnData rightData = process(head.right); 
		if(!rightData.isB) {
			return new ReturnData(false, 0);
		}
		
		if (Math.abs(leftData.h - rightData.h) > 1) {
			return new ReturnData(false, 0);
		}
		
		return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
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
		a3.right = a5;

	
		
		System.out.print(isBalance(a1));
	}
}

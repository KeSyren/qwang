package basic.algorithm.binarytree;
	
class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.value = data;
		this.left = null;
		this.right = null;
	}
}

public class PreInPostOrderTraversal {
	
	public static void preOrderRecur(TreeNode head) {
		if(head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	public static void inOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}
	
	public static void postOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		
		postOrderRecur(head.left);
		postOrderRecur(head.right);
		System.out.print(head.value + " ");
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
		
		preOrderRecur(a1); 
		System.out.println();
		inOrderRecur(a1);
		System.out.println();
		postOrderRecur(a1);
		
	}
}

package basic.algorithm.binarytree;
	
class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.value = data;
	}
}

public class PreInPosTraversal {
	
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
	
	public static void posOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		
		posOrderRecur(head.left);
		posOrderRecur(head.right);
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
		a4.left = null;
		a4.right = null;
		a5.left = null;
		a5.right = null;
		a6.left = null;
		a6.right = null;
		a7.right = null;
		a7.left = null;
		
		preOrderRecur(a1); 
		System.out.println();
		inOrderRecur(a1);
		System.out.println();
		posOrderRecur(a1);
		
	}
}

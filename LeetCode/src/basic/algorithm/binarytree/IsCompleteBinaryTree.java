package basic.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import basic.algorithm.binarytree.IsBinarySearchTree.Node;

/**
 * a full binary tree is a tree in which every node has either 0 or 2 children.
 * a complete binary tree every level except the last is completed filled, and all nodes
 * in the last level are as far left as possible. s
 * @author qingwang
 *
 */
public class IsCompleteBinaryTree {
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
	
	
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue  = new LinkedList<Node>();
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.offer(head);
        while(!queue.isEmpty()) {
        	head = queue.poll();
        	l = head.left;
        	r  = head.right;
        	if ((leaf && (l != null || r != null))||(l ==  null && r != null)) {
        		return false;
        	}
        	if (l != null) {
        		queue.offer(l);
        	} 
        	if (r != null) {
        		queue.offer(r);
        	}  
        	if (l == null || r == null) leaf = true; 
        	
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
//		a3.left = a6;
		a3.right = a7;
		
		System.out.print(isCBT(a1));
		
	}
}

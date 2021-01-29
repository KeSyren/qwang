package basic.algorithm.binarytree;

import basic.algorithm.binarytree.IsBalanceTree.Node;

/**
 * A tree consisting of only a root node has a height of 0. n = 2^(h+1)-1
 * 
 * @author qingwang
 *
 */
public class CountCompleteBinaryTreeNode {

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

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	/**
	 * 
	 * @param node  : The node is the root.
	 * @param level : the level of the node.
	 * @param h     : the tree's height.
	 * @return
	 */
	public static int bs(Node node, int level, int h) {
		if (level == h) { // leaf node
			return 1;
		}

		if (mostLeftLevel(node.right, level + 1) == h) { // left subtree is a perfect tree.
			return (1 << (h - level)) + bs(node.right, level + 1, h);
		} else {
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}

	/**
	 * return the height of tree
	 * 
	 * @param node
	 * @param level
	 * @return
	 */
	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
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

	
		
		System.out.print(nodeNum(a1));
	}

}

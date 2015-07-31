package com.easy.tree.problem;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();

		List<List<Integer>> iResult = new ArrayList<List<Integer>>();
		if (root == null) {
			return iResult;
		}

		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		current.add(root);

		while (current.size() > 0) {
			result.add(current);

			List<TreeNode> parent = current;
			current = new ArrayList<TreeNode>();

			for (TreeNode node : parent) {
				if (node.left != null)
					current.add(node.left);
				if (node.right != null)
					current.add(node.right);
			}
		}

		for (List<TreeNode> nodeArr : result) {
			List<Integer> intArr = new ArrayList<Integer>();
			for (TreeNode node : nodeArr) {
				intArr.add(node.val);
			}
			iResult.add(intArr);
		}

		return iResult;
	}
}

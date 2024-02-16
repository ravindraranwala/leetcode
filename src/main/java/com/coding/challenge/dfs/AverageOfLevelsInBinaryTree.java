package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class AverageOfLevelsInBinaryTree {
	private final List<Long> sumByLevel = new ArrayList<>();
	private final List<Integer> countByLevel = new ArrayList<>();

	AverageOfLevelsInBinaryTree() {

	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(root1));
	}

	List<Double> averageOfLevels(TreeNode root) {
		visitTree(root, 0);
		final List<Double> levelAvg = new ArrayList<>();
		final int n = sumByLevel.size();
		for (int i = 0; i < n; i++)
			levelAvg.add(sumByLevel.get(i) * 1.0 / countByLevel.get(i));
		return levelAvg;
	}

	private void visitTree(TreeNode root, int l) {
		if (root == null)
			return;
		if (sumByLevel.size() == l) {
			sumByLevel.add(0l);
			countByLevel.add(0);
		}
		sumByLevel.set(l, sumByLevel.get(l) + root.val);
		countByLevel.set(l, countByLevel.get(l) + 1);
		visitTree(root.left, l + 1);
		visitTree(root.right, l + 1);
	}
}

package com.coding.challenge.dc;

import com.coding.challenge.bst.TreeNode;

class MaximumBinaryTree {
	MaximumBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 2, 1, 6, 0, 5 };
		assert "[3, 2, 1, 6, 0, 5]".equals(constructMaximumBinaryTree(numsOne).toString());

		final int[] numsTwo = { 3, 2, 1 };
		assert "[3, 2, 1]".equals(constructMaximumBinaryTree(numsTwo).toString());
	}

	static TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructTree(nums, 0, nums.length - 1);
	}

	private static TreeNode constructTree(int[] nums, int i, int j) {
		if (j < i)
			return null;
		int idx = i;
		for (int k = i; k <= j; k++)
			if (nums[k] > nums[idx])
				idx = k;
		final TreeNode left = constructTree(nums, i, idx - 1);
		final TreeNode right = constructTree(nums, idx + 1, j);
		return new TreeNode(nums[idx], left, right);
	}
}

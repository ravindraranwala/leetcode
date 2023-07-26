package com.coding.challenge.fenwick.tree;

/**
 * Fenwick tree data structure.
 * 
 * @author Ravindra Ranwala
 *
 */
public final class FenwickTree {
	private final int[] tree;

	/**
	 * Constructs a fenwick tree using the given input.
	 * 
	 * @param nums input values.
	 */
	public FenwickTree(int[] nums) {
		final int n = nums.length + 1;
		tree = new int[n];

		// copy the input array.
		System.arraycopy(nums, 0, tree, 1, nums.length);

		for (int i = 1; i < n; i++) {
			final int j = i + lsb(i);
			if (j < n)
				tree[j] = tree[j] + tree[i];
		}
	}

	/**
	 * Updates the value at the position index of the array to have the new value.
	 * 
	 * @param index point where the value should be changed.
	 * @param val   new value.
	 */
	public void update(int index, int val) {
		final int currVal = prefixSum(index + 1) - prefixSum(index);
		add(index + 1, val - currVal);
	}

	private void add(int i, int val) {
		final int n = tree.length;
		while (i < n) {
			tree[i] = tree[i] + val;
			i = i + lsb(i);
		}
	}

	/**
	 * Sums up the numbers in the range left to right, b oth inclusive.
	 * 
	 * @param left  starting position (inclusive).
	 * @param right ending position (inclusive).
	 * @return sum of the values from left to right, both inclusive.
	 */
	public int sumRange(int left, int right) {
		return prefixSum(right + 1) - prefixSum(left);
	}

	private int prefixSum(int i) {
		int sum = 0;
		while (i != 0) {
			sum = sum + tree[i];
			i = i - lsb(i);
		}
		return sum;
	}

	private static int lsb(int v) {
		// value of the lsb.
		return v & -v;
	}
}

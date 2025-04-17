package com.coding.challenge.fenwick.tree;

/**
 * Fenwick tree data structure.
 * 
 * @author Ravindra Ranwala
 *
 */
public final class FenwickTree {
	private final long[] tree;

	public FenwickTree(int n) {
		tree = new long[n + 1];
	}

	/**
	 * Constructs a fenwick tree using the given input.
	 * 
	 * @param nums input values.
	 */
	public FenwickTree(int[] nums) {
		final int n = nums.length + 1;
		tree = new long[n];

		// copy the input array.
		System.arraycopy(nums, 0, tree, 1, nums.length);

		for (int i = 1; i < n; i++) {
			final int j = i + lsb(i);
			if (j < n)
				tree[j] = tree[j] + tree[i];
		}
	}

	/**
	 * Add the given value to the element at position i.
	 * 
	 * @param i   Zero based index i where the given value is added.
	 * @param val new value to be added at the position i.
	 */
	public void add(int i, int val) {
		final int n = tree.length;
		int k = i + 1;
		while (k < n) {
			tree[k] = tree[k] + val;
			k = k + lsb(k);
		}
	}

	/**
	 * Sums up the numbers in the range i to j, both inclusive. The indices should
	 * be zero based.
	 * 
	 * @param i starting position (inclusive). Zero based index.
	 * @param j ending position (inclusive). Zero based index.
	 * @return sum of the values from i to j, both inclusive.
	 */
	public long rangeQuery(int i, int j) {
		return prefixSum(j + 1) - prefixSum(i);
	}

	private long prefixSum(int i) {
		long sum = 0;
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

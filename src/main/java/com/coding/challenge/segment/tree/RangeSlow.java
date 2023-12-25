package com.coding.challenge.segment.tree;

/**
 * slow version used only for testing purpose.
 */
public class RangeSlow implements RangeQuery {
	final int[] arr;

	public RangeSlow(int n) {
		arr = new int[n];
	}

	@Override
	public void increment(int i, int j, int val) {
		for (int k = i; k <= j; k++)
			arr[k] = arr[k] + val;
	}

	@Override
	public int minimum(int i, int j) {
		int res = arr[i];
		for (int k = i + 1; k <= j; k++)
			res = Math.min(res, arr[i]);
		return res;
	}
}

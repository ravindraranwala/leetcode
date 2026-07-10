package com.coding.challenge.segment.tree;

public class SegmentTreeMax implements RangeQueryMax {
	private final int[] lo;
	private final int[] hi;
	private final int[] delta;
	private final int[] max;

	public SegmentTreeMax(int n) {
		lo = new int[4 * n + 1];
		hi = new int[4 * n + 1];
		delta = new int[4 * n + 1];
		max = new int[4 * n + 1];
		init(1, 0, n - 1);
	}

	@Override
	public void increment(int a, int b, int val) {
		increment(1, a, b, val);
	}

	private void increment(int i, int a, int b, int val) {
		// disjoint intervals
		if (b < lo[i] || a > hi[i])
			return;
		if (a <= lo[i] && hi[i] <= b) {
			delta[i] = delta[i] + val;
			return;
		}

		// partial cover case.
		prop(i);
		increment(2 * i, a, b, val);
		increment(2 * i + 1, a, b, val);
		update(i);
	}

	void prop(int i) {
		delta[2 * i] = delta[2 * i] + delta[i];
		delta[2 * i + 1] = delta[2 * i + 1] + delta[i];
		delta[i] = 0;
	}

	void update(int i) {
		max[i] = Math.max(max[2 * i] + delta[2 * i], max[2 * i + 1] + delta[2 * i + 1]);
	}

	void init(int i, int a, int b) {
		lo[i] = a;
		hi[i] = b;
		// leaf
		if (a == b)
			return;
		final int m = (a + b) / 2;
		// left child
		init(2 * i, a, m);
		// right child
		init(2 * i + 1, m + 1, b);
	}

	@Override
	public int maximum(int a, int b) {
		return maximum(1, a, b);
	}

	private int maximum(int i, int a, int b) {
		// disjoint
		if (b < lo[i] || a > hi[i])
			return Integer.MIN_VALUE;
		// complete cover
		if (a <= lo[i] && hi[i] <= b)
			return max[i] + delta[i];

		// partial cover case.
		prop(i);
		final int leftMax = maximum(2 * i, a, b);
		final int rightMax = maximum(2 * i + 1, a, b);
		update(i);
		return Math.max(leftMax, rightMax);
	}
}

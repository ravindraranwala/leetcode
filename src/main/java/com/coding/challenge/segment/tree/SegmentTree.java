package com.coding.challenge.segment.tree;

public final class SegmentTree implements RangeQuery {
	private final int[] lo;
	private final int[] hi;
	private final int[] delta;
	private final int[] min;

	public SegmentTree(int n) {
		lo = new int[4 * n + 1];
		hi = new int[4 * n + 1];
		delta = new int[4 * n + 1];
		min = new int[4 * n + 1];
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
		min[i] = Math.min(min[2 * i] + delta[2 * i], min[2 * i + 1] + delta[2 * i + 1]);
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
	public int minimum(int a, int b) {
		return minimum(1, a, b);
	}

	private int minimum(int i, int a, int b) {
		// disjoint
		if (b < lo[i] || a > hi[i])
			return Integer.MAX_VALUE;
		// complete cover
		if (a <= lo[i] && hi[i] <= b)
			return min[i] + delta[i];

		// partial cover case.
		prop(i);
		final int leftMin = minimum(2 * i, a, b);
		final int rightMin = minimum(2 * i + 1, a, b);
		update(i);
		return Math.min(leftMin, rightMin);
	}
}

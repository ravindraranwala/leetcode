package com.coding.challenge.segment.tree;

public final class SegmentTree implements RangeQuery {
	private final int[] lo;
	private final int[] hi;
	private final int[] sum;
	private final int[] delta;

	public SegmentTree(int low, int high) {
		final int n = high - low + 1;
		lo = new int[4 * n + 1];
		hi = new int[4 * n + 1];
		sum = new int[4 * n + 1];
		delta = new int[4 * n + 1];
		init(1, low, high);
	}

	@Override
	public void increment(int a, int b, int val) {
		increment(1, a, b, val);
	}

	private void increment(int i, int a, int b, int val) {
		if (b < lo[i] || a > hi[i])
			return;
		if (lo[i] >= a && hi[i] <= b) {
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
		sum[i] = sum[2 * i] + delta[2 * i] + sum[2 * i + 1] + delta[2 * i + 1];
	}

	@Override
	public int sum(int a, int b) {
		return sum(1, a, b);
	}

	private int sum(int i, int a, int b) {
		if (b < lo[i] || a > hi[i])
			return 0;
		if (lo[i] >= a && hi[i] <= b)
			return sum[i] + delta[i];

		prop(i);
		final int leftSum = sum(2 * i, a, b);
		final int rightSum = sum(2 * i + 1, a, b);
		update(i);
		return leftSum + rightSum;
	}

	void init(int i, int a, int b) {
		lo[i] = a;
		hi[i] = b;
		if (a == b)
			return;
		final int m = (a + b) / 2;
		// left child
		init(2 * i, a, m);
		// right child
		init(2 * i + 1, m + 1, b);
	}
}

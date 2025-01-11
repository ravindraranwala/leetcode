package com.coding.challenge.segment.tree;

public final class SegmentTreeSum {
	private final int[] lo;
	private final int[] hi;
	private final int[] delta;
	private final int[] sum;

	public SegmentTreeSum(int n) {
		lo = new int[4 * n + 1];
		hi = new int[4 * n + 1];
		delta = new int[4 * n + 1];
		sum = new int[4 * n + 1];
		init(1, 0, n - 1);
	}

	public static void main(String[] args) {
		final SegmentTreeSum st = new SegmentTreeSum(5);
		st.increment(0, 0, 10);
		st.increment(1, 1, 2);
		st.increment(2, 2, 50);
		st.increment(3, 3, 5);
		st.increment(4, 4, 20);
		System.out.println(st.sum(4, 4));
	}

	void increment(int a, int b, int val) {
		increment(1, a, b, val);
	}

	private void increment(int i, int a, int b, int val) {
		// disjoint intervals
		if (b < lo[i] || a > hi[i])
			return;
		// complete cover case.
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

	public int sum(int a, int b) {
		return sum(1, a, b);
	}

	void prop(int i) {
		delta[2 * i] = delta[2 * i] + delta[i];
		delta[2 * i + 1] = delta[2 * i + 1] + delta[i];
		delta[i] = 0;
	}

	void update(int i) {
		sum[i] = sum[2 * i] + delta[2 * i] + sum[2 * i + 1] + delta[2 * i + 1];
	}

	private int sum(int i, int a, int b) {
		// disjoint
		if (b < lo[i] || a > hi[i])
			return 0; // return the identity value of sum here.
		// complete cover
		if (a <= lo[i] && hi[i] <= b)
			return sum[i] + delta[i];

		// partial cover case.
		prop(i);
		final int leftSum = sum(2 * i, a, b);
		final int rightSum = sum(2 * i + 1, a, b);
		update(i);
		return leftSum + rightSum;
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
}

package com.coding.challenge.greedy;

class MinimizedMaxPrdsDistributedToStore {
	MinimizedMaxPrdsDistributedToStore() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int n1 = 6;
		final int[] q1 = { 11, 6 };
		int x = minimizedMaximum(n1, q1);
		System.out.println(x);

		final int n2 = 7;
		final int[] q2 = { 15, 10, 10 };
		x = minimizedMaximum(n2, q2);
		System.out.println(x);

		final int n3 = 1;
		final int[] q3 = { 100000 };
		x = minimizedMaximum(n3, q3);
		System.out.println(x);

		final int n4 = 2;
		final int[] q4 = { 5, 7 };
		x = minimizedMaximum(n4, q4);
		System.out.println(x);
	}

	static int minimizedMaximum(int n, int[] quantities) {
		int h = 0;
		int s = 0;
		for (int q : quantities) {
			s = s + q;
			h = Math.max(h, q);
		}
		int l = (int) Math.ceil((double) s / n);
		int c = 0;
		while (l <= h) {
			final int m = (l + h) / 2;
			if (canDistribute(quantities, n, m)) {
				h = m - 1;
				c = m;
			} else
				l = m + 1;
		}
		return c;
	}

	static boolean canDistribute(int[] quantities, int n, int k) {
		int s = 0;
		for (int q : quantities)
			s = s + (int) Math.ceil((double) q / k);
		return s <= n;
	}
}

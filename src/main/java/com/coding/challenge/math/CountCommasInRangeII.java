package com.coding.challenge.math;

class CountCommasInRangeII {
	private static final int BASE = 10;
	private static final int GROUP_SIZE = 3;

	CountCommasInRangeII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countCommas(1002) == 3;
		assert countCommas(998) == 0;
	}

	static long countCommas(long n) {
		long c = 0;
		int d = 1;
		long start = 1;
		while (n >= start * BASE) {
			c = c + (start * BASE - start) * commas(d);
			d = d + 1;
			start = start * BASE;
		}

		return c + (n - start + 1) * commas(d);
	}

	private static int commas(int digitsCnt) {
		return (digitsCnt - 1) / GROUP_SIZE;
	}
}

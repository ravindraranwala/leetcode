package com.coding.challenge.math;

class CountCommasInRange {
	private static final int BASE = 10;
	private static final int MAX_DIGIT = 9;
	private static final int GROUP_SIZE = 3;

	CountCommasInRange() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countCommas(1002) == 3;
		assert countCommas(998) == 0;
		assert countCommas(10000) == 9001;
	}

	static int countCommas(int n) {
		int c = 0;
		int d = 1;
		int start = 1;
		int finish = 9;
		while (d <= 9 && finish < n) {
			c = c + (finish - start + 1) * commas(d);
			d = d + 1;
			start = start * BASE;
			finish = finish * BASE + MAX_DIGIT;
		}

		return c + (n - start + 1) * commas(d);
	}

	private static int commas(int digitsCnt) {
		return (digitsCnt - 1) / GROUP_SIZE;
	}
}

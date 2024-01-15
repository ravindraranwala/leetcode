package com.coding.challenge.prefix.sum;

class MinimumPenaltyForShop {
	private static final char Y = 'Y';
	private static final char N = 'N';

	MinimumPenaltyForShop() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert bestClosingTime("YYNY") == 2;
		assert bestClosingTime("NNNNN") == 0;
		assert bestClosingTime("YYYY") == 4;
		assert bestClosingTime("N") == 0;
		assert bestClosingTime("YNYY") == 4;
		assert bestClosingTime("YN") == 1;
	}

	static int bestClosingTime(String customers) {
		final int n = customers.length();
		final int[] preNcnt = new int[n + 1];
		for (int i = 1; i <= n; i++)
			preNcnt[i] = customers.charAt(i - 1) == N ? preNcnt[i - 1] + 1 : preNcnt[i - 1];

		int h = n;
		int minPenalty = preNcnt[n];
		for (int i = n - 1, postYcnt = 0; i >= 0; i--) {
			if (customers.charAt(i) == Y)
				postYcnt = postYcnt + 1;
			// earliest hour the shop can be closed.
			if (minPenalty >= preNcnt[i] + postYcnt) {
				minPenalty = preNcnt[i] + postYcnt;
				h = i;
			}
		}

		return h;
	}
}

package com.coding.challenge.string;

class MinimumPenaltyForShop {
	MinimumPenaltyForShop() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert bestClosingTime("YYNY") == 2;
		assert bestClosingTime("NNNNN") == 0;
		assert bestClosingTime("YYYY") == 4;
	}

	static int bestClosingTime(String customers) {
		int yesCnt = 0;
		for (char ch : customers.toCharArray())
			if (ch == 'Y')
				yesCnt = yesCnt + 1;

		final int n = customers.length();
		int k = -1;
		int noCnt = 0;
		int p = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			final int curr = noCnt + yesCnt;
			if (curr < p) {
				k = i;
				p = curr;
			}

			final char ch = customers.charAt(i);
			if (ch == 'Y')
				yesCnt = yesCnt - 1;
			else
				noCnt = noCnt + 1;
		}

		if (noCnt < p)
			return n;

		return k;
	}
}

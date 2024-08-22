package com.coding.challenge.greedy;

class UglyNumberII {
	UglyNumberII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert nthUglyNumber(10) == 12;
		assert nthUglyNumber(1) == 1;
		assert nthUglyNumber(1407) == 536870912;
		assert nthUglyNumber(1600) == 1399680000;
		assert nthUglyNumber(11) == 15;
	}

	static int nthUglyNumberBruteForce(int n) {
		final int[] s = new int[n];
		s[0] = 1;
		final int[] factors = { 2, 3, 5 };
		for (int i = 2; i <= n; i++) {
			int nextCandidate = Integer.MAX_VALUE;
			for (int num : s) {
				for (int f : factors) {
					final long val = (long) num * f;
					if (val > s[i - 2])
						nextCandidate = (int) Math.min(nextCandidate, val);
				}
			}
			s[i - 1] = nextCandidate;
		}
		return s[n - 1];
	}

	static int nthUglyNumber(int n) {
		final int[] a = new int[n];
		a[0] = 1;

		for (int i = 2, twoPos = 0, threePos = 0, fivePos = 0; i <= n; i++) {
			final int twoFactor = a[twoPos] * 2;
			final int threeFactor = a[threePos] * 3;
			final int fiveFactor = a[fivePos] * 5;
			if (twoFactor <= threeFactor && twoFactor <= fiveFactor) {
				a[i - 1] = twoFactor;
				twoPos = twoPos + 1;
			} else if (threeFactor < twoFactor && threeFactor <= fiveFactor) {
				a[i - 1] = threeFactor;
				threePos = threePos + 1;
			} else {
				a[i - 1] = fiveFactor;
				fivePos = fivePos + 1;
			}

			if (a[twoPos] * 2 == a[i - 1])
				twoPos = twoPos + 1;
			if (a[threePos] * 3 == a[i - 1])
				threePos = threePos + 1;
			if (a[fivePos] * 5 == a[i - 1])
				fivePos = fivePos + 1;
		}

		return a[n - 1];
	}
}

package com.coding.challenge.dp;

class TwoKeysKeyboard {
	TwoKeysKeyboard() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minSteps(3) == 3;
		assert minSteps(1) == 0;
		assert minSteps(20) == 9;
		assert minSteps(100) == 14;
		assert minSteps(10) == 7;
	}

	static int minSteps(int n) {
		final int[] a = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			a[i] = i;
			for (int j = 2; j <= i / 2; j++)
				if (i % j == 0)
					a[i] = Math.min(a[i], a[j] + i / j);
		}
		return a[n];
	}
}

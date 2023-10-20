package com.coding.challenge.math;

class KthFactor {
	KthFactor() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert kthFactor(12, 3) == 3;
		assert kthFactor(7, 2) == 7;
		assert kthFactor(4, 4) == -1;
	}

	static int kthFactor(int n, int k) {
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				k = k - 1;
			if (k == 0)
				return i;
		}
		return -1;
	}
}

package com.coding.challenge.math;

public class GCD {
	private GCD() {
		throw new AssertionError();
	}

	// Euclidean Algorithm for finding the GCD.
	public static int gcd(int m, int n) {
		if (n == 0)
			return m;

		return gcd(n, m % n);
	}
}

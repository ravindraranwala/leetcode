package com.coding.challenge.recursion;

class PermutationSequence {
	private static final char ZERO = '0';

	PermutationSequence() {
	}

	public static void main(String[] args) {
		assert "213".equals(getPermutation(3, 3));
		assert "2314".equals(getPermutation(4, 9));
		assert "123".equals(getPermutation(3, 1));
	}

	static String getPermutation(int n, int k) {
		final char[] ans = new char[n];
		final int[] factorial = new int[n];
		factorial[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--)
			factorial[i] = factorial[i + 1] * (n - 1 - i);

		findPermutation(n, k, ans, new boolean[n + 1], 0, factorial, 0);
		return String.valueOf(ans);
	}

	private static void findPermutation(int n, int k, char[] permutation, boolean[] used, int l,
			int[] factorial, int p) {
		// base case of the recursion.
		if (l == n)
			return;

		for (int i = 1, j = 0; i <= n; i++) {
			if (!used[i]) {
				j = j + 1;
				if (k <= p + factorial[l] * j) {
					// choose
					permutation[l] = (char) (ZERO + i);
					used[i] = true;

					// explore.
					findPermutation(n, k, permutation, used, l + 1, factorial,
							p + factorial[l] * (j - 1));
					return;
				}
			}
		}
	}
}

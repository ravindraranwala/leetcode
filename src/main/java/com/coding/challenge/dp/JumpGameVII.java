package com.coding.challenge.dp;

class JumpGameVII {
	private static final char ZERO = '0';

	JumpGameVII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert canReach("011010", 2, 3);
		assert !canReach("01101110", 2, 3);
		assert !canReach("01", 1, 1);
	}

	static boolean canReach(String s, int minJump, int maxJump) {
		final int n = s.length();
		final int[] a = new int[n];
		a[n - 1] = s.charAt(n - 1) == ZERO ? 1 : 0;

		for (int i = n - 2; i >= 0; i--) {
			int cnt = 0;
			if (i + minJump < n)
				cnt = a[i + minJump];
			if (i + maxJump + 1 < n)
				cnt = cnt - a[i + maxJump + 1];

			if (s.charAt(i) == ZERO && cnt > 0)
				a[i] = a[i + 1] + 1;
			else
				a[i] = a[i + 1];
		}
		return a[0] == a[1] + 1;
	}
}

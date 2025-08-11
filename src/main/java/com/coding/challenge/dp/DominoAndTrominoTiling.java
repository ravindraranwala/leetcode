package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DominoAndTrominoTiling {
	private static final int MOD = 1000000007;

	DominoAndTrominoTiling() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numTilingsMath(1) == 1;
		assert numTilingsMath(3) == 5;
		assert numTilingsMath(4) == 11;
		assert numTilingsArray(699) == 939053561;
	}

	static int numTilings(int n) {
		final Map<List<Integer>, Integer> t = new HashMap<>();
		// trivial cases of the recursion.
		t.put(Arrays.asList(0, 0), 1);
		t.put(Arrays.asList(0, 1), 1);

		t.put(Arrays.asList(1, 0), 1);
		t.put(Arrays.asList(1, 1), 2);
		t.put(Arrays.asList(1, 2), 2);

		for (int c1 = 2; c1 < n; c1++) {
			// case 1.
			t.put(Arrays.asList(c1, c1 - 1),
					(t.get(Arrays.asList(c1 - 2, c1 - 1)) + t.get(Arrays.asList(c1 - 2, c1 - 2))) % MOD);

			// case 2.
			int ans = (t.get(Arrays.asList(c1 - 1, c1 - 1)) + t.get(Arrays.asList(c1 - 1, c1 - 2))) % MOD;
			ans = (ans + t.get(Arrays.asList(c1 - 2, c1 - 1))) % MOD;
			ans = (ans + t.get(Arrays.asList(c1 - 2, c1 - 2))) % MOD;
			t.put(Arrays.asList(c1, c1), ans);

			// case 3.
			t.put(Arrays.asList(c1, c1 + 1),
					(t.get(Arrays.asList(c1, c1 - 1)) + t.get(Arrays.asList(c1 - 1, c1 - 1))) % MOD);
		}
		return t.get(Arrays.asList(n - 1, n - 1));
	}

	static int numTilingsArray(int n) {
		if (n == 1)
			return 1;

		final int[][] a = new int[n][3];
		// trivial cases of the recursion.
		a[0][1] = 1;
		a[0][2] = 1;
		a[1][0] = 1;
		a[1][1] = 2;
		a[1][2] = 2;

		for (int c1 = 2; c1 < n; c1++) {
			// case 1.
			a[c1][0] = (a[c1 - 2][2] + a[c1 - 2][1]) % MOD;
			// case 2.
			final int ans1 = (a[c1 - 1][1] + a[c1 - 1][0]) % MOD;
			final int ans2 = (a[c1 - 2][2] + a[c1 - 2][1]) % MOD;
			a[c1][1] = (ans1 + ans2) % MOD;
			// case 3.
			a[c1][2] = (a[c1][0] + a[c1 - 1][1]) % MOD;
		}
		return a[n - 1][1];
	}

	static int numTilingsMath(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int curr = 5;
		for (int i = 4, prev = 2, beforePrev = 1; i <= n; i++) {
			final int newVal = ((curr + curr) % MOD + beforePrev) % MOD;
			beforePrev = prev;
			prev = curr;
			curr = newVal;
		}
		return curr;
	}
}

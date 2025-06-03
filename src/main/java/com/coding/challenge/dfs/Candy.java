package com.coding.challenge.dfs;

class Candy {
	Candy() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] ratings1 = { 1, 0, 2 };
		assert candy(ratings1) == 5;
		
		final int[] ratings2 = { 1, 2, 2 };
		assert candy(ratings2) == 4;
		
		final int[] ratings3 = { 1, 2, 5, 7, 8 };
		assert candy(ratings3) == 15;
		
		final int[] ratings4 = { 8, 7, 5, 4, 2, 1 };
		assert candy(ratings4) == 21;
		
		final int[] ratings5 = { 7 };
		assert candy(ratings5) == 1;
	}

	static int candy(int[] ratings) {
		if (ratings.length == 1)
			return 1;

		final int n = ratings.length;
		final int[] c = new int[n];
		for (int u = 0; u < n; u++)
			if (c[u] == 0)
				dfs(u, c, ratings, n);
		
		int ans = 0;
		for (int v : c) 
			ans = ans + v;
		
		return ans;
	}

	private static void dfs(int u, int[] c, int[] ratings, int n) {
		if (u == 0) {
			c[0] = 1;
			if (ratings[1] < ratings[0]) {
				if (c[1] == 0)
					dfs(1, c, ratings, n);
				c[u] = c[1] + 1;
			}
		} else if (u == n - 1) {
			c[u] = 1;
			if (ratings[n - 2] < ratings[n - 1]) {
				if (c[n - 2] == 0)
					dfs(n - 2, c, ratings, n);
				c[n - 1] = c[n - 2] + 1;
			}
		} else {
			c[u] = 1;
			if (ratings[u - 1] < ratings[u]) {
				if (c[u - 1] == 0)
					dfs(u - 1, c, ratings, n);
				c[u] = c[u - 1] + 1;
			}
			if (ratings[u + 1] < ratings[u]) {
				if (c[u + 1] == 0)
					dfs(u + 1, c, ratings, n);
				c[u] = Math.max(c[u], c[u + 1] + 1);
			}
		}
	}
}

package com.coding.challenge.dfs;

class JumpGame3 {
	JumpGame3() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] jumpOne = { 4, 2, 3, 0, 3, 1, 2 };
		assert canReach(jumpOne, 5);

		final int[] jumpTwo = { 4, 2, 3, 0, 3, 1, 2 };
		assert canReach(jumpTwo, 0);

		final int[] jumpThree = { 3, 0, 2, 1, 2 };
		assert !canReach(jumpThree, 2);
	}

	static boolean canReach(int[] arr, int start) {
		final int n = arr.length;
		// all values defaults to false
		final boolean[] d = new boolean[n];
		// DFS solution.
		return canReachVisit(arr, d, start, n);
	}

	static boolean canReachVisit(int[] a, boolean[] d, int i, int n) {
		d[i] = true;
		// base case of the recursion
		if (a[i] == 0)
			return true;
		// explore the adjacency list.
		boolean r = false;
		if (i + a[i] < n && !d[i + a[i]])
			r = canReachVisit(a, d, i + a[i], n);
		if (i - a[i] >= 0 && !d[i - a[i]])
			r = r || canReachVisit(a, d, i - a[i], n);
		return r;
	}
}

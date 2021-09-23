package com.coding.challenge.bst;

class UniqueBSTs {
	UniqueBSTs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		int n = 3;
		int nt = numTrees(n);
		System.out.println(String.format("Number of unique BSTs which has %d nodes: %d", n, nt));

		n = 1;
		nt = numTrees(n);
		System.out.println(String.format("Number of unique BSTs which has %d nodes: %d", n, nt));

		n = 9;
		nt = numTrees(n);
		System.out.println(String.format("Number of unique BSTs which has %d nodes: %d", n, nt));

		n = 12;
		nt = numTrees(n);
		System.out.println(String.format("Number of unique BSTs which has %d nodes: %d", n, nt));

		n = 19;
		nt = numTrees(n);
		System.out.println(String.format("Number of unique BSTs which has %d nodes: %d", n, nt));
	}

	static int numTrees(int n) {
		double num = 1;
		for (int k = 2; k <= n; k++)
			num = num * (n + k) / k;

		return (int) Math.round(num);
	}
}

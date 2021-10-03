package com.coding.challenge.greedy;

class GasStation {

	GasStation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] g = { 1, 2, 3, 4, 5 };
		final int[] c = { 3, 4, 5, 1, 2 };
		int s = canCompleteCircuit(g, c);
		System.out.println(s);

		// usecase 2.
		final int[] g1 = { 2, 3, 4 };
		final int[] c1 = { 3, 4, 3 };
		s = canCompleteCircuit(g1, c1);
		System.out.println(s);

		// usecase 3.
		final int[] g2 = { 5, 8, 2, 8 };
		final int[] c2 = { 6, 5, 6, 6 };
		s = canCompleteCircuit(g2, c2);
		System.out.println(s);

		// usecase 4.
		final int[] g3 = { 5, 5, 1, 3, 4 };
		final int[] c3 = { 8, 1, 7, 1, 1 };
		s = canCompleteCircuit(g3, c3);
		System.out.println(s);

		// usecase 5.
		final int[] g4 = { 4, 5, 2, 6, 5, 3 };
		final int[] c4 = { 3, 2, 7, 3, 2, 9 };
		s = canCompleteCircuit(g4, c4);
		System.out.println(s);

		// usecase 6.
		final int[] g5 = { 2 };
		final int[] c5 = { 2 };
		s = canCompleteCircuit(g5, c5);
		System.out.println(s);

		// usecase 7.
		final int[] g6 = { 1, 2 };
		final int[] c6 = { 2, 1 };
		s = canCompleteCircuit(g6, c6);
		System.out.println(s);

		// usecase 8.
		final int[] g7 = { 6, 1, 4, 3, 5 };
		final int[] c7 = { 3, 8, 2, 4, 2 };
		s = canCompleteCircuit(g7, c7);
		System.out.println(s);
		// expected answers would be: 3, -1, 3, 3, -1, 0, 1, 2.
	}

	static int canCompleteCircuit(int[] gas, int[] cost) {
		final int n = gas.length;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int s = -1;
		for (int i = 0; i < n; i++) {
			sum = sum + gas[i] - cost[i];
			if (sum < min) {
				min = sum;
				s = i;
			}
		}
		if (sum < 0)
			return -1;
		return (s + 1) % n;
	}
}

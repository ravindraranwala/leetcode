package com.coding.challenge.greedy;

import java.util.Arrays;

class BoatsToSavePeople {
	BoatsToSavePeople() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] p1 = { 1, 2 };
		assert numRescueBoats(p1, 3) == 1;

		final int[] p2 = { 3, 2, 2, 1 };
		assert numRescueBoats(p2, 3) == 3;

		final int[] p3 = { 3, 5, 3, 4 };
		assert numRescueBoats(p3, 5) == 4;
	}

	static int numRescueBoats(int[] people, int limit) {
		final int n = people.length;
		Arrays.sort(people);
		int b = 0;
		int i = 0;
		int j = n - 1;
		while (i <= j) {
			if (people[i] + people[j] <= limit)
				i = i + 1;
			b = b + 1;
			j = j - 1;
		}
		return b;
	}
}

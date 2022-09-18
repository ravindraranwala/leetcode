package com.coding.challenge.two.sum;

import java.util.HashMap;
import java.util.Map;

class DurationPairsDivisibleBy60 {
	DurationPairsDivisibleBy60() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] timeOne = { 30, 20, 150, 100, 40 };
		System.out.println(numPairsDivisibleBy60(timeOne));

		final int[] timeTwo = { 60, 60, 60 };
		System.out.println(numPairsDivisibleBy60(timeTwo));
	}

	static int numPairsDivisibleBy60(int[] time) {
		final int n = time.length;
		final Map<Integer, Integer> m = new HashMap<>();
		int c = 0;

		for (int i = 0; i < n; i++) {
			final int o = (60 - time[i] % 60) % 60;
			c = c + m.getOrDefault(o, 0);
			m.merge(time[i] % 60, 1, Integer::sum);
		}
		return c;
	}
}

package com.coding.challenge.greedy;

import java.util.Arrays;

class EarliestPossibleFullBloom {
	EarliestPossibleFullBloom() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] plantTimeOne = { 1, 4, 3 };
		final int[] growTimeOne = { 2, 3, 1 };
		int b = earliestFullBloom(plantTimeOne, growTimeOne);
		System.out.println(b);

		final int[] plantTimeTwo = { 1, 2, 3, 2 };
		final int[] growTimeTwo = { 2, 1, 2, 1 };
		b = earliestFullBloom(plantTimeTwo, growTimeTwo);
		System.out.println(b);

		final int[] plantTimeThree = { 1 };
		final int[] growTimeThree = { 1 };
		b = earliestFullBloom(plantTimeThree, growTimeThree);
		System.out.println(b);
	}

	static int earliestFullBloom(int[] plantTime, int[] growTime) {
		final int n = plantTime.length;
		final FlowerSeed[] s = new FlowerSeed[n];
		for (int i = 0; i < n; i++)
			s[i] = new FlowerSeed(plantTime[i], growTime[i]);
		Arrays.sort(s, (a, b) -> Integer.compare(b.growTime, a.growTime));

		int d = 0;
		int b = Integer.MIN_VALUE;
		for (FlowerSeed curr : s) {
			// attend planting the seed
			d = d + curr.plantTime;
			b = Math.max(b, d + curr.growTime);
		}
		return b;
	}

	static class FlowerSeed {
		int plantTime;
		int growTime;

		FlowerSeed(int plantTime, int growTime) {
			this.plantTime = plantTime;
			this.growTime = growTime;
		}
	}
}

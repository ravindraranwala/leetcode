package com.coding.challenge.greedy;

import java.util.Arrays;

class DestroyingAsteroids {
	DestroyingAsteroids() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] asteroids1 = { 3, 9, 19, 5, 21 };
		assert asteroidsDestroyed(10, asteroids1);

		final int[] asteroids2 = { 4, 9, 23, 4 };
		assert !asteroidsDestroyed(5, asteroids2);
	}

	static boolean asteroidsDestroyed(int mass, int[] asteroids) {
		Arrays.sort(asteroids);
		long planetMass = mass;
		for (int a : asteroids) {
			if (a > planetMass)
				return false;
			else
				planetMass = planetMass + a;
		}
		return true;
	}
}

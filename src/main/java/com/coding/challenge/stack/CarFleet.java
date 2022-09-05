package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class CarFleet {
	CarFleet() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] carsOne = { { 1, 2 }, { 2, 1 }, { 4, 3 }, { 7, 2 } };
		assert Arrays.equals(getCollisionTimes(carsOne), new double[] { 1.00000, -1.00000, 3.00000, -1.00000 });

		final int[][] carsTwo = { { 3, 4 }, { 5, 4 }, { 6, 3 }, { 9, 1 } };
		assert Arrays.equals(getCollisionTimes(carsTwo), new double[] { 2.00000, 1.00000, 1.50000, -1.00000 });

	}

	static double[] getCollisionTimes(int[][] cars) {
		final int n = cars.length;
		// monotonically decreasing stack
		final Deque<Double> t = new ArrayDeque<>();
		final Deque<int[]> s = new ArrayDeque<>();
		final double[] c = new double[n];

		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && t.peek() <= collisionTime(cars[i], s.peek())) {
				s.pop();
				t.pop();
			}

			double time = Double.POSITIVE_INFINITY;
			if (!s.isEmpty())
				time = collisionTime(cars[i], s.peek());

			s.push(cars[i]);
			t.push(time);
			c[i] = time == Double.POSITIVE_INFINITY ? -1 : time;
		}

		return c;
	}

	static double collisionTime(int[] b, int[] f) {
		// how to handle division by 0 and negative case?
		// be aware of integer division.
		if (b[1] > f[1])
			return 1.0 * (f[0] - b[0]) / (b[1] - f[1]);
		else
			return Double.POSITIVE_INFINITY;
	}
}

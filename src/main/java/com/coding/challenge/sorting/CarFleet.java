package com.coding.challenge.sorting;

import java.util.Arrays;

class CarFleet {
	CarFleet() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] p1 = { 10, 8, 0, 5, 3 };
		final int[] s1 = { 2, 4, 1, 1, 3 };
		int f = carFleet(12, p1, s1);
		assert f == 3;

		final int[] p2 = { 3 };
		final int[] s2 = { 3 };
		f = carFleet(10, p2, s2);
		assert f == 1;

		final int[] p3 = { 0, 2, 4 };
		final int[] s3 = { 4, 2, 1 };
		f = carFleet(100, p3, s3);
		assert f == 1;
	}

	static int carFleet(int target, int[] position, int[] speed) {
		final int n = position.length;
		final Car[] cars = new Car[n];
		for (int i = 0; i < n; i++)
			cars[i] = new Car(position[i], speed[i]);
		// sort the array by position in non-increasing order.
		Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));
		double h = -1;
		int f = 0;
		for (int i = 0; i < n; i++) {
			final double c = (target - cars[i].position) * 1.0 / cars[i].speed;
			if (c > h) {
				f = f + 1;
				h = c;
			}
		}
		return f;
	}

	static class Car {
		final int position;
		final int speed;

		Car(int position, int speed) {
			this.position = position;
			this.speed = speed;
		}

	}
}

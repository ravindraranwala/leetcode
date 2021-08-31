package com.coding.challenge.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MinRefuelingStops {

	MinRefuelingStops() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		int startfuel = 1;
		int target = 1;
		final int[][] s1 = new int[0][0];
		int minStops = minRefuelStops(target, startfuel, s1, 1);
		System.out.println(minStops);

		// Usecase 2.
		target = 100;
		startfuel = 1;
		final int[][] s2 = { { 10, 100 } };
		minStops = minRefuelStops(target, startfuel, s2, 1);
		System.out.println(minStops);

		// Usecase 3.
		target = 100;
		startfuel = 10;
		final int[][] stations = { { 10, 50 }, { 20, 30 }, { 30, 30 }, { 90, 20 } };
		minStops = minRefuelStops(target, startfuel, stations, 1);
		System.out.println(minStops);

		// Usecase 4
		final int[][] s4 = { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } };
		minStops = minRefuelStops(target, startfuel, s4, 1);
		System.out.println(minStops);
		
		// Usecase 4.
		target = 100;
		startfuel = 50;
		final int[][] s3 = { { 25, 25 }, { 50, 50 } };
		minStops = minRefuelStops(target, startfuel, s3, 1);
		System.out.println(minStops);
	}

	static int minRefuelStops(int target, int startFuel, int[][] stations, int r) {
		int c = 0;
		final Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		int d = startFuel / r;
		int i = 0;
		final int n = stations.length;
		while (d < target) {
			if (i == n || d < stations[i][0])
				return -1;
			while (i < n && stations[i][0] <= d) {
				heap.offer(Integer.valueOf(stations[i][1]));
				i = i + 1;
			}
			int np = target;
			if (i < n)
				np = stations[i][0];
			while (!heap.isEmpty() && d < np) {
				d = d + heap.poll() / r;
				c = c + 1;
			}
		}
		return c;
	}
}

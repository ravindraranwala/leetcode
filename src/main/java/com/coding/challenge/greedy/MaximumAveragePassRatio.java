package com.coding.challenge.greedy;

import java.util.PriorityQueue;

class MaximumAveragePassRatio {
	MaximumAveragePassRatio() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] classes1 = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
		System.out.println(maxAverageRatio(classes1, 2));

		final int[][] classes2 = { { 2, 4 }, { 3, 9 }, { 4, 5 }, { 2, 10 } };
		System.out.println(maxAverageRatio(classes2, 4));
	}

	static double maxAverageRatio(int[][] classes, int extraStudents) {
		final int n = classes.length;
		final double[] deltaRatio = new double[n];
		final PriorityQueue<Integer> h = new PriorityQueue<>((a, b) -> Double.compare(deltaRatio[b], deltaRatio[a]));
		double passRatio = 0;
		for (int i = 0; i < n; i++) {
			final int[] cls = classes[i];
			final double currRatio = cls[0] * 1.0 / cls[1];
			deltaRatio[i] = (cls[0] + 1) * 1.0 / (cls[1] + 1) - currRatio;
			h.add(i);
			passRatio = passRatio + currRatio;
		}

		for (int i = 0; i < extraStudents; i++) {
			final int j = h.remove();
			classes[j][0] = classes[j][0] + 1;
			classes[j][1] = classes[j][1] + 1;
			passRatio = passRatio + deltaRatio[j];
			deltaRatio[j] = (classes[j][0] + 1) * 1.0 / (classes[j][1] + 1) - classes[j][0] * 1.0 / classes[j][1];
			h.add(j);

		}
		return passRatio / classes.length;
	}
}

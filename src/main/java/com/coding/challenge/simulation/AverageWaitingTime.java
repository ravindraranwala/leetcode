package com.coding.challenge.simulation;

class AverageWaitingTime {
	AverageWaitingTime() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] customersOne = { { 1, 2 }, { 2, 5 }, { 4, 3 } };
		assert averageWaitingTime(customersOne) == 5.0;

		final int[][] customersTwo = { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } };
		assert averageWaitingTime(customersTwo) == 3.25;
	}

	static double averageWaitingTime(int[][] customers) {
		long waitingTime = 0;
		final int n = customers.length;
		for (int i = 0, elapsedTime = 0; i < n; i++) {
			elapsedTime = Math.max(elapsedTime, customers[i][0]) + customers[i][1];
			waitingTime = waitingTime + elapsedTime - customers[i][0];
		}
		return waitingTime * 1.0 / n;
	}
}

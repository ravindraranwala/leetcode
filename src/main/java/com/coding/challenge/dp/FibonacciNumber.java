package com.coding.challenge.dp;

public class FibonacciNumber {

	private FibonacciNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int n = 6;
		System.out.println(String.format("Fibonacci %d: %d", n, fib(n)));
	}

	public static int fib(int n) {
		// trivial case.
		if (n < 2)
			return n;
		final int[] fibSeries = new int[n + 1];
		fibSeries[0] = 0;
		fibSeries[1] = 1;
		for (int i = 2; i <= n; i++)
			fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
		return fibSeries[n];
	}
}

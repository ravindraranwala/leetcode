package com.coding.challenge.dp;

class FibonacciNumber {

	private FibonacciNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int n = 0;
		System.out.println(String.format("Fibonacci %d: %d", n, fib(n)));
	}

	public static int fib(int n) {
		// trivial case.
		if (n == 0)
			return 0;
		int p = 0;
		int c = 1;
		for (int i = 2; i <= n; i++) {
			final int tmp = p + c;
			p = c;
			c = tmp;
		}
		return c;
	}
}

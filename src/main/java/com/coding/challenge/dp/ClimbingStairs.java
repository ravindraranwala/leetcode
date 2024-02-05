package com.coding.challenge.dp;

class ClimbingStairs {
	ClimbingStairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert climbStairs(4) == 5;
	}

	static int climbStairs(int n) {
		int w = 0;
		// similar to a Fibonacci series with one offset.
		for (int i = 1, prev = 1, beforePrev = 0; i <= n; i++) {
			w = prev + beforePrev;
			beforePrev = prev;
			prev = w;
		}
		return w;
	}
}

package com.coding.challenge.simulation;

class PassThePillow {
	PassThePillow() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert passThePillow(4, 5) == 2;
		assert passThePillow(3, 2) == 3;
	}

	static int passThePillow(int n, int time) {
		final int rounds = time / (n - 1);
		final int secondsLeft = time % (n - 1);
		if (rounds % 2 == 0)
			return secondsLeft + 1;
		else
			return n - secondsLeft;
	}
}

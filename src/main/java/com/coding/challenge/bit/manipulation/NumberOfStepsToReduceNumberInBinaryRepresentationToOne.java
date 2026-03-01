package com.coding.challenge.bit.manipulation;

class NumberOfStepsToReduceNumberInBinaryRepresentationToOne {
	private static final char ONE = '1';

	NumberOfStepsToReduceNumberInBinaryRepresentationToOne() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numSteps("1101") == 6;
		assert numSteps("110011") == 9;
		assert numSteps("1000") == 3;
		assert numSteps("1010") == 6;
		assert numSteps("1011") == 6;
		assert numSteps("10100") == 7;
		assert numSteps("10011") == 8;
		assert numSteps("10101") == 8;
		assert numSteps("1") == 0;
	}

	static int numSteps(String s) {
		final int n = s.length();
		int c = 0;
		boolean lastOne = false;
		for (int i = n - 1; i > 0; i--) {
			if (s.charAt(i) == ONE) {
				if (lastOne)
					c = c + 1;
				else
					c = c + 2;

				lastOne = true;
			} else {
				if (lastOne)
					c = c + 2;
				else
					c = c + 1;
			}
		}
		if (lastOne)
			c = c + 1;

		return c;
	}
}

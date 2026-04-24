package com.coding.challenge.string;

class FurthestPointFromOrigin {
	FurthestPointFromOrigin() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert furthestDistanceFromOrigin("L_RL__R") == 3;
		assert furthestDistanceFromOrigin("_R__LL_") == 5;
		assert furthestDistanceFromOrigin("_______") == 7;
	}

	static int furthestDistanceFromOrigin(String moves) {
		int c = 0;
		int blanks = 0;

		for (char ch : moves.toCharArray()) {
			if (ch == 'L')
				c = c - 1;
			else if (ch == 'R')
				c = c + 1;
			else
				blanks = blanks + 1;
		}
		return Math.abs(c) + blanks;
	}
}

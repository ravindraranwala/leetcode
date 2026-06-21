package com.coding.challenge.greedy;

class MaximumManhattanDistanceAfterAllMoves {
	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final char UP = 'U';
	private static final char DOWN = 'D';

	MaximumManhattanDistanceAfterAllMoves() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxDistance("L_D_") == 4;
		assert maxDistance("U_R") == 3;
		assert maxDistance("DU") == 0;
	}

	static int maxDistance(String moves) {
		int x = 0;
		int y = 0;
		int wildcards = 0;
		for (char ch : moves.toCharArray()) {
			if (ch == LEFT)
				x = x - 1;
			else if (ch == RIGHT)
				x = x + 1;
			else if (ch == UP)
				y = y + 1;
			else if (ch == DOWN)
				y = y - 1;
			else
				wildcards = wildcards + 1;
		}
		return Math.abs(x) + Math.abs(y) + wildcards;
	}
}

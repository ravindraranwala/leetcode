package com.coding.challenge.bit.manipulation;

class BinaryGap {
	BinaryGap() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert binaryGap(22) == 2;
		assert binaryGap(8) == 0;
		assert binaryGap(5) == 2;
	}

	static int binaryGap(int n) {
		int g = 0;
		for (int i = 0, lastOneIdx = -1, val = n; val > 0; i++) {
			final int m = val % 2;
			if (m == 1 && lastOneIdx >= 0)
				g = Math.max(g, i - lastOneIdx);

			if (m == 1)
				lastOneIdx = i;

			val = val / 2;
		}
		return g;
	}
}

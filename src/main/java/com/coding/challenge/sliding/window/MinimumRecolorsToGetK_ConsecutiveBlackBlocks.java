package com.coding.challenge.sliding.window;

class MinimumRecolorsToGetK_ConsecutiveBlackBlocks {
	MinimumRecolorsToGetK_ConsecutiveBlackBlocks() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumRecolors("WBBWWBBWBW", 7) == 3;
		assert minimumRecolors("WBWBBBW", 2) == 0;
	}

	static int minimumRecolors(String blocks, int k) {
		final int n = blocks.length();
		int c = 0;
		for (int i = 0, b = 0; i < n; i++) {
			if (blocks.charAt(i) == 'B')
				b = b + 1;
			if (i >= k && blocks.charAt(i - k) == 'B')
				b = b - 1;
			c = Math.max(c, b);
		}
		return k - c;
	}
}

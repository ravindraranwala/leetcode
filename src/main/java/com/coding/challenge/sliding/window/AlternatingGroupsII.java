package com.coding.challenge.sliding.window;

class AlternatingGroupsII {
	AlternatingGroupsII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] colors1 = { 0, 1, 0, 1, 0 };
		assert numberOfAlternatingGroups(colors1, 3) == 3;

		final int[] colors2 = { 0, 1, 0, 0, 1, 0, 1 };
		assert numberOfAlternatingGroups(colors2, 6) == 2;

		final int[] colors3 = { 1, 1, 0, 1 };
		assert numberOfAlternatingGroups(colors3, 4) == 0;
	}

	static int numberOfAlternatingGroups(int[] colors, int k) {
		final int n = colors.length;
		int g = 0;
		int c = 1;

		for (int i = 1; i < n; i++) {
			if (colors[i] == colors[i - 1])
				c = 1;
			else
				c = c + 1;

			if (c >= k)
				g = g + 1;
		}

		if (colors[0] == colors[n - 1])
			return g;

		c = Math.min(c + 1, k);
		for (int i = 1; i < k - 1 && colors[i] != colors[i - 1]; i++)
			c = c + 1;

		if (c >= k)
			return g + c - k + 1;

		return g;
	}
}

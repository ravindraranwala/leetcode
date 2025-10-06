package com.coding.challenge.two.pointer;

class ContainerWithMostWater {
	ContainerWithMostWater() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		assert maxArea(height1) == 49;

		final int[] height2 = { 1, 1 };
		assert maxArea(height2) == 1;
	}

	static int maxArea(int[] height) {
		final int n = height.length;
		int i = 0;
		int j = n - 1;
		int v = 0;

		while (i < j) {
			v = Math.max(v, (j - i) * Math.min(height[i], height[j]));
			if (height[i] <= height[j])
				i = i + 1;
			else
				j = j - 1;
		}
		return v;
	}
}

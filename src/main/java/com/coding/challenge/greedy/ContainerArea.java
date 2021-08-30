package com.coding.challenge.greedy;

class ContainerArea {

	ContainerArea() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] h = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		final int area = maxArea(h);
		System.out.println(area);
	}

	static int maxArea(int[] height) {
		int a = 0;
		final int n = height.length;
		int i = 0;
		int j = n - 1;

		while (i < j) {
			final int na = Math.min(height[i], height[j]) * (j - i);
			if (a < na)
				a = na;
			if (height[i] < height[j])
				i = i + 1;
			else
				j = j - 1;
		}
		return a;
	}
}

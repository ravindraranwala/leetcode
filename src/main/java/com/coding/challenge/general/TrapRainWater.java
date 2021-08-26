package com.coding.challenge.general;

class TrapRainWater {

	TrapRainWater() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] h = { 9, 6, 8, 8, 5, 6, 3 };
		final int v = trap(h);
		System.out.println(v);
	}

	static int trap(int[] height) {
		int lh = height[0];
		final int n = height.length;
		int rh = height[n - 1];
		int lv = 0;
		int rv = 0;
		int v = 0;

		for (int i = 0; i < n; i++) {
			if (lh <= height[i]) {
				lh = height[i];
				v = v + lv;
				lv = 0;
			}
			lv = lv + lh - height[i];
			if (rh < height[n - i - 1]) {
				rh = height[n - i - 1];
				v = v + rv;
				rv = 0;
			}
			rv = rv + rh - height[n - i - 1];
		}
		return v;
	}
}

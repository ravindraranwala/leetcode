package com.coding.challenge.math;

class MirrorDistanceOfAnInteger {
	MirrorDistanceOfAnInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert mirrorDistance(25) == 27;
		assert mirrorDistance(10) == 9;
		assert mirrorDistance(7) == 0;
	}

	static int mirrorDistance(int n) {
		return Math.abs(n - reverseNumber(n));
	}

	private static int reverseNumber(int n) {
		int ans = 0;
		for (int curr = n; curr > 0; curr = curr / 10)
			ans = ans * 10 + (curr % 10);

		return ans;
	}
}

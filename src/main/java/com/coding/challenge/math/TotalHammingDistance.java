package com.coding.challenge.math;

class TotalHammingDistance {
	TotalHammingDistance() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 4, 14, 2 };
		assert totalHammingDistance(numsOne) == 6;

		final int[] numsTwo = { 4, 14, 4 };
		assert totalHammingDistance(numsTwo) == 4;
	}

	static int totalHammingDistance(int[] nums) {
		final int n = nums.length;
		final int[] oneCnt = new int[32];
		for (int num : nums) {
			final String bitStr = Integer.toBinaryString(num);
			final int l = bitStr.length();
			for (int i = 0; i < l; i++)
				if (bitStr.charAt(i) == '1')
					oneCnt[32 - l + i] = oneCnt[32 - l + i] + 1;
		}
		int d = 0;
		for (int i = 0; i < 32; i++)
			d = d + oneCnt[i] * (n - oneCnt[i]);
		return d;
	}
}

package com.coding.challenge.math;

class DivisibleAndNonDivisibleSumsDifference {
	DivisibleAndNonDivisibleSumsDifference() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert differenceOfSumsOptimized(10, 3) == 19;
		assert differenceOfSumsOptimized(5, 6) == 15;
		assert differenceOfSumsOptimized(5, 1) == -15;
	}

	static int differenceOfSums(int n, int m) {
		int nums1 = 0;
		int nums2 = 0;
		for (int i = 0; i <= n; i++) {
			if (i % m == 0)
				nums2 = nums2 + i;
			else
				nums1 = nums1 + i;
		}
		return nums1 - nums2;
	}

	static int differenceOfSumsOptimized(int n, int m) {
		final int s1 = n * (n + 1) / 2;
		final int k = n / m;
		final int s2 = m * k * (k + 1) / 2;
		return s1 - s2 - s2;
	}
}

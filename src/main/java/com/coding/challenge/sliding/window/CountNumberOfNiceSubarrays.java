package com.coding.challenge.sliding.window;

class CountNumberOfNiceSubarrays {
	CountNumberOfNiceSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 2, 1, 1 };
		assert numberOfSubarrays(nums1, 3) == 2;

		final int[] nums2 = { 2, 4, 6 };
		assert numberOfSubarrays(nums2, 1) == 0;

		final int[] nums3 = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		assert numberOfSubarrays(nums3, 2) == 16;
	}

	static int numberOfSubarrays(int[] nums, int k) {
		final int n = nums.length;
		int cnt = 0;
		for (int s = 0, e = 0, oddCnt = 0, subarrs = 0; e < n; e++) {
			oddCnt = oddCnt + nums[e] % 2;

			if (oddCnt > k) {
				subarrs = 0;
				oddCnt = oddCnt - 1;
				s = s + 1;
			}

			while (oddCnt == k && nums[s] % 2 == 0) {
				subarrs = subarrs + 1;
				s = s + 1;
			}
			if (oddCnt == k)
				cnt = cnt + subarrs + 1;
		}
		return cnt;
	}
}

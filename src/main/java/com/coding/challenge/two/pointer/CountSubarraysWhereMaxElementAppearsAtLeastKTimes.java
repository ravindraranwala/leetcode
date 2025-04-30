package com.coding.challenge.two.pointer;

class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
	CountSubarraysWhereMaxElementAppearsAtLeastKTimes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 2, 3, 3 };
		assert countSubarrays(nums1, 2) == 6;

		final int[] nums2 = { 1, 4, 2, 1 };
		assert countSubarrays(nums2, 3) == 0;
	}

	static long countSubarrays(int[] nums, int k) {
		final int n = nums.length;
		int maxVal = 0;
		for (int e : nums)
			maxVal = Math.max(maxVal, e);

		long ans = 0;
		for (int i = 0, j = 0, leftCnt = 0, rightCnt = 0; j < n; j++) {
			if (nums[j] == maxVal)
				rightCnt = rightCnt + 1;
			while (rightCnt - leftCnt == k) {
				if (nums[i] == maxVal)
					leftCnt = leftCnt + 1;
				i = i + 1;
			}
			ans = ans + i;
		}
		return ans;
	}
}

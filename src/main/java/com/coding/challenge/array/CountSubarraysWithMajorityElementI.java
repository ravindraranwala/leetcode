package com.coding.challenge.array;

class CountSubarraysWithMajorityElementI {
	CountSubarraysWithMajorityElementI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 3 };
		assert countMajoritySubarrays(nums1, 2) == 5;

		final int[] nums2 = { 1, 1, 1, 1 };
		assert countMajoritySubarrays(nums2, 1) == 10;

		final int[] nums3 = { 1, 2, 3 };
		assert countMajoritySubarrays(nums3, 4) == 0;
	}

	static int countMajoritySubarrays(int[] nums, int target) {
		final int n = nums.length;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i, tCnt = 0; j >= 0; j--) {
				if (nums[j] == target)
					tCnt = tCnt + 1;

				final int l = i - j + 1;
				if (tCnt > l - tCnt)
					cnt = cnt + 1;
			}

		}
		return cnt;
	}
}

package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CountCompleteSubarraysInAnArray {
	CountCompleteSubarraysInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 1, 2, 2 };
		assert countCompleteSubarrays(nums1) == 4;

		final int[] nums2 = { 5, 5, 5, 5 };
		assert countCompleteSubarrays(nums2) == 10;
	}

	static int countCompleteSubarrays(int[] nums) {
		final int n = nums.length;
		final Set<Integer> s = new HashSet<>();
		for (int val : nums)
			s.add(val);

		final Map<Integer, Integer> f = new HashMap<>();
		final int c = s.size();
		int ans = 0;
		for (int i = 0, j = 0; j < n; j++) {
			final int val = nums[j];
			f.merge(val, 1, Integer::sum);
			while (f.size() == c) {
				ans = ans + n - j;
				final int lowerVal = nums[i];
				f.put(lowerVal, f.get(lowerVal) - 1);
				if (f.get(lowerVal) == 0)
					f.remove(lowerVal);
				i = i + 1;
			}
		}
		return ans;
	}
}

package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class SubarraysWithKDifferentInts {
	SubarraysWithKDifferentInts() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 1, 2, 1, 2, 3 };
		assert subarraysWithKDistinct(arrOne, 2) == 7;

		final int[] arrTwo = { 1, 2, 1, 3, 4 };
		assert subarraysWithKDistinct(arrTwo, 3) == 3;

		final int[] arrThree = { 1, 2, 2, 1, 3 };
		assert subarraysWithKDistinct(arrThree, 2) == 6;

		final int[] arrFour = { 2, 2, 2, 2, 1 };
		assert subarraysWithKDistinct(arrFour, 2) == 4;
	}

	static int subarraysWithKDistinct(int[] nums, int k) {
		final int n = nums.length;
		int c = 0;
		final Map<Integer, Integer> t = new HashMap<>();

		for (int j = 0, i = 0, s = 0, d = 0; j < n; j++) {
			if (nums[d] != nums[j] && !t.containsKey(nums[j]))
				s = 0;
			t.merge(nums[j], 1, Integer::sum);
			while (t.size() == k) {
				// number of sub arrays with k distinct integers, ending at j.
				s = s + 1;
				t.put(nums[i], t.get(nums[i]) - 1);
				if (t.get(nums[i]) == 0)
					t.remove(nums[i]);
				d = i;
				i = i + 1;
			}
			c = c + s;
		}
		return c;
	}
}

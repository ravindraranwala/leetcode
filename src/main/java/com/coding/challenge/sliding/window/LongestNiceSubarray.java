package com.coding.challenge.sliding.window;

class LongestNiceSubarray {
	LongestNiceSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 8, 48, 10 };
		assert longestNiceSubarray(nums1) == 3;

		final int[] nums2 = { 3, 1, 5, 11, 13 };
		assert longestNiceSubarray(nums2) == 1;

		final int[] nums3 = { 84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1, 1048576,
				16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525, 739558112,
				267703680 };
		assert longestNiceSubarray(nums3) == 8;
	}

	static int longestNiceSubarray(int[] nums) {
		final int n = nums.length;
		int l = 1;
		long s = 0;
		for (int i = 0, j = 0, xor = 0; j < n; j++) {
			s = s + nums[j];
			xor = xor ^ nums[j];
			while (s != xor) {
				s = s - nums[i];
				xor = xor ^ nums[i];
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}

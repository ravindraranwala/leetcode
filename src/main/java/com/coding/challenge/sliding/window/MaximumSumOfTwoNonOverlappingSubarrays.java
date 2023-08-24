package com.coding.challenge.sliding.window;

class MaximumSumOfTwoNonOverlappingSubarrays {
	MaximumSumOfTwoNonOverlappingSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 0, 6, 5, 2, 2, 5, 1, 9, 4 };
		assert maxSumTwoNoOverlap(numsOne, 1, 2) == 20;

		final int[] numsTwo = { 3, 8, 1, 3, 2, 1, 8, 9, 0 };
		assert maxSumTwoNoOverlap(numsTwo, 3, 2) == 29;

		final int[] numsThree = { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 };
		assert maxSumTwoNoOverlap(numsThree, 4, 3) == 31;
	}

	static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		// Fixed size window.
		final int n = nums.length;
		final int[] windowTwoMaxSumRightToLeft = new int[n];
		for (int i = n - 1, s = 0, wMax = 0; i >= 0; i--) {
			s = s + nums[i];
			if (i <= n - secondLen) {
				wMax = Math.max(wMax, s);
				windowTwoMaxSumRightToLeft[i] = wMax;
				s = s - nums[i + secondLen - 1];
			}
		}

		int ans = 0;
		// first window in left and second window in right.
		for (int i = 0, s = 0; i < n - secondLen; i++) {
			// window finishes at i
			s = s + nums[i];
			if (i >= firstLen - 1) {
				ans = Math.max(ans, s + windowTwoMaxSumRightToLeft[i + 1]);
				s = s - nums[i - firstLen + 1];
			}
		}

		final int[] windowTwoMaxSumLeftToRight = new int[n];
		for (int i = 0, s = 0, wMax = 0; i < n; i++) {
			// window finishes at i
			s = s + nums[i];
			if (i >= secondLen - 1) {
				wMax = Math.max(wMax, s);
				windowTwoMaxSumLeftToRight[i] = wMax;
				s = s - nums[i - secondLen + 1];
			}
		}

		// first window on right and second window on left.
		for (int i = n - 1, s = 0; i >= secondLen; i--) {
			s = s + nums[i];
			if (i <= n - firstLen) {
				ans = Math.max(ans, s + windowTwoMaxSumLeftToRight[i - 1]);
				s = s - nums[i + firstLen - 1];
			}
		}
		return ans;
	}
}

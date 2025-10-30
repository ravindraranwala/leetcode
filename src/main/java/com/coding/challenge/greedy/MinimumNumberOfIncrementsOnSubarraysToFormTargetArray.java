package com.coding.challenge.greedy;

class MinimumNumberOfIncrementsOnSubarraysToFormTargetArray {
	MinimumNumberOfIncrementsOnSubarraysToFormTargetArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] target1 = { 1, 2, 3, 2, 1 };
		assert minNumberOperations(target1) == 3;

		final int[] target2 = { 3, 1, 1, 2 };
		assert minNumberOperations(target2) == 4;

		final int[] target3 = { 3, 1, 5, 4, 2 };
		assert minNumberOperations(target3) == 7;
	}

	static int minNumberOperations(int[] target) {
		final int n = target.length;
		int cnt = 0;
		for (int i = 0, prev = 0; i < n; i++) {
			if (target[i] > prev)
				cnt = cnt + target[i] - prev;

			prev = target[i];
		}
		return cnt;
	}
}

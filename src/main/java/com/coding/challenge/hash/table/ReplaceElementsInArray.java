package com.coding.challenge.hash.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ReplaceElementsInArray {
	ReplaceElementsInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 4, 6 };
		final int[][] ops1 = { { 1, 3 }, { 4, 7 }, { 6, 1 } };
		final int[] exp1 = { 3, 2, 7, 1 };
		assert Arrays.equals(exp1, arrayChange(nums1, ops1));
	}

	static int[] arrayChange(int[] nums, int[][] operations) {
		final int n = nums.length;
		final int[] replaced = new int[n];
		final Map<Integer, Integer> numIdx = new HashMap<>();
		for (int i = 0; i < n; i++) {
			numIdx.put(nums[i], i);
			replaced[i] = nums[i];
		}

		for (int[] op : operations) {
			final int idx = numIdx.get(op[0]);
			replaced[idx] = op[1];
			numIdx.remove(op[0]);
			numIdx.put(op[1], idx);
		}
		return replaced;
	}
}

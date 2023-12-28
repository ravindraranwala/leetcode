package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

class Permutations {
	Permutations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		System.out.println(permute(nums1));

		final int[] nums2 = { 0, 1 };
		System.out.println(permute(nums2));

		final int[] nums3 = { 1 };
		System.out.println(permute(nums3));
	}

	static List<List<Integer>> permute(int[] nums) {
		final List<List<Integer>> ans = new ArrayList<>();
		final int n = nums.length;
		permute(nums, new boolean[n], ans, new ArrayList<>(), n);
		return ans;
	}

	private static void permute(int[] nums, boolean[] explored, List<List<Integer>> ans, List<Integer> l, int n) {
		if (n == 0) {
			ans.add(new ArrayList<>(l));
			return;
		}
		final int m = nums.length;
		for (int i = 0; i < m; i++) {
			if (!explored[i]) {
				// chosen step.
				l.add(nums[i]);
				explored[i] = true;
				// explore or recursive call.
				permute(nums, explored, ans, l, n - 1);
				// unchoose.
				l.remove(l.size() - 1);
				explored[i] = false;
			}
		}
	}
}

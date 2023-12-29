package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permutations2 {
	Permutations2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 2 };
		System.out.println(permuteUnique(nums1));

		final int[] nums2 = { 1, 2, 3 };
		System.out.println(permuteUnique(nums2));
	}

	static List<List<Integer>> permuteUnique(int[] nums) {
		final List<List<Integer>> ans = new ArrayList<>();
		final int n = nums.length;
		permuteUnique(nums, new boolean[n], ans, new ArrayList<>(), n);
		return ans;
	}

	private static void permuteUnique(int[] nums, boolean[] explored, List<List<Integer>> ans, List<Integer> l, int n) {
		if (n == 0) {
			ans.add(new ArrayList<>(l));
			return;
		}
		final int m = nums.length;
		final Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			if (!explored[i] && !s.contains(nums[i])) {
				s.add(nums[i]);
				// chosen step.
				l.add(nums[i]);
				explored[i] = true;
				// explore or recursive call.
				permuteUnique(nums, explored, ans, l, n - 1);
				// unchoose.
				l.remove(l.size() - 1);
				explored[i] = false;
			}
		}
	}
}

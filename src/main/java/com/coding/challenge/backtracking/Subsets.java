package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

class Subsets {
	private final List<List<Integer>> powerSet = new ArrayList<>();

	public Subsets() {

	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		System.out.println(new Subsets().subsets(nums1));
	}

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, new ArrayList<>(), nums.length);
		return powerSet;
	}

	private void backtrack(int[] nums, List<Integer> currSet, int n) {
		// trivial case of the recursion.
		if (n == 0) {
			powerSet.add(new ArrayList<Integer>(currSet));
			return;
		}

		// exclude the number and explore.
		backtrack(nums, currSet, n - 1);
		// choose.
		// include the number and explore.
		currSet.add(nums[n - 1]);
		backtrack(nums, currSet, n - 1);
		// unchoose.
		currSet.remove(currSet.size() - 1);
	}
}

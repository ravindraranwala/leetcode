package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

class Combinations {
	Combinations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(combine(1, 1));
		System.out.println(combine(4, 2));
		System.out.println(combine(5, 4));
	}

	static List<List<Integer>> combine(int n, int k) {
		final List<List<Integer>> combinations = new ArrayList<>();
		backtrack(n, k, 1, combinations, new int[k]);
		return combinations;
	}

	private static void backtrack(int n, int k, int choice, List<List<Integer>> combinations, int[] combination) {
		// trivial case of the recursion.
		if (k == 0) {
			final List<Integer> ans = new ArrayList<>(combination.length);
			for (int num : combination)
				ans.add(num);
			combinations.add(ans);
			return;
		}
		if (choice > n || n - choice + 1 < k)
			return;

		// exclude the current choice and explore.
		backtrack(n, k, choice + 1, combinations, combination);
		// choose
		combination[combination.length - k] = choice;
		// include the current choice and explore.
		// unchoose the previous value, and then choosing a new value will be done using
		// an overwrite at that specific index position. Ex: [1, 2] -> [1, 3].
		backtrack(n, k - 1, choice + 1, combinations, combination);
	}
}

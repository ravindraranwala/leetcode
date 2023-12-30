package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

class CombinationSumIII {
	CombinationSumIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 7));
		System.out.println(combinationSum3(3, 9));
		System.out.println(combinationSum3(4, 1));
	}

	static List<List<Integer>> combinationSum3(int k, int n) {
		final List<List<Integer>> ans = new ArrayList<>();
		backtrack(k, n, 1, ans, new int[k]);
		return ans;
	}

	private static void backtrack(int k, int n, int currChoice, List<List<Integer>> ans, int[] choices) {
		if (k == 0 && n == 0) {
			final List<Integer> combination = new ArrayList<>(choices.length);
			for (int num : choices)
				combination.add(num);
			ans.add(combination);
			return;
		}
		if (currChoice > 9 || n <= 0 || k == 0)
			return;

		// exclude the current choice and explore.
		backtrack(k, n, currChoice + 1, ans, choices);
		// include the current choice and explore.
		// unchoose the previous value, and then choosing a new value is equivalent to
		// an overwrite at that specific index position.
		choices[choices.length - k] = currChoice;
		backtrack(k - 1, n - currChoice, currChoice + 1, ans, choices);
	}
}

package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumbersWithSameConsecutiveDifferences {
	NumbersWithSameConsecutiveDifferences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
		System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
	}

	static int[] numsSameConsecDiff(int n, int k) {
		final List<Integer> ans = new ArrayList<>();
		for (int num = 1; num < 10; num++) {
			final StringBuilder state = new StringBuilder();
			state.append(num);
			backtrack(n, k, num, state, ans);
		}
		final int l = ans.size();
		final int[] a = new int[l];
		for (int i = 0; i < l; i++)
			a[i] = ans.get(i);
		return a;
	}

	private static void backtrack(int n, int k, int prevNum, StringBuilder state, List<Integer> ans) {
		if (state.length() == n) {
			ans.add(Integer.parseInt(state.toString()));
			return;
		}

		for (int num = 0; num < 10; num++) {
			if (Math.abs(num - prevNum) == k) {
				// choose.
				state.append(num);
				// explore.
				backtrack(n, k, num, state, ans);
				// unchoose.
				state.deleteCharAt(state.length() - 1);
			}
		}
	}
}

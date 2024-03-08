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
		for (int num = 1; num < 10; num++)
			backtrack(n - 1, k, num, ans);

		final int l = ans.size();
		final int[] a = new int[l];
		for (int i = 0; i < l; i++)
			a[i] = ans.get(i);
		return a;
	}

	private static void backtrack(int n, int k, int num, List<Integer> ans) {
		if (n == 0) {
			ans.add(num);
			return;
		}

		final int tailDigit = num % 10;
		// we have at most two possible choices here.
		// choose.
		if (tailDigit + k < 10)
			// explore.
			backtrack(n - 1, k, num * 10 + tailDigit + k, ans);

		// choose.
		if (k != 0 && tailDigit - k >= 0)
			// explore.
			backtrack(n - 1, k, num * 10 + tailDigit - k, ans);
	}
}

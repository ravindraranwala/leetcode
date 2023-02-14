package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.Comparator;

import com.coding.challenge.BinarySearch;

class RussianDollEnvelopes {
	RussianDollEnvelopes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] envelopsOne = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		assert maxEnvelopes(envelopsOne) == 3;

		final int[][] envelopsTwo = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
		assert maxEnvelopes(envelopsTwo) == 1;

		final int[][] envelopsThree = { { 2, 100 }, { 3, 200 }, { 4, 300 }, { 5, 500 }, { 5, 400 }, { 5, 250 },
				{ 6, 370 }, { 6, 360 }, { 7, 380 } };
		assert maxEnvelopes(envelopsThree) == 5;
	}

	static int maxEnvelopes(int[][] envelopes) {
		final int n = envelopes.length;
		final int[][] e = new int[n][2];
		// sort the envelops by their dimensions first.
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return Integer.compare(b[1], a[1]);
				else
					return Integer.compare(a[0], b[0]);
			}
		});
		e[0] = envelopes[0];
		int l = 1;

		for (int i = 1; i < n; i++) {
			if (envelopes[i][0] > e[l - 1][0] && envelopes[i][1] > e[l - 1][1]) {
				e[l] = envelopes[i];
				l = l + 1;
			} else {
				final int[] target = { envelopes[i][0] - 1, envelopes[i][1] - 1 };
				final int j = BinarySearch.successor(e, target[1], 0, l - 1, a -> a[1]);
				e[j] = new int[] { envelopes[i][0], envelopes[i][1] };
			}
		}
		return l;
	}
}

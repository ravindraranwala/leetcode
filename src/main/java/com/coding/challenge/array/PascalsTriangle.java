package com.coding.challenge.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PascalsTriangle {
	PascalsTriangle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1), Arrays.asList(1, 2, 1), Arrays.asList(1, 3, 3, 1),
				Arrays.asList(1, 4, 6, 4, 1)).equals(generate(5));
		assert Arrays.asList(Arrays.asList(1)).equals(generate(1));
		assert Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1)).equals(generate(2));
	}

	static List<List<Integer>> generate(int numRows) {
		if (numRows == 1)
			return Arrays.asList(Arrays.asList(1));

		// init.
		final List<List<Integer>> ans = new ArrayList<>();
		ans.add(Arrays.asList(1));
		ans.add(Arrays.asList(1, 1));

		for (int i = 2; i < numRows; i++) {
			ans.add(new ArrayList<>());
			ans.get(i).add(1);
			for (int j = 1; j < i; j++)
				ans.get(i).add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
			ans.get(i).add(1);
		}
		return ans;
	}
}

package com.coding.challenge.string;

import java.util.Arrays;

class DivideStringIntoGroupsOfSizek {
	DivideStringIntoGroupsOfSizek() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] ans1 = { "abc", "def", "ghi" };
		assert Arrays.equals(ans1, divideString("abcdefghi", 3, 'x'));

		final String[] ans2 = { "abc", "def", "ghi", "jxx" };
		assert Arrays.equals(ans2, divideString("abcdefghij", 3, 'x'));
	}

	static String[] divideString(String s, int k, char fill) {
		final int n = s.length();
		final int groupCnt = (n + k - 1) / k;
		final String[] ans = new String[groupCnt];
		StringBuilder currGroup = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (currGroup.length() == k) {
				ans[i / k - 1] = currGroup.toString();
				currGroup = new StringBuilder();
			}
			currGroup.append(s.charAt(i));
		}

		while (currGroup.length() < k)
			currGroup.append(fill);

		ans[groupCnt - 1] = currGroup.toString();
		return ans;
	}
}

package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {

	LargestNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 10, 2 };
		assert "210".equals(largestNumber(numsOne));

		final int[] numsTwo = { 3, 30, 34, 5, 9 };
		assert "9534330".equals(largestNumber(numsTwo));

		final int[] numsThree = { 0, 0 };
		assert "0".equals(largestNumber(numsThree));
	}

	static String largestNumber(int[] nums) {
		final Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				final String s1 = o1 + o2;
				final String s2 = o2 + o1;
				final int c = s1.compareTo(s2);
				if (c < 0)
					return -1;
				if (c > 0)
					return 1;
				return 0;
			}
		};
		final int n = nums.length;
		final String[] s = new String[n];
		for (int i = 0; i < n; i++)
			s[i] = nums[i] + "";

		Arrays.sort(s, cmp);
		final StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--)
			sb.append(s[i]);

		final String ans = sb.toString();
		return ans.charAt(0) == '0' ? "0" : ans;
	}
}
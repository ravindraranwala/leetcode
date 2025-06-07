package com.coding.challenge.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

class UsingRobotToPrintTheLexicographicallySmallestString {
	private static final char FIRST_LETTER = 'a';

	UsingRobotToPrintTheLexicographicallySmallestString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "azz".equals(robotWithString("zza"));
		assert "abc".equals(robotWithString("bac"));
		assert "addb".equals(robotWithString("bdda"));
		assert "aabbbctwzrqpcde".equals(robotWithString("edcabapqrbzbwct"));
	}

	static String robotWithString(String s) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		final int n = s.length();
		final StringBuilder ans = new StringBuilder();
		final Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0, smallestLetterOffset = 0; i < n; i++) {
			while (f[smallestLetterOffset] == 0)
				smallestLetterOffset = smallestLetterOffset + 1;

			while (!stack.isEmpty() && stack.peek() - FIRST_LETTER <= smallestLetterOffset)
				ans.append(stack.pop()); // print to the output. partial output.

			// consume the ith letter next.
			stack.push(s.charAt(i));
			f[s.charAt(i) - FIRST_LETTER] = f[s.charAt(i) - FIRST_LETTER] - 1;
		}

		while (!stack.isEmpty())
			ans.append(stack.pop());

		return ans.toString();
	}
}

package com.coding.challenge.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

class MaximumScoreFromRemovingSubstringsStack {

	MaximumScoreFromRemovingSubstringsStack() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumGain("cdbcbbaaabab", 4, 5) == 19;
		assert maximumGain("aabbaaxybbaabb", 5, 4) == 20;
		assert maximumGain("aaaabbbb", 4, 5) == 16;
	}

	static int maximumGain(String s, int x, int y) {
		final int n = s.length();
		// init.
		final char firstLetter = x > y ? 'a' : 'b';
		final char secondLetter = x > y ? 'b' : 'a';
		final int minPoints = Math.min(x, y);
		final int maxPoints = Math.max(x, y);
		final Deque<Character> stack = new ArrayDeque<>();
		int p = 0;

		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			if (ch == firstLetter)
				stack.push(ch);
			else if (ch == secondLetter) {
				if (!stack.isEmpty() && stack.peek() == firstLetter) {
					stack.pop();
					p = p + maxPoints;
				} else
					stack.push(ch);
			}

			if ((ch != firstLetter && ch != secondLetter) || i == n - 1) {
				int firstCnt = 0;
				int secondCnt = 0;
				while (!stack.isEmpty()) {
					final char letter = stack.pop();
					if (letter == firstLetter)
						firstCnt = firstCnt + 1;
					else
						secondCnt = secondCnt + 1;
				}
				p = p + Math.min(firstCnt, secondCnt) * minPoints;
			}
		}
		return p;
	}
}

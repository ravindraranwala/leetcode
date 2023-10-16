package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Remove_K_Digits {
	Remove_K_Digits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "1219".equals(removeKdigits("1432219", 3));
		assert "200".equals(removeKdigits("10200", 1));
		assert "0".equals(removeKdigits("10", 2));
		assert "0".equals(removeKdigits("10000", 1));
		assert "0".equals(removeKdigits("10000", 2));
	}

	static String removeKdigits(String num, int k) {
		final Deque<Character> s = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (!s.isEmpty() && s.peek() > num.charAt(i))
				s.pop();
			s.push(num.charAt(i));
		}

		final StringBuilder sb = new StringBuilder();
		final int n = num.length();
		for (int i = k; i < n; i++) {
			while (!s.isEmpty() && s.peek() > num.charAt(i))
				s.pop();
			s.push(num.charAt(i));
			sb.append(s.pollLast());
		}
		final String ans = sb.toString();
		final int m = ans.length();
		// getting rid of leading zeros.
		int j = 0;
		while (j < m && ans.charAt(j) == '0')
			j = j + 1;
		return j == m ? "0" : ans.substring(j);
	}
}

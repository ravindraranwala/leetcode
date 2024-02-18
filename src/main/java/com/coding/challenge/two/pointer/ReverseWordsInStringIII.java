package com.coding.challenge.two.pointer;

class ReverseWordsInStringIII {
	ReverseWordsInStringIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "s'teL ekat edoCteeL tsetnoc".equals(reverseWords("Let's take LeetCode contest"));
	}

	static String reverseWords(String s) {
		final int n = s.length();
		final char[] chars = s.toCharArray();

		for (int i = 0, lastSpace = -1; i <= n; i++) {
			if (i == n || s.charAt(i) == ' ') {
				for (int end = i - 1, start = lastSpace + 1; start <= end; start++, end--) {
					final char temp = chars[start];
					chars[start] = chars[end];
					chars[end] = temp;

				}
				lastSpace = i;
			}
		}
		return String.valueOf(chars);
	}
}

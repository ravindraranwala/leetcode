package com.coding.challenge.two.pointer;

class CheckIfStringCanBreakAnotherString {
	private static final char FIRST_LETTER = 'a';

	CheckIfStringCanBreakAnotherString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkIfCanBreak("abc", "xya");
		assert !checkIfCanBreak("abe", "acd");
		assert checkIfCanBreak("leetcodee", "interview");
	}

	static boolean checkIfCanBreak(String s1, String s2) {
		final int n = s1.length();
		final int[] f1 = new int[26];
		final int[] f2 = new int[26];

		for (int i = 0; i < n; i++) {
			f1[s1.charAt(i) - FIRST_LETTER] = f1[s1.charAt(i) - FIRST_LETTER] + 1;
			f2[s2.charAt(i) - FIRST_LETTER] = f2[s2.charAt(i) - FIRST_LETTER] + 1;
		}

		boolean ans1 = true;
		boolean ans2 = true;
		for (int i = 25, sum1 = 0, sum2 = 0; i >= 0; i--) {
			sum1 = sum1 + f1[i];
			sum2 = sum2 + f2[i];
			ans1 = ans1 && sum1 >= sum2;
			ans2 = ans2 && sum2 >= sum1;
		}
		return ans1 || ans2;
	}
}

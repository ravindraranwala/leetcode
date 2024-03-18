package com.coding.challenge.two.pointer;

class IsSubsequence {
	IsSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isSubsequence("abc", "ahbgdc");
		assert !isSubsequence("axc", "ahbgdc");
		assert isSubsequence("able", "abppplee");
		assert isSubsequence("ale", "abppplee");
		assert isSubsequence("apple", "abppplee");
		assert !isSubsequence("bale", "abppplee");
		assert !isSubsequence("kangaroo", "abppplee");
	}

	static boolean isSubsequence(String s, String t) {
		final int m = s.length();
		final int n = t.length();
		for (int i = 0, j = 0; i < m; i++) {
			while (j < n && s.charAt(i) != t.charAt(j))
				j = j + 1;
			if (j == n)
				return false;
			else
				j = j + 1;
		}
		return true;
    }
}

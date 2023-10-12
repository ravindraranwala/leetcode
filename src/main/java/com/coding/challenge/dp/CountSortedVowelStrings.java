package com.coding.challenge.dp;

class CountSortedVowelStrings {
	CountSortedVowelStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countVowelStrings(1) == 5;

		assert countVowelStrings(2) == 15;

		assert countVowelStrings(3) == 35;

		assert countVowelStrings(4) == 70;

		assert countVowelStrings(33) == 66045;
	}

	static int countVowelStrings(int n) {
		final int[] a = new int[] { 1, 1, 1, 1, 1 };

		for (int l = 2; l <= n; l++)
			for (int i = 1; i < 5; i++)
				a[i] = a[i - 1] + a[i];

		return a[0] + a[1] + a[2] + a[3] + a[4];
	}
}

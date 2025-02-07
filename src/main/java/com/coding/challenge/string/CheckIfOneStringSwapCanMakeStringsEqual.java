package com.coding.challenge.string;

class CheckIfOneStringSwapCanMakeStringsEqual {
	CheckIfOneStringSwapCanMakeStringsEqual() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert areAlmostEqual("bank", "kanb");
		assert !areAlmostEqual("attack", "defend");
		assert areAlmostEqual("kelb", "kelb");
	}

	static boolean areAlmostEqual(String s1, String s2) {
		final int n = s1.length();

		int j = 0;
		while (j < n && s1.charAt(j) == s2.charAt(j))
			j = j + 1;
		
		if (j == n)
			return true;

		int k = n - 1;
		while (s1.charAt(k) == s2.charAt(k))
			k = k - 1;

		if (j == k)
			return false;
		
		for (int i = j + 1; i < k; i++)
			if (s1.charAt(i) != s2.charAt(i))
				return false;
		
		return s1.charAt(j) == s2.charAt(k) && s1.charAt(k) == s2.charAt(j);
	}
}

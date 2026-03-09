package com.coding.challenge.string;

class FindUniqueBinaryString {
	private static final char ZERO = '0';
	private static final char ONE = '1';

	FindUniqueBinaryString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] nums1 = { "01", "10" };
		System.out.println(findDifferentBinaryString(nums1));

		final String[] nums2 = { "00", "01" };
		System.out.println(findDifferentBinaryString(nums2));

		final String[] nums3 = { "111", "011", "001" };
		System.out.println(findDifferentBinaryString(nums3));
	}

	static String findDifferentBinaryString(String[] nums) {
		final int n = nums.length;
		final boolean[] ones = new boolean[n + 1];
		for (String s : nums) {
			int c = 0;
			for (char ch : s.toCharArray())
				if (ch == ONE)
					c = c + 1;

			ones[c] = true;
		}

		int oneCnt = -1;
		for (int i = 0; i <= n; i++)
			if (!ones[i])
				oneCnt = i;

		// constructing the output.
		final char[] a = new char[n];
		for (int j = 0; j < oneCnt; j++)
			a[j] = ONE;

		for (int k = oneCnt; k < n; k++)
			a[k] = ZERO;

		return new String(a);
	}
}

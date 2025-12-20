package com.coding.challenge.string;

class DeleteColumnsToMakeSorted {
	DeleteColumnsToMakeSorted() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] strs1 = { "cba", "daf", "ghi" };
		assert minDeletionSize(strs1) == 1;

		final String[] strs2 = { "a", "b" };
		assert minDeletionSize(strs2) == 0;

		final String[] strs3 = { "zyx", "wvu", "tsr" };
		assert minDeletionSize(strs3) == 3;
	}

	static int minDeletionSize(String[] strs) {
		final int n = strs[0].length();
		int d = 0;
		for (int i = 0; i < n; i++) {
			char ch = Character.MIN_VALUE;
			for (String s : strs) {
				if (s.charAt(i) < ch) {
					d = d + 1;
					break;
				}
				ch = s.charAt(i);
			}
		}
		return d;
	}
}

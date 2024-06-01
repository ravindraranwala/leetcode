package com.coding.challenge.two.pointer;

class CompareVersionNumbers {
	CompareVersionNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert compareVersion("1.2", "1.10") == -1;
		assert compareVersion("1.01", "1.001") == 0;
		assert compareVersion("1.0", "1.0.0.0") == 0;
		assert compareVersion("1.0.1", "1") == 1;
	}

	static int compareVersion(String version1, String version2) {
		final int m = version1.length();
		final int n = version2.length();
		int i = 0;
		int j = 0;
		int p = 0;
		int q = 0;

		while (j < m || q < n) {
			int val1 = 0;
			while (j < m && version1.charAt(j) != '.')
				j = j + 1;
			if (i < m)
				val1 = Integer.parseInt(version1.substring(i, j));
			j = j + 1;
			i = j;

			int val2 = 0;
			while (q < n && version2.charAt(q) != '.')
				q = q + 1;
			if (p < n)
				val2 = Integer.parseInt(version2.substring(p, q));
			q = q + 1;
			p = q;

			if (val1 != val2)
				return Integer.compare(val1, val2);
		}
		return 0;
	}
}

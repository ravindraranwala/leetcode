package com.coding.challenge.binary.search;

class FindSmallestLetterGreaterThanTarget {
	FindSmallestLetterGreaterThanTarget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[] letters1 = { 'c', 'f', 'j' };
		assert nextGreatestLetter(letters1, 'a') == 'c';

		assert nextGreatestLetter(letters1, 'c') == 'f';

		final char[] letters2 = { 'x', 'x', 'y', 'y' };
		assert nextGreatestLetter(letters2, 'z') == 'x';
	}

	static char nextGreatestLetter(char[] letters, char target) {
		final int n = letters.length;
		int i = 0;
		int j = n - 1;
		while (i < j) {
			final int mid = (i + j) / 2;
			if (letters[mid] > target)
				j = mid;
			else
				i = mid + 1;
		}
		if (letters[i] > target)
			return letters[i];

		return letters[0];
	}
}

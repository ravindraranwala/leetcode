package com.coding.challenge.string;

class ShortestDistanceToTargetStringInCircularArray {
	ShortestDistanceToTargetStringInCircularArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "hello", "i", "am", "leetcode", "hello" };
		assert closestTarget(words1, "hello", 1) == 1;

		final String[] words2 = { "a", "b", "leetcode" };
		assert closestTarget(words2, "leetcode", 0) == 1;

		final String[] words3 = { "i", "eat", "leetcode" };
		assert closestTarget(words3, "ate", 0) == -1;
	}

	static int closestTarget(String[] words, String target, int startIndex) {
		final int n = words.length;
		int d = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (target.equals(words[i]) && i < startIndex)
				d = Math.min(d, Math.min(startIndex - i, n - (startIndex - i)));
			else if (target.equals(words[i]) && i >= startIndex)
				d = Math.min(d, Math.min(i - startIndex, n - (i - startIndex)));
		}
		return d == Integer.MAX_VALUE ? -1 : d;
	}
}

package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
	LongestConsecutiveSequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 100, 4, 200, 1, 3, 2 };
		assert longestConsecutive(numsOne) == 4;

		final int[] numsTwo = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		assert longestConsecutive(numsTwo) == 9;
	}

	static int longestConsecutive(int[] nums) {
		final Set<Integer> s = new HashSet<>();
		for (int e : nums)
			s.add(e);

		int l = 0;
		for (int v : nums) {
			if (s.contains(v)) {
				s.remove(v);
				int smallerCnt = 0;
				int nextSmaller = v - 1;
				while (s.contains(nextSmaller)) {
					s.remove(nextSmaller);
					smallerCnt = smallerCnt + 1;
					nextSmaller = nextSmaller - 1;
				}

				int largerCnt = 0;
				int nextLarger = v + 1;
				while (s.contains(nextLarger)) {
					s.remove(nextLarger);
					largerCnt = largerCnt + 1;
					nextLarger = nextLarger + 1;
				}
				l = Math.max(l, smallerCnt + largerCnt + 1);
			}
		}
		return l;
	}
}

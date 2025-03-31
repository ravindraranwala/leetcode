package com.coding.challenge.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PartitionLabels {
	private static final char FIRST_LETTER = 'a';

	PartitionLabels() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert Arrays.asList(9, 7, 8).equals(partitionLabels("ababcbacadefegdehijhklij"));
		assert Arrays.asList(10).equals(partitionLabels("eccbbbbdec"));
	}

	static List<Integer> partitionLabels(String s) {
		final int n = s.length();
		final int[] lastIdx = new int[26];
		for (int i = 0; i < n; i++)
			lastIdx[s.charAt(i) - FIRST_LETTER] = i;

		final List<Integer> ans = new ArrayList<>();
		for (int r = 0, l = 0, maxLastIdx = 0; r < n; r++) {
			maxLastIdx = Math.max(maxLastIdx, lastIdx[s.charAt(r) - FIRST_LETTER]);
			if (r == maxLastIdx) {
				ans.add(r - l + 1);
				l = r + 1;
			}
		}
		return ans;
	}
}

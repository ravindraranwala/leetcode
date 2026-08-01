package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

class MinimumNumberOfPushesToTypeWordII {
	private static final char FIRST_LETTER = 'a';
	private static final int NUM_OF_KEYS = 8;
	private static final int ALPHABET_SIZE = 26;

	MinimumNumberOfPushesToTypeWordII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumPushes("abcde") == 5;
		assert minimumPushes("xyzxyzxyzxyz") == 12;
		assert minimumPushes("aabbccddeeffgghhiiiiii") == 24;
	}

	static int minimumPushes(String word) {
		final int[] letterFreq = new int[ALPHABET_SIZE];
		for (char ch : word.toCharArray())
			letterFreq[ch - FIRST_LETTER] = letterFreq[ch - FIRST_LETTER] + 1;

		Arrays.sort(letterFreq);
		final PriorityQueue<Integer> lettersToKey = new PriorityQueue<>();
		for (int j = 0; j < NUM_OF_KEYS; j++)
			lettersToKey.add(0);

		int pushes = 0;
		for (int i = ALPHABET_SIZE - 1; i >= 0; i--) {
			final int pushesToLetter = lettersToKey.poll() + 1;
			pushes = pushes + pushesToLetter * letterFreq[i];
			lettersToKey.offer(pushesToLetter);
		}
		return pushes;
	}
}

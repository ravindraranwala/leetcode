package com.coding.challenge.binary.search;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class SuccessfulPairsOfSpellsAndPotions {
	SuccessfulPairsOfSpellsAndPotions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] spellsOne = { 5, 1, 3 };
		final int[] potionsOne = { 1, 2, 3, 4, 5 };
		final int[] expectedOne = { 4, 0, 3 };
		assert Arrays.equals(expectedOne, successfulPairs(spellsOne, potionsOne, 7));

		final int[] spellsTwo = { 3, 1, 2 };
		final int[] potionsTwo = { 8, 5, 8 };
		final int[] expectedTwo = { 2, 0, 2 };
		assert Arrays.equals(expectedTwo, successfulPairs(spellsTwo, potionsTwo, 16));
	}

	static int[] successfulPairs(int[] spells, int[] potions, long success) {
		final int n = spells.length;
		final int[] pairs = new int[n];
		Arrays.sort(potions);

		for (int i = 0, m = potions.length; i < n; i++) {
			final int potion = (int) Math.ceil((success / (double) spells[i] - 1));
			final int j = BinarySearch.successor(potions, potion);
			pairs[i] = m - j;
		}
		return pairs;
	}
}

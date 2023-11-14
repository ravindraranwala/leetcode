package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindPlayersWithZeroOrOneLosses {
	FindPlayersWithZeroOrOneLosses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matchesOne = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 },
				{ 10, 4 }, { 10, 9 } };
		final List<List<Integer>> ansOne = Arrays.asList(Arrays.asList(1, 2, 10), Arrays.asList(4, 5, 7, 8));
		assert ansOne.equals(findWinners(matchesOne));

		final int[][] matchesTwo = { { 2, 3 }, { 1, 3 }, { 5, 4 }, { 6, 4 } };
		final List<List<Integer>> ansTwo = Arrays.asList(Arrays.asList(1, 2, 5, 6), Collections.emptyList());
		assert ansTwo.equals(findWinners(matchesTwo));
	}

	static List<List<Integer>> findWinners(int[][] matches) {
		final Map<Integer, Integer> lostCnt = new HashMap<>();
		for (int[] match : matches) {
			if (!lostCnt.containsKey(match[0]))
				lostCnt.put(match[0], 0);
			lostCnt.merge(match[1], 1, Integer::sum);
		}

		final List<Integer> zeroLost = new ArrayList<>();
		final List<Integer> oneLost = new ArrayList<>();
		for (int l : lostCnt.keySet()) {
			// find zero lost players.
			if (lostCnt.get(l) == 0)
				zeroLost.add(l);
			// find one lost players.
			else if (lostCnt.get(l) == 1)
				oneLost.add(l);
		}

		zeroLost.sort((a, b) -> Integer.compare(a, b));
		oneLost.sort((a, b) -> Integer.compare(a, b));
		return Arrays.asList(zeroLost, oneLost);
	}
}

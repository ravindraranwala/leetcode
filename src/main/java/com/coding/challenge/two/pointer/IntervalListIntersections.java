package com.coding.challenge.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class IntervalListIntersections {
	IntervalListIntersections() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		final int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		final int[][] expectedOne = { { 1, 2 }, { 5, 5 }, { 8, 10 }, { 15, 23 }, { 24, 24 }, { 25, 25 } };
		assert Arrays.deepEquals(expectedOne, intervalIntersection(firstList, secondList));

		final int[][] thirdList = { { 1, 3 }, { 5, 9 } };
		final int[][] fourthList = {};
		final int[][] expectedTwo = {};
		assert Arrays.equals(expectedTwo, intervalIntersection(thirdList, fourthList));

	}

	static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		final int n1 = firstList.length;
		final int n2 = secondList.length;
		int[] latestFinish = { -1, -1 };
		final Collection<int[]> overlappingIntervals = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			int[] curr = null;
			if (firstList[i][0] <= secondList[j][0]) {
				curr = firstList[i];
				i = i + 1;
			} else {
				curr = secondList[j];
				j = j + 1;
			}

			if (curr[0] <= latestFinish[1])
				overlappingIntervals
						.add(new int[] { Math.max(curr[0], latestFinish[0]), Math.min(curr[1], latestFinish[1]) });
			if (latestFinish[1] < curr[1])
				latestFinish = curr;
		}

		while (i < n1) {
			if (firstList[i][0] <= latestFinish[1])
				overlappingIntervals.add(new int[] { Math.max(firstList[i][0], latestFinish[0]),
						Math.min(firstList[i][1], latestFinish[1]) });
			if (latestFinish[1] < firstList[i][1])
				latestFinish = firstList[i];
			i = i + 1;
		}

		while (j < n2) {
			if (secondList[j][0] <= latestFinish[1])
				overlappingIntervals.add(new int[] { Math.max(secondList[j][0], latestFinish[0]),
						Math.min(secondList[j][1], latestFinish[1]) });
			if (latestFinish[1] < secondList[j][1])
				latestFinish = secondList[j];
			j = j + 1;
		}
		return overlappingIntervals.toArray(new int[0][0]);
	}
}

package com.coding.challenge.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntervalListIntersections {
	IntervalListIntersections() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		final int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));

		final int[][] thirdList = { { 1, 3 }, { 5, 9 } };
		final int[][] fourthList = {};
		System.out.println(Arrays.deepToString(intervalIntersection(thirdList, fourthList)));

	}

	static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		final int[][] intervals = merge(firstList, secondList);
		final int n = intervals.length;
		final List<int[]> overlappingIntervals = new ArrayList<>();
		int latestFinish = 0;
		for (int i = 1; i < n; i++) {
			if (intervals[i][0] <= intervals[latestFinish][1])
				overlappingIntervals.add(new int[] { Math.max(intervals[i][0], intervals[latestFinish][0]),
						Math.min(intervals[i][1], intervals[latestFinish][1]) });

			if (intervals[i][1] > intervals[latestFinish][1])
				latestFinish = i;
		}

		final int s = overlappingIntervals.size();
		final int[][] answer = new int[s][2];
		for (int j = 0; j < s; j++)
			answer[j] = overlappingIntervals.get(j);
		return answer;
	}

	private static int[][] merge(int[][] firstList, int[][] secondList) {
		final int n1 = firstList.length;
		final int n2 = secondList.length;
		final int n = n1 + n2;
		final int[][] mergedList = new int[n][2];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n1 && j < n2) {
			if (firstList[i][0] < secondList[j][0]) {
				mergedList[k] = firstList[i];
				i = i + 1;
			} else {
				mergedList[k] = secondList[j];
				j = j + 1;
			}
			k = k + 1;
		}

		while (i < n1) {
			mergedList[k] = firstList[i];
			i = i + 1;
			k = k + 1;
		}

		while (j < n2) {
			mergedList[k] = secondList[j];
			j = j + 1;
			k = k + 1;
		}

		return mergedList;
	}
}

package com.coding.challenge.two.pointer;

import java.util.ArrayList;
import java.util.List;

class AggregateTwoTimeSeries {
	AggregateTwoTimeSeries() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] series1 = { { 1, 3 }, { 4, 1 } };
		final int[][] series2 = { { 2, 2 }, { 5, 2 } };
		// [[1, 5], [2, 3], [4, 3], [5, 2]]
		assert List.of(List.of(1, 5), List.of(2, 3), List.of(4, 3), List.of(5, 2))
				.equals(aggregateTimeSeries(series1, series2));

		final int[][] series3 = { { 1, 5 }, { 3, 1 } };
		final int[][] series4 = { { 2, 2 } };
		// [[1, 7], [2, 3], [3, 1]]]
		assert List.of(List.of(1, 7), List.of(2, 3), List.of(3, 1)).equals(aggregateTimeSeries(series3, series4));

		final int[][] series5 = { { 1, 5 } };
		final int[][] series6 = { { 1000000000, 2 } };
		// [[1, 7], [1000000000, 2]]
		assert List.of(List.of(1, 7), List.of(1000000000, 2)).equals(aggregateTimeSeries(series5, series6));
	}

	static List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
		final int m = series1.length;
		final int n = series2.length;
		final List<List<Integer>> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (series1[i][0] == series2[j][0]) {
				ans.add(List.of(series1[i][0], series1[i][1] + series2[j][1]));
				i = i + 1;
				j = j + 1;
			} else if (series1[i][0] < series2[j][0]) {
				ans.add(List.of(series1[i][0], series1[i][1] + series2[j][1]));
				i = i + 1;
			} else {
				ans.add(List.of(series2[j][0], series1[i][1] + series2[j][1]));
				j = j + 1;
			}
		}

		while (i < m) {
			ans.add(List.of(series1[i][0], series1[i][1]));
			i = i + 1;
		}

		while (j < n) {
			ans.add(List.of(series2[j][0], series2[j][1]));
			j = j + 1;
		}

		return ans;
	}
}

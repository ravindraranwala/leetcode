package com.coding.challenge.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeTwo2DArraysBySummingValues {
	MergeTwo2DArraysBySummingValues() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
		final int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		final int[][] ans1 = { { 1, 6 }, { 2, 3 }, { 3, 2 }, { 4, 6 } };
		assert Arrays.deepEquals(ans1, mergeArrays(nums1, nums2));

		final int[][] nums3 = { { 2, 4 }, { 3, 6 }, { 5, 5 } };
		final int[][] nums4 = { { 1, 3 }, { 4, 3 } };
		final int[][] ans2 = { { 1, 3 }, { 2, 4 }, { 3, 6 }, { 4, 3 }, { 5, 5 } };
		assert Arrays.deepEquals(ans2, mergeArrays(nums3, nums4));
	}

	static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		final int n = nums1.length;
		final int m = nums2.length;
		final List<int[]> l = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (nums1[i][0] == nums2[j][0]) {
				l.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
				i = i + 1;
				j = j + 1;
			} else if (nums1[i][0] < nums2[j][0]) {
				l.add(new int[] { nums1[i][0], nums1[i][1] });
				i = i + 1;
			} else {
				l.add(new int[] { nums2[j][0], nums2[j][1] });
				j = j + 1;
			}
		}

		while (i < n) {
			l.add(new int[] { nums1[i][0], nums1[i][1] });
			i = i + 1;
		}

		while (j < m) {
			l.add(new int[] { nums2[j][0], nums2[j][1] });
			j = j + 1;
		}

		return l.toArray(new int[0][]);
	}
}

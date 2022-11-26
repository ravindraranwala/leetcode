package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.Comparator;

class StackingCuboids {
	StackingCuboids() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] cuboidsOne = { { 50, 45, 20 }, { 95, 37, 53 }, { 45, 23, 12 } };
		assert maxHeight(cuboidsOne) == 190;

		final int[][] cuboidsTwo = { { 38, 25, 45 }, { 76, 35, 3 } };
		assert maxHeight(cuboidsTwo) == 76;

		final int[][] cuboidsThree = { { 7, 11, 17 }, { 7, 17, 11 }, { 11, 7, 17 }, { 11, 17, 7 }, { 17, 7, 11 },
				{ 17, 11, 7 } };
		assert maxHeight(cuboidsThree) == 102;

		final int[][] cuboidsFour = { { 1, 7, 20 }, { 2, 6, 20 } };
		assert maxHeight(cuboidsFour) == 20;

		final int[][] cuboidsFive = { { 50, 26, 84 }, { 2, 55, 62 }, { 64, 63, 72 } };
		assert maxHeight(cuboidsFive) == 134;

		final int[][] cuboidsSix = { { 19, 32, 68 }, { 84, 12, 1 }, { 66, 93, 90 }, { 30, 32, 82 }, { 46, 86, 14 },
				{ 53, 80, 18 }, { 96, 99, 51 }, { 52, 25, 2 }, { 68, 29, 25 }, { 76, 5, 36 }, { 56, 2, 58 },
				{ 16, 57, 73 }, { 22, 17, 94 }, { 70, 7, 34 }, { 30, 45, 54 }, { 71, 24, 13 }, { 63, 17, 17 },
				{ 75, 20, 57 }, { 67, 26, 97 }, { 69, 19, 34 }, { 35, 3, 66 }, { 63, 34, 44 }, { 68, 73, 18 },
				{ 77, 93, 90 }, { 19, 10, 27 }, { 82, 10, 90 }, { 92, 55, 93 }, { 100, 21, 37 }, { 60, 8, 75 },
				{ 1, 23, 25 }, { 57, 69, 73 }, { 85, 19, 21 }, { 55, 93, 32 }, { 19, 86, 77 }, { 38, 95, 5 },
				{ 30, 88, 50 }, { 54, 65, 68 }, { 22, 82, 9 }, { 62, 83, 51 }, { 14, 97, 39 }, { 38, 45, 77 },
				{ 7, 99, 74 }, { 9, 32, 84 }, { 4, 83, 52 }, { 93, 59, 36 }, { 62, 56, 88 }, { 58, 99, 84 },
				{ 49, 46, 63 }, { 52, 58, 10 }, { 94, 11, 35 }, { 57, 52, 50 }, { 25, 37, 91 }, { 69, 8, 8 },
				{ 32, 76, 26 }, { 30, 72, 84 }, { 44, 38, 50 }, { 79, 85, 50 }, { 24, 3, 73 }, { 29, 59, 11 },
				{ 62, 61, 17 }, { 90, 46, 26 }, { 4, 38, 27 }, { 46, 86, 6 }, { 82, 91, 9 }, { 72, 64, 92 },
				{ 91, 48, 88 }, { 33, 62, 64 }, { 66, 83, 93 }, { 15, 84, 80 }, { 30, 67, 93 }, { 24, 18, 72 },
				{ 1, 76, 41 }, { 39, 41, 86 }, { 54, 41, 94 }, { 66, 80, 68 }, { 6, 18, 85 }, { 27, 4, 39 },
				{ 30, 50, 47 }, { 89, 65, 14 }, { 94, 38, 48 }, { 4, 66, 79 }, { 11, 13, 85 }, { 95, 26, 88 },
				{ 92, 82, 15 }, { 12, 20, 80 }, { 73, 19, 75 }, { 22, 32, 80 }, { 25, 65, 9 }, { 9, 86, 67 },
				{ 3, 2, 91 }, { 44, 91, 82 } };
		assert maxHeight(cuboidsSix) == 946;
	}

	static int maxHeight(int[][] cuboids) {
		final int n = cuboids.length;
		for (int[] cuboid : cuboids)
			Arrays.sort(cuboid);

		Arrays.sort(cuboids, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				final int c1 = Integer.compare(a[0], b[0]);
				if (c1 != 0)
					return c1;
				final int c2 = Integer.compare(a[1], b[1]);
				if (c2 != 0)
					return c2;
				return Integer.compare(a[2], b[2]);
			}
		});

		final int[] h = new int[n];
		int maxH = 0;

		for (int i = n - 1; i >= 0; i--) {
			h[i] = cuboids[i][2];
			for (int j = i + 1; j < n; j++)
				// find a compatible cuboid
				if (cuboids[j][0] >= cuboids[i][0] && cuboids[j][1] >= cuboids[i][1] && cuboids[j][2] >= cuboids[i][2])
					h[i] = Math.max(h[i], h[j] + cuboids[i][2]);

			maxH = Math.max(maxH, h[i]);
		}
		return maxH;
	}
}

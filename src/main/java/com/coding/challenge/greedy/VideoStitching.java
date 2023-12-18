package com.coding.challenge.greedy;

import java.util.Arrays;

class VideoStitching {
	VideoStitching() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] clips1 = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
		assert videoStitching(clips1, 10) == 3;

		final int[][] clips2 = { { 0, 1 }, { 1, 2 } };
		assert videoStitching(clips2, 5) == -1;

		final int[][] clips3 = { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 },
				{ 4, 7 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } };
		assert videoStitching(clips3, 9) == 3;

		final int[][] clips4 = { { 5, 7 }, { 1, 8 }, { 0, 0 }, { 2, 3 }, { 4, 5 }, { 0, 6 }, { 5, 10 }, { 7, 10 } };
		assert videoStitching(clips4, 5) == 1;

		final int[][] clips5 = { { 11, 28 }, { 35, 40 }, { 28, 38 }, { 0, 10 }, { 37, 39 }, { 40, 40 }, { 18, 34 },
				{ 32, 38 }, { 14, 36 }, { 33, 36 } };
		assert videoStitching(clips5, 8) == 1;
	}

	static int videoStitching(int[][] clips, int time) {
		Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
		final int n = clips.length;
		int c = 0;
		for (int i = 0, maxFinish = 0, f = 0; i < n;) {
			while (i < n && clips[i][0] <= f) {
				maxFinish = Math.max(maxFinish, clips[i][1]);
				i = i + 1;
			}

			f = maxFinish;
			c = c + 1;
			if (f >= time)
				return c;
			if (i == n)
				return -1;
			if (clips[i][0] > f)
				return -1;
		}
		// can't get here.
		throw new AssertionError();
	}
}

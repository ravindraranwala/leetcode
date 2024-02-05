package com.coding.challenge.matrix;

import java.util.Arrays;

class FlippingImage {
	FlippingImage() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] image1 = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		System.out.println(Arrays.deepToString(flipAndInvertImage(image1)));
	}

	static int[][] flipAndInvertImage(int[][] image) {
		final int m = image.length;
		final int n = image[0].length;
		// flip the image and then invert it.
		for (int i = 0; i < m; i++) {
			for (int j = 0, k = n - 1; j <= k; j++, k--) {
				final int tmp = image[i][j];
				image[i][j] = image[i][k] ^ 1;
				image[i][k] = tmp ^ 1;
			}
		}
		return image;
	}
}

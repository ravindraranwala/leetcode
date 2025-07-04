package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LexicographicalNumbers {
	LexicographicalNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> l1 = Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
		assert l1.equals(lexicalOrder(13));

		final List<Integer> l2 = Arrays.asList(1, 2);
		assert l2.equals(lexicalOrder(2));

		final List<Integer> l3 = Arrays.asList(1, 10, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24,
				25, 26, 27, 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 4, 40, 41, 42, 43, 44, 45, 46, 47, 48,
				49, 5, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 6, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 7, 70, 71, 72,
				73, 74, 75, 76, 77, 78, 79, 8, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 9, 90, 91, 92, 93, 94, 95, 96,
				97, 98, 99);
		assert l3.equals(lexicalOrder(100));

		final List<Integer> l4 = Arrays.asList(1, 10, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 11, 110, 111,
				112, 113, 114, 115, 116, 117, 118, 119, 12, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 13, 130,
				131, 132, 133, 134, 135, 136, 137, 138, 139, 14, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 15,
				150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 16, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
				17, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 18, 180, 181, 182, 183, 184, 185, 186, 187, 188,
				189, 19, 190, 191, 192, 2, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37,
				38, 39, 4, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 5, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 6, 60, 61,
				62, 63, 64, 65, 66, 67, 68, 69, 7, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 8, 80, 81, 82, 83, 84, 85,
				86, 87, 88, 89, 9, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99);
		assert l4.equals(lexicalOrder(192));
	}

	static List<Integer> lexicalOrder(int n) {
		final List<Integer> l = new ArrayList<>();
		for (int k = 1; k < 10; k++)
			lexicographicalOrder(l, k, n);
		return l;
	}

	private static void lexicographicalOrder(List<Integer> l, int curr, int n) {
		if (curr > n)
			return;

		l.add(curr);
		final int next = curr * 10;
		for (int v = 0; v < 10; v++)
			lexicographicalOrder(l, next + v, n);
	}
}

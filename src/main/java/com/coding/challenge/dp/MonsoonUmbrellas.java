package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.List;

class MonsoonUmbrellas {
	MonsoonUmbrellas() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> sizes1 = Arrays.asList(3, 5);
		assert getUmbrellas(5, sizes1) == 1;

		assert getUmbrellas(8, sizes1) == 2;

		assert getUmbrellas(7, sizes1) == -1;

		final List<Integer> sizes2 = Arrays.asList(10, 3, 2, 6, 5);
		assert getUmbrellas(18, sizes2) == 3;

		assert getUmbrellas(14, sizes2) == 3;

		assert getUmbrellas(15, sizes2) == 2;

		assert getUmbrellas(16, sizes2) == 2;

		assert getUmbrellas(17, sizes2) == 3;
	}

	static int getUmbrellas(int requirement, List<Integer> sizes) {
		final int n = sizes.size();
		final int[][] u = new int[requirement + 1][n];
		// trivial case of the recursion.
		for (int capacity = 1; capacity <= requirement; capacity++)
			u[capacity][0] = Integer.MAX_VALUE;

		u[sizes.get(0)][0] = 1;

		for (int capacity = 1; capacity <= requirement; capacity++) {
			for (int j = 1; j < n; j++) {
				// without umbrella[j].
				u[capacity][j] = u[capacity][j - 1];
				// choose the j umbrella.
				final int remainingCapacity = capacity - sizes.get(j);
				// with umbrella[j]
				if (remainingCapacity >= 0 && u[remainingCapacity][j - 1] < Integer.MAX_VALUE)
					u[capacity][j] = Math.min(u[capacity][j], u[remainingCapacity][j - 1] + 1);
			}
		}
		return u[requirement][n - 1] == Integer.MAX_VALUE ? -1 : u[requirement][n - 1];
	}
}

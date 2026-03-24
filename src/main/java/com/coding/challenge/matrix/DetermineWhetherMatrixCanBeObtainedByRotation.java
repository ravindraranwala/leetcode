package com.coding.challenge.matrix;

class DetermineWhetherMatrixCanBeObtainedByRotation {
	DetermineWhetherMatrixCanBeObtainedByRotation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] mat1 = { { 0, 1 }, { 1, 0 } };
		final int[][] target1 = { { 1, 0 }, { 0, 1 } };
		assert findRotation(mat1, target1);

		final int[][] mat2 = { { 0, 1 }, { 1, 1 } };
		final int[][] target2 = { { 1, 0 }, { 0, 1 } };
		assert !findRotation(mat2, target2);

		final int[][] mat3 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		final int[][] target3 = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
		assert findRotation(mat3, target3);

		final int[][] mat4 = { { 1, 1 }, { 0, 1 } };
		final int[][] target4 = { { 1, 1 }, { 1, 0 } };
		assert findRotation(mat4, target4);
	}

	static boolean findRotation(int[][] mat, int[][] target) {
		final int n = mat.length;
		boolean found = true;
		// case 1
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				found = found && mat[i][j] == target[i][j];

		if (found)
			return found;

		found = true;
		// case 2
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				found = found && mat[i][j] == target[j][n - i - 1];

		if (found)
			return found;

		// case 3
		found = true;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				found = found && mat[i][j] == target[n - i - 1][n - j - 1];

		if (found)
			return found;

		// case 4
		found = true;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				found = found && mat[i][j] == target[n - j - 1][i];

		return found;
	}
}

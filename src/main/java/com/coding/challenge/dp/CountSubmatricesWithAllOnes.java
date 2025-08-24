package com.coding.challenge.dp;

class CountSubmatricesWithAllOnes {
	CountSubmatricesWithAllOnes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] mat1 = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		assert numSubmat(mat1) == 13;

		final int[][] mat2 = { { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 1, 1, 0 } };
		assert numSubmat(mat2) == 24;
	}

	
	static int numSubmat(int[][] mat) {
		final int m = mat.length;
		final int n = mat[0].length;
		final int[] t = new int[m];
		int c = 0;
		
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (mat[i][j] == 0)
					t[i] = 0;
				else
					t[i] = t[i] + 1;
				
				for (int k = i, minCnt = Integer.MAX_VALUE; k >= 0; k--) {
					minCnt = Math.min(minCnt, t[k]);
					c = c + minCnt;
				}
			}
		}
		return c;
	}
}

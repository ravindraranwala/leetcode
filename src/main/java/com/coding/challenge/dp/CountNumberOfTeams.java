package com.coding.challenge.dp;

class CountNumberOfTeams {
	CountNumberOfTeams() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] ratingOne = { 2, 5, 3, 4, 1 };
		assert 3 == numTeams(ratingOne);

		final int[] ratingTwo = { 2, 1, 3 };
		assert 0 == numTeams(ratingTwo);

		final int[] ratingThree = { 1, 2, 3, 4 };
		assert 4 == numTeams(ratingThree);
	}

	static int numTeams(int[] rating) {
		int teams = 0;
		final int n = rating.length;
		final int[] gtCnt = new int[n];
		final int[] ltCnt = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (rating[i] < rating[j]) {
					gtCnt[i] = gtCnt[i] + 1;
					teams = teams + gtCnt[j];
				} else {
					ltCnt[i] = ltCnt[i] + 1;
					teams = teams + ltCnt[j];
				}
			}
		}
		return teams;
	}
}

package com.coding.challenge.prefix.sum;

class MaximumPointsObtainFromCards {
	MaximumPointsObtainFromCards() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] cardPointsOne = { 1, 2, 3, 4, 5, 6, 1 };
		assert maxScore(cardPointsOne, 3) == 12;

		final int[] cardPointsTwo = { 2, 2, 2 };
		assert maxScore(cardPointsTwo, 2) == 4;

		final int[] cardPointsThree = { 9, 7, 7, 9, 7, 7, 9 };
		assert maxScore(cardPointsThree, 7) == 55;
	}

	static int maxScore(int[] cardPoints, int k) {
		int s = 0;
		for (int i = 0; i < k; i++)
			s = s + cardPoints[i];

		int ans = s;
		for (int n = cardPoints.length, j = n - 1, d = n - k; j >= n - k; j--) {
			s = s - cardPoints[j - d] + cardPoints[j];
			ans = Math.max(ans, s);
		}
		return ans;
	}
}

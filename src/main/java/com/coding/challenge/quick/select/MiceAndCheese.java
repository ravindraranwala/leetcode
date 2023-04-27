package com.coding.challenge.quick.select;

import java.util.Arrays;

class MiceAndCheese {
	MiceAndCheese() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] rewardsOne = { 1, 1, 3, 4 };
		final int[] rewardsTwo = { 4, 4, 1, 1 };
		assert miceAndCheese(rewardsOne, rewardsTwo, 2) == 15;

		final int[] rewardsThree = { 1, 1 };
		final int[] rewardsFour = { 1, 1 };
		assert miceAndCheese(rewardsThree, rewardsFour, 2) == 2;

		final int[] rewardsFive = { 2, 3 };
		final int[] rewardsSix = { 3, 3 };
		assert miceAndCheese(rewardsFive, rewardsSix, 2) == 5;

		final int[] rewardsSeven = { 1, 2, 1, 2, 1, 2 };
		final int[] rewardsEight = { 2, 1, 1, 2, 2, 1 };
		assert miceAndCheese(rewardsSeven, rewardsEight, 0) == 9;
	}

	static int miceAndCheese(int[] reward1, int[] reward2, int k) {
		final int n = reward1.length;
		final int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++)
			arr[i] = new int[] { reward1[i], reward2[i] };

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));

		int points = 0;
		for (int i = 0; i < n - k; i++)
			points = points + arr[i][1];

		for (int i = n - k; i < n; i++)
			points = points + arr[i][0];

		return points;
	}
}

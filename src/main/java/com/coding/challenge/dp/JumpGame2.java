package com.coding.challenge.dp;

class JumpGame2 {
	private JumpGame2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] distOne = { 2, 3, 1, 1, 4 };
		System.out.println(jump(distOne));

		final int[] distTwo = { 2, 3, 0, 1, 4 };
		System.out.println(jump(distTwo));
	}

	static int jump(int[] nums) {
		final int n = nums.length;
		final int[] s = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = Integer.MAX_VALUE;
		s[n - 1] = 0;

		for (int i = n - 2; i >= 0; i--) {
			final int f = Math.min(i + nums[i], n - 1);
			for (int j = i + 1; j <= f; j++)
				s[i] = Math.min(s[i], s[j]);

			if (s[i] < Integer.MAX_VALUE)
				s[i] = s[i] + 1;
		}
		return s[0];
	}
}

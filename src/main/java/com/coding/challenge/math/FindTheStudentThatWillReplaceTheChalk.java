package com.coding.challenge.math;

class FindTheStudentThatWillReplaceTheChalk {
	FindTheStudentThatWillReplaceTheChalk() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] chalk1 = { 5, 1, 5 };
		assert chalkReplacer(chalk1, 22) == 0;

		final int[] clalk2 = { 3, 4, 1, 2 };
		assert chalkReplacer(clalk2, 25) == 1;
	}

	static int chalkReplacer(int[] chalk, int k) {
		long s = 0;
		for (int c : chalk)
			s = s + c;

		final int n = chalk.length;
		final int rem = (int) (k % s);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + chalk[i];
			if (sum > rem)
				return i;
		}
		// can't get here.
		throw new AssertionError();
	}
}

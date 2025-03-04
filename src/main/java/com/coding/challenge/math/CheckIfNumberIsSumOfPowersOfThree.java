package com.coding.challenge.math;

class CheckIfNumberIsSumOfPowersOfThree {
	CheckIfNumberIsSumOfPowersOfThree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkPowersOfThree(12);
		assert checkPowersOfThree(91);
		assert !checkPowersOfThree(21);
		assert checkPowersOfThree(1000);
		assert checkPowersOfThree(6574365);
		assert !checkPowersOfThree(162);
	}

	static boolean checkPowersOfThree(int n) {
		int curr = 1;
		while (curr < n)
			curr = curr * 3;

		int r = n;
		while (r != 0) {
			if (curr * 3 <= r)
				return false;
			if (curr <= r)
				r = r - curr;
			curr = curr / 3;
		}

		return true;
	}
}

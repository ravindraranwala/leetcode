package com.coding.challenge.dp;

class CountVowelsPermutation {
	private static final int REM = 1000000007;

	CountVowelsPermutation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countVowelPermutation(1) == 5;
		assert countVowelPermutation(2) == 10;
		assert countVowelPermutation(5) == 68;
	}

	static int countVowelPermutation(int n) {
		int[] curr = new int[5];
		int[] prev = new int[] { 1, 1, 1, 1, 1 };

		for (int l = 2; l <= n; l++) {
			curr[0] = ((prev[1] + prev[2]) % REM + prev[4]) % REM;
			curr[1] = (prev[0] + prev[2]) % REM;
			curr[2] = (prev[1] + prev[3]) % REM;
			curr[3] = prev[2];
			curr[4] = (prev[2] + prev[3]) % REM;
			prev = curr;
			curr = new int[5];
		}

		return ((((prev[0] + prev[1]) % REM + prev[2]) % REM + prev[3]) % REM + prev[4]) % REM;
	}
}

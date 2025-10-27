package com.coding.challenge.matrix;

class NumberOfLaserBeamsInBank {
	NumberOfLaserBeamsInBank() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] bank1 = { "011001", "000000", "010100", "001000" };
		assert numberOfBeams(bank1) == 8;

		final String[] bank2 = { "000", "111", "000" };
		assert numberOfBeams(bank2) == 0;
	}

	static int numberOfBeams(String[] bank) {
		final int m = bank.length;
		final int n = bank[0].length();
		int beams = 0;
		for (int i = 0, prevCnt = 0; i < m; i++) {
			int currCnt = 0;
			for (int k = 0; k < n; k++) {
				if (bank[i].charAt(k) == '1') {
					beams = beams + prevCnt;
					currCnt = currCnt + 1;
				}
			}
			if (currCnt > 0)
				prevCnt = currCnt;
		}
		return beams;
	}
}

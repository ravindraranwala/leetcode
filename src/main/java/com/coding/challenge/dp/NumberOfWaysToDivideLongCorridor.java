package com.coding.challenge.dp;

class NumberOfWaysToDivideLongCorridor {
	private static final int MOD = 1000000007;

	NumberOfWaysToDivideLongCorridor() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numberOfWays("SSPPSPS") == 3;
		assert numberOfWays("PPSPSP") == 1;
		assert numberOfWays("S") == 0;
	}

	static int numberOfWays(String corridor) {
		final int n = corridor.length();
		int seatCnt = 0;
		int w = 1;
		for (int i = 0, plantCnt = 0; i < n; i++) {
			final char ch = corridor.charAt(i);
			if (ch == 'S') {
				seatCnt = seatCnt + 1;
				if (seatCnt % 2 == 0) {
					w = (int) ((w * (long) (plantCnt + 1)) % MOD);
					plantCnt = 0;
				}
			} else if (ch == 'P' && seatCnt % 2 == 0 && seatCnt > 0)
				plantCnt = plantCnt + 1;
		}
		return seatCnt > 0 && seatCnt % 2 == 0 ? w : 0;
	}
}

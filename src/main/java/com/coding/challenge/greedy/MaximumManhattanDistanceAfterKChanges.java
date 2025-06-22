package com.coding.challenge.greedy;

class MaximumManhattanDistanceAfterKChanges {
	MaximumManhattanDistanceAfterKChanges() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxDistance("NWSE", 1) == 3;
		assert maxDistance("NSWWEW", 3) == 6;
	}

	static int maxDistance(String s, int k) {
		int maxDist = 0;
		final int n = s.length();
		for (int i = 0, nCnt = 0, sCnt = 0, eCnt = 0, wCnt = 0; i < n; i++) {
			final char ch = s.charAt(i);
			if (ch =='N')
				nCnt = nCnt + 1;
			else if (ch == 'S')
				sCnt = sCnt + 1;
			else if (ch == 'E')
				eCnt = eCnt + 1;
			else
				wCnt = wCnt + 1;
			
			final int d = Math.max(nCnt, sCnt) + Math.max(eCnt, wCnt);
			final int p = Math.min(i + 1 - d, k);
			final int q = i + 1 - d - p;
			maxDist = Math.max(maxDist, d + p - q);
		}
		return maxDist;
    }
}

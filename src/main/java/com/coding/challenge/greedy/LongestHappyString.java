package com.coding.challenge.greedy;

class LongestHappyString {
	LongestHappyString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(longestDiverseString(1, 1, 7));
		System.out.println(longestDiverseString(7, 1, 0));
		System.out.println(longestDiverseString(2, 2, 1));
		System.out.println(longestDiverseString(1, 4, 5));
	}

	static String longestDiverseString(int a, int b, int c) {
		final int[] f = { a, b, c };
		final char[] letters = { 'a', 'b', 'c' };

		char lastCh = 'd';
		int lastFreq = 0;
		final StringBuilder sb = new StringBuilder();
		final int freqSum = a + b + c;
		final int maxFreq = Math.max(Math.max(f[0], f[1]), f[2]);
		final int l = Math.min((freqSum - maxFreq + 1) * 2 + freqSum - maxFreq, freqSum);
		while (sb.length() < l) {
			int maxFreqIdx = 1;
			int secondFreqIdx = 0;
			if (f[0] > f[1]) {
				maxFreqIdx = 0;
				secondFreqIdx = 1;
			}
			if (f[maxFreqIdx] > f[2] && f[secondFreqIdx] < f[2])
				secondFreqIdx = 2;
			else if (f[maxFreqIdx] <= f[2]) {
				secondFreqIdx = maxFreqIdx;
				maxFreqIdx = 2;
			}
			if (lastCh != letters[maxFreqIdx]) {
				lastCh = letters[maxFreqIdx];
				sb.append(lastCh);
				f[maxFreqIdx] = f[maxFreqIdx] - 1;
				lastFreq = 1;
			} else if (lastFreq == 1) {
				sb.append(lastCh);
				f[maxFreqIdx] = f[maxFreqIdx] - 1;
				lastFreq = 2;
			} else {
				lastCh = letters[secondFreqIdx];
				sb.append(lastCh);
				f[secondFreqIdx] = f[secondFreqIdx] - 1;
				lastFreq = 1;
			}
		}
		
		return sb.toString();
	}
}

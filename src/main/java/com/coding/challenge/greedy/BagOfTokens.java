package com.coding.challenge.greedy;

import java.util.Arrays;

class BagOfTokens {
	BagOfTokens() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] tokens1 = { 100 };
		assert bagOfTokensScore(tokens1, 50) == 0;

		final int[] tokens2 = { 100, 200 };
		assert bagOfTokensScore(tokens2, 150) == 1;

		final int[] tokens3 = { 100, 200, 300, 400 };
		assert bagOfTokensScore(tokens3, 200) == 2;

		final int[] tokens4 = { 71, 55, 82 };
		assert bagOfTokensScore(tokens4, 54) == 0;

		final int[] tokens5 = { 81, 91, 31 };
		assert bagOfTokensScore(tokens5, 73) == 1;
	}

	static int bagOfTokensScore(int[] tokens, int power) {
		Arrays.sort(tokens);
		final int n = tokens.length;
		int i = 0;
		int j = n - 1;
		int s = 0;
		while (i <= j) {
			while (i < n && power >= tokens[i]) {
				s = s + 1;
				power = power - tokens[i];
				i = i + 1;
			}

			if (s > 0 && j > i) {
				s = s - 1;
				power = power + tokens[j];
				j = j - 1;
			} else
				return s;
		}
		return s;
	}
}

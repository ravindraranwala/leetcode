package com.coding.challenge.dp;

public class RussianDollEnvelopes {

	public static void main(String[] args) {
//		final int[][] envelopsOne = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
//		System.out.println(maxEnvelopes(envelopsOne));
//
//		final int[][] envelopsTwo = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
//		System.out.println(maxEnvelopes(envelopsTwo));

		final int[][] envelopsThree = { { 2, 100 }, { 3, 200 }, { 4, 300 }, { 5, 500 }, { 5, 400 }, { 5, 250 },
				{ 6, 370 }, { 6, 360 }, { 7, 380 } };
		assert maxEnvelopes(envelopsThree) == 5;
	}

	static int maxEnvelopes(int[][] envelopes) {
		throw new UnsupportedOperationException();
	}
}

package com.coding.challenge.dp;

class CherryPickup {
	CherryPickup() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		assert cherryPickup(gridOne) == 5;

		final int[][] gridTwo = { { 1, 1, -1 }, { 1, -1, 1 }, { -1, 1, 1 } };
		assert cherryPickup(gridTwo) == 0;

		final int[][] gridThree = { { 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1 } };
		assert cherryPickup(gridThree) == 15;
	}

	static int cherryPickup(int[][] grid) {
		throw new UnsupportedOperationException();
	}
}

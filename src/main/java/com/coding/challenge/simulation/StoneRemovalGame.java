package com.coding.challenge.simulation;

class StoneRemovalGame {
	StoneRemovalGame() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert canAliceWin(12);
		assert !canAliceWin(1);
	}

	static boolean canAliceWin(int n) {
		boolean aliceWin = false;
		for (int pileSize = n, stones = 10; stones > 0 && pileSize >= stones; stones = stones - 1) {
			pileSize = pileSize - stones;
			aliceWin = stones % 2 == 0;
		}
		return aliceWin;
	}
}

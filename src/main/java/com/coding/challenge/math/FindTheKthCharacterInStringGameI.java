package com.coding.challenge.math;

class FindTheKthCharacterInStringGameI {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	FindTheKthCharacterInStringGameI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert kthCharacter(1) == 'a';
		assert kthCharacter(5) == 'b';
		assert kthCharacter(10) == 'c';
		assert kthCharacter(15) == 'd';
		assert kthCharacter(16) == 'e';
		assert kthCharacter(20) == 'd';
		assert kthCharacter(25) == 'c';
		assert kthCharacter(30) == 'e';
		assert kthCharacter(31) == 'e';
		assert kthCharacter(32) == 'f';
	}

	static char kthCharacter(int k) {
		int changes = 0;

		for (int l = (int) Math.pow(2, Math.ceil(Math.log(k) / Math.log(2)) - 1), child = k; l > 0; l = l / 2) {
			if (child - l / 2 > l) {
				changes = changes + 1;
				child = child - l;
			} else
				child = child - l / 2;
		}
		return ALPHABET.charAt(changes % 26);
	}
}

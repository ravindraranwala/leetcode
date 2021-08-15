package com.coding.challenge.search;

class FindSuccessor {
	FindSuccessor() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[] letters = { 'c', 'f', 'j' };
		char successor = nextGreatestLetter(letters, 'a');
		System.out.println(successor);
		
		successor = nextGreatestLetter(letters, 'c');
		System.out.println(successor);
		
		successor = nextGreatestLetter(letters, 'd');
		System.out.println(successor);
		
		successor = nextGreatestLetter(letters, 'g');
		System.out.println(successor);
		
		successor = nextGreatestLetter(letters, 'j');
		System.out.println(successor);
	}

	static char nextGreatestLetter(char[] letters, char target) {
		int l = 0;
		final int n = letters.length;
		int r = n;
		while (l < r) {
			final int m = (l + r) / 2;
			if (letters[m] > target)
				r = m;
			else
				l = m + 1;
		}
		return letters[l % n];
	}
}

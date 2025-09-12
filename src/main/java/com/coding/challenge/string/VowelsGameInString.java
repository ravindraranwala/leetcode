package com.coding.challenge.string;

class VowelsGameInString {
	VowelsGameInString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(doesAliceWin("leetcoder"));
		System.out.println(doesAliceWin("bbcd"));
	}

	static boolean doesAliceWin(String s) {
		for (char ch : s.toCharArray())
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				return true;

		return false;
	}
}

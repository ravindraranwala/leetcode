package com.coding.challenge.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

class BinaryWatch {
	private static final char DELIMITER = ':';

	BinaryWatch() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(readBinaryWatch(1));
		System.out.println(readBinaryWatch(9));
	}

	static List<String> readBinaryWatch(int turnedOn) {
		final int[] minsToBits = new int[60];
		for (int m = 0; m < 60; m++)
			minsToBits[m] = countSetBits(m);

		final List<String> ans = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			final int minsBitsCnt = turnedOn - countSetBits(h);
			for (int m = 0; m < 60; m++)
				if (countSetBits(m) == minsBitsCnt)
					ans.add("" + h + DELIMITER + ((m < 10) ? "0" + m : m));
		}
		return ans;
	}

	private static int countSetBits(int num) {
		int c = 0;
		while (num > 0) {
			c = c + num % 2;
			num = num / 2;
		}
		return c;
	}
}

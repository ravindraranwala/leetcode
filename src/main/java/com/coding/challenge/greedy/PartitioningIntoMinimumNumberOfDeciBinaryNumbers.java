package com.coding.challenge.greedy;

class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
	private static final int ZERO = '0';

	PartitioningIntoMinimumNumberOfDeciBinaryNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minPartitions("32") == 3;
		assert minPartitions("82734") == 8;
		assert minPartitions("27346209830709182346") == 9;
	}

	static int minPartitions(String n) {
		char p = ZERO;
		for (char ch : n.toCharArray())
			if (ch > p)
				p = ch;

		return p - ZERO;
	}
}

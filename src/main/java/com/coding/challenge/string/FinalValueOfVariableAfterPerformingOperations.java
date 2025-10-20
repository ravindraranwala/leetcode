package com.coding.challenge.string;

class FinalValueOfVariableAfterPerformingOperations {
	private static final char PLUS = '+';

	FinalValueOfVariableAfterPerformingOperations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] operations1 = { "--X", "X++", "X++" };
		assert finalValueAfterOperations(operations1) == 1;

		final String[] operations2 = { "++X", "++X", "X++" };
		assert finalValueAfterOperations(operations2) == 3;

		final String[] operations3 = { "X++", "++X", "--X", "X--" };
		assert finalValueAfterOperations(operations3) == 0;
	}

	static int finalValueAfterOperations(String[] operations) {
		final int n = operations.length;
		int v = 0;
		for (int i = 0; i < n; i++) {
			final String currOp = operations[i];
			if (currOp.charAt(0) == PLUS || currOp.charAt(2) == PLUS)
				v = v + 1;
			else
				v = v - 1;
		}
		return v;
	}
}

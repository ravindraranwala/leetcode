package com.coding.challenge.fenwick.tree;

public final class BIT {
	final int size;
	final int[] table;

	public BIT(int size) {
		this.size = size;
		table = new int[size];
	}

	// updates position i by delta.
	public void update(int i, int delta) {
		while (i < size) {
			table[i] = table[i] + delta;
			// adding lsb using 2's complement.
			i = i + (i & -i);
		}
	}

	// computes the prefix sum value of [1, i]
	public int sum(int i) {
		int sum = 0;
		while (i > 0) {
			sum = sum + table[i];
			// subtracting lsb using 2's complement.
			i = i - (i & -i);
		}
		return sum;
	}

	// computes the sum value [i, j]
	public int rangeSum(int i, int j) {
		return sum(j) - sum(i);
	}
}

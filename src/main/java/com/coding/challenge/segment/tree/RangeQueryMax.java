package com.coding.challenge.segment.tree;

public interface RangeQueryMax {
	void increment(int i, int j, int val);

	int maximum(int i, int j);
}

package com.coding.challenge.segment.tree;

public interface RangeQuery {
	void increment(int i, int j, int val);

	int minimum(int i, int j);
}

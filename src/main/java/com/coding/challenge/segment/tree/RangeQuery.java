package com.coding.challenge.segment.tree;

public interface RangeQuery {
	void increment(int i, int j, int val);

	int sum(int i, int j);
}

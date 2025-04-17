package com.coding.challenge.fenwick.tree;

public class FenwickTreeTest {

	public static void main(String[] args) {
		final int len = 100000;
		final FenwickTree ft = new FenwickTree(len);
		for (int i = 0; i < len; i++)
			ft.add(i, 100000);
		assert ft.rangeQuery(0, len - 1) == 10000000000l;
	}

}

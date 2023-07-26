package com.coding.challenge.fenwick.tree;

public class FenwickTreeTest {

	public static void main(String[] args) {
		final FenwickTree ft = new FenwickTree(new int[] { 1, 3, 5 });
		assert ft.sumRange(0, 2) == 9;
		ft.update(1, 2);
		assert ft.sumRange(0, 2) == 8;
	}

}

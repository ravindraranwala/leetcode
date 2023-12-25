package com.coding.challenge.segment.tree;

class SegmentTreeTest {
	SegmentTreeTest() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final RangeQuery st = new SegmentTree(5);
		st.increment(0, 0, 10);
		st.increment(1, 1, 2);
		st.increment(2, 2, 50);
		st.increment(3, 3, 5);
		st.increment(4, 4, 20);
		assert st.minimum(2, 4) == 5;
	}

}

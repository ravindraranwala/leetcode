package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class NestedIterator implements Iterator<Integer> {
	private final List<Integer> l = new ArrayList<>();
	private final Iterator<Integer> it;

	public NestedIterator(List<NestedInteger> nestedList) {
		visitHierarchy(nestedList);
		it = l.iterator();
	}

	public static void main(String[] args) {

	}

	private void visitHierarchy(List<NestedInteger> nestedList) {
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger())
				l.add(nestedInteger.getInteger());
			else
				visitHierarchy(nestedInteger.getList());
		}
	}

	@Override
	public Integer next() {
		return it.next();
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	interface NestedInteger {
		public boolean isInteger();

		public Integer getInteger();

		public List<NestedInteger> getList();
	}
}

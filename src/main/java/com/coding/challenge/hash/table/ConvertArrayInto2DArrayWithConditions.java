package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ConvertArrayInto2DArrayWithConditions {
	ConvertArrayInto2DArrayWithConditions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 4, 1, 2, 3, 1 };
		System.out.println(findMatrix(numsOne));

		final int[] numsTwo = { 1, 2, 3, 4 };
		System.out.println(findMatrix(numsTwo));
	}

	static List<List<Integer>> findMatrix(int[] nums) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int v : nums)
			f.merge(v, 1, Integer::sum);

		final List<List<Integer>> m = new ArrayList<>();
		while (!f.isEmpty()) {
			final List<Integer> l = new ArrayList<>();
			for (Iterator<Entry<Integer, Integer>> it = f.entrySet().iterator(); it.hasNext();) {
				final Entry<Integer, Integer> e = it.next();
				l.add(e.getKey());
				e.setValue(e.getValue() - 1);
				if (e.getValue() == 0)
					it.remove();
			}
			m.add(l);
		}
		return m;
	}
}

package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
	GroupThePeopleGivenTheGroupSizeTheyBelongTo() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] groupSizes1 = { 3, 3, 3, 3, 3, 1, 3 };
		System.out.println(groupThePeople(groupSizes1));

		final int[] groupSizes2 = { 2, 1, 3, 3, 3, 2 };
		System.out.println(groupThePeople(groupSizes2));
	}

	static List<List<Integer>> groupThePeople(int[] groupSizes) {
		final int n = groupSizes.length;
		final Map<Integer, List<Integer>> t = new HashMap<>();
		final List<List<Integer>> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			final List<Integer> list = t.computeIfAbsent(groupSizes[i], unused -> new ArrayList<>());
			list.add(i);
			if (list.size() == groupSizes[i])
				a.add(t.remove(groupSizes[i]));
		}
		return a;
	}
}

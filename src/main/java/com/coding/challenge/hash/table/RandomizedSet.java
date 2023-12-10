package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {
	private final Map<Integer, Integer> t = new HashMap<>();
	private final List<Integer> l = new ArrayList<>();

	public RandomizedSet() {

	}

	public static void main(String[] args) {
		final RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(1));
		System.out.println(randomizedSet.remove(2));
		System.out.println(randomizedSet.insert(2));
		System.out.println(randomizedSet.getRandom());
		System.out.println(randomizedSet.remove(1));
		System.out.println(randomizedSet.insert(2));
		System.out.println(randomizedSet.getRandom());

		final RandomizedSet randomizedSet1 = new RandomizedSet();
		System.out.println(randomizedSet1.remove(0));
		System.out.println(randomizedSet1.remove(0));
		System.out.println(randomizedSet1.insert(0));
		System.out.println(randomizedSet1.getRandom());
		System.out.println(randomizedSet1.remove(0));
		System.out.println(randomizedSet1.insert(0));

		final RandomizedSet randomizedSet2 = new RandomizedSet();
		System.out.println(randomizedSet2.insert(0));
		System.out.println(randomizedSet2.insert(1));
		System.out.println(randomizedSet2.remove(0));
		System.out.println(randomizedSet2.insert(2));
		System.out.println(randomizedSet2.remove(1));
		System.out.println(randomizedSet2.getRandom());
	}

	public boolean insert(int val) {
		if (t.containsKey(val))
			return false;
		t.put(val, l.size());
		l.add(val);
		return true;
	}

	public boolean remove(int val) {
		if (!t.containsKey(val))
			return false;
		final int k = t.get(val);
		final int lastElt = l.get(l.size() - 1);
		l.set(k, lastElt);
		t.put(lastElt, k);
		l.remove(l.size() - 1);
		t.remove(val);
		return true;
	}

	public int getRandom() {
		return l.get(ThreadLocalRandom.current().nextInt(l.size()));
	}
}

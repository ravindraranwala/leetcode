package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedCollection {
	private final Map<Integer, Set<Integer>> t = new HashMap<>();
	private final List<Integer> l = new ArrayList<>();

	public RandomizedCollection() {

	}

	public static void main(String[] args) {
		final RandomizedCollection randomizedCollection = new RandomizedCollection();
		System.out.println(randomizedCollection.insert(1));
		System.out.println(randomizedCollection.insert(1));
		System.out.println(randomizedCollection.insert(2));
		System.out.println(randomizedCollection.getRandom());
		System.out.println(randomizedCollection.remove(1));
		System.out.println(randomizedCollection.getRandom());

		final RandomizedCollection randomizedCollection1 = new RandomizedCollection();
		System.out.println(randomizedCollection1.insert(1));
		System.out.println(randomizedCollection1.insert(1));
		System.out.println(randomizedCollection1.remove(1));
		System.out.println(randomizedCollection1.getRandom());

		final RandomizedCollection randomizedCollection2 = new RandomizedCollection();
		System.out.println(randomizedCollection2.insert(0));
		System.out.println(randomizedCollection2.remove(0));
		System.out.println(randomizedCollection2.insert(-1));
		System.out.println(randomizedCollection2.remove(0));
		System.out.println(randomizedCollection2.getRandom());
		System.out.println(randomizedCollection2.getRandom());

		final RandomizedCollection randomizedCollection3 = new RandomizedCollection();
		System.out.println(randomizedCollection3.insert(4));
		System.out.println(randomizedCollection3.insert(3));
		System.out.println(randomizedCollection3.insert(4));
		System.out.println(randomizedCollection3.insert(2));
		System.out.println(randomizedCollection3.insert(4));
		System.out.println(randomizedCollection3.remove(4));
		System.out.println(randomizedCollection3.remove(3));
		System.out.println(randomizedCollection3.remove(4));
		System.out.println(randomizedCollection3.remove(4));
	}

	public boolean insert(int val) {
		t.computeIfAbsent(val, unused -> new HashSet<>()).add(l.size());
		l.add(val);
		return t.get(val).size() == 1;
	}

	public boolean remove(int val) {
		if (!t.containsKey(val))
			return false;
		final int k = t.get(val).iterator().next();
		final int n = l.size();
		final int lastElt = l.get(n - 1);
		l.set(k, lastElt);
		t.get(lastElt).remove(n - 1);
		if (val != lastElt) {
			t.get(lastElt).add(k);
			t.get(val).remove(k);
		}

		l.remove(n - 1);
		if (t.get(val).isEmpty())
			t.remove(val);
		return true;
	}

	public int getRandom() {
		return l.get(ThreadLocalRandom.current().nextInt(l.size()));
	}
}

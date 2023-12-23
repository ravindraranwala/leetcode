package com.coding.challenge.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentWords {
	TopKFrequentWords() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "i", "love", "leetcode", "i", "love", "coding" };
		final List<String> l1 = Arrays.asList("i", "love");
		assert l1.equals(topKFrequent(words1, 2));

		final String[] words2 = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		final List<String> l2 = Arrays.asList("the", "is", "sunny", "day");
		assert l2.equals(topKFrequent(words2, 4));
	}

	static List<String> topKFrequent(String[] words, int k) {
		final Map<String, Integer> f = new HashMap<>();
		for (String w : words)
			f.merge(w, 1, Integer::sum);

		final Comparator<Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue().equals(o2.getValue()))
					return o2.getKey().compareTo(o1.getKey());
				return o1.getValue().compareTo(o2.getValue());
			}
		};
		final Queue<Entry<String, Integer>> h = new PriorityQueue<>(cmp);
		for (Entry<String, Integer> entry : f.entrySet()) {
			if (h.size() == k) {
				final Entry<String, Integer> smallest = h.peek();
				if (smallest.getValue() < entry.getValue() || (smallest.getValue().equals(entry.getValue())
						&& entry.getKey().compareTo(smallest.getKey()) < 0)) {
					h.poll();
					h.offer(entry);
				}
			} else
				h.add(entry);
		}

		final List<String> l = new ArrayList<>();
		while (!h.isEmpty())
			l.add(h.poll().getKey());

		Collections.reverse(l);
		return l;
	}
}

package com.coding.challenge.greedy;

import java.util.PriorityQueue;

class MaximumScoreFromRemovingStones {
	MaximumScoreFromRemovingStones() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumScore(2, 4, 6) == 6;
		assert maximumScore(4, 4, 6) == 7;
	}

	static int maximumScore(int a, int b, int c) {
		int score = 0;
		final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
		maxHeap.add(a);
		maxHeap.add(b);
		maxHeap.add(c);
		while (maxHeap.size() > 1) {
			score = score + 1;
			final int first = maxHeap.remove() - 1;
			final int second = maxHeap.remove() - 1;
			if (first > 0)
				maxHeap.add(first);
			if (second > 0)
				maxHeap.add(second);
		}
		return score;
	}
}

package com.coding.challenge.simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class RevealCardsInIncreasingOrder {
	RevealCardsInIncreasingOrder() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] deck1 = { 17, 13, 11, 2, 3, 5, 7 };
		final int[] a1 = { 2, 13, 3, 11, 5, 17, 7 };
		assert Arrays.equals(a1, deckRevealedIncreasing(deck1));

		final int[] deck2 = { 1, 1000 };
		final int[] a2 = { 1, 1000 };
		assert Arrays.equals(a2, deckRevealedIncreasing(deck2));
	}

	static int[] deckRevealedIncreasing(int[] deck) {
		final int n = deck.length;
		final Queue<Integer> q = new ArrayDeque<>();
		// initialize the queue.
		for (int i = 0; i < n; i++)
			q.offer(i);

		int curr = 0;
		final int[] p = new int[n];
		Arrays.sort(deck);
		while (q.size() >= 2) {
			// reveal the top card.
			p[q.poll()] = deck[curr];
			curr = curr + 1;
			// then put the next card at the bottom of the deck.
			q.offer(q.poll());
		}

		// handle last card.
		p[q.poll()] = deck[curr];
		return p;
	}
}

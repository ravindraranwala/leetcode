package com.coding.challenge.heap;

import java.util.PriorityQueue;

class TakeGiftsFromTheRichestPile {
	TakeGiftsFromTheRichestPile() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] gifts1 = { 25, 64, 9, 4, 100 };
		assert pickGifts(gifts1, 4) == 29;

		final int[] gifts2 = { 1, 1, 1, 1 };
		assert pickGifts(gifts2, 4) == 4;
	}

	static long pickGifts(int[] gifts, int k) {
		final PriorityQueue<Integer> h = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int g : gifts)
			h.add(g);

		for (int i = 0; i < k; i++)
			h.add((int) Math.sqrt(h.poll()));

		long r = 0;
		while (!h.isEmpty())
			r = r + h.remove();

		return r;
	}
}

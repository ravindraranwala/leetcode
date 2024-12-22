package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class FinalPricesWithSpecialDiscountInShop {
	FinalPricesWithSpecialDiscountInShop() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] prices1 = { 8, 4, 6, 2, 3 };
		final int[] d1 = { 4, 2, 4, 2, 3 };
		assert Arrays.equals(d1, finalPrices(prices1));

		final int[] prices2 = { 1, 2, 3, 4, 5 };
		final int[] d2 = { 1, 2, 3, 4, 5 };
		assert Arrays.equals(d2, finalPrices(prices2));

		final int[] prices3 = { 10, 1, 1, 6 };
		final int[] d3 = { 9, 0, 1, 6 };
		assert Arrays.equals(d3, finalPrices(prices3));
	}

	static int[] finalPrices(int[] prices) {
		final int n = prices.length;
		final Deque<Integer> s = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && prices[s.peek()] >= prices[i]) {
				final int j = s.pop();
				prices[j] = prices[j] - prices[i];
			}
			s.push(i);
		}
		return prices;
	}
}

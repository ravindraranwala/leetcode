package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

final class StockSpanner {
	private final Deque<Integer> l;
	private final Deque<Integer> s;
	int c = 0;

	public static void main(String[] args) {
		final StockSpanner spannerOne = new StockSpanner();
		assert spannerOne.next(100) == 1;
		assert spannerOne.next(80) == 1;
		assert spannerOne.next(60) == 1;
		assert spannerOne.next(70) == 2;
		assert spannerOne.next(60) == 1;
		assert spannerOne.next(75) == 4;
		assert spannerOne.next(85) == 6;

		final StockSpanner spannerTwo = new StockSpanner();
		assert spannerTwo.next(31) == 1;
		assert spannerTwo.next(41) == 2;
		assert spannerTwo.next(48) == 3;
		assert spannerTwo.next(59) == 4;
		assert spannerTwo.next(79) == 5;
	}

	public StockSpanner() {
		l = new ArrayDeque<>();
		l.push(0);
		s = new ArrayDeque<>();
	}

	public int next(int price) {
		while (!s.isEmpty() && s.peek() <= price) {
			l.pop();
			s.pop();
		}
		c = c + 1;
		final int ans = c - l.peek();
		l.push(c);
		s.push(price);
		return ans;
	}
}

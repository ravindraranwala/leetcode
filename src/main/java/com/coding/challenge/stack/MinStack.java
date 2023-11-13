package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
	private final Deque<Integer> s;
	private final Deque<Integer> currMin;

	public MinStack() {
		s = new ArrayDeque<>();
		currMin = new ArrayDeque<>();
	}

	public static void main(String[] args) {
		final MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		assert minStack.getMin() == -3;
		minStack.pop();
		assert minStack.top() == 0;
		assert minStack.getMin() == -2;
	}

	public void push(int val) {
		s.push(val);
		if (currMin.isEmpty())
			currMin.push(val);
		else
			currMin.push(Math.min(currMin.peek(), val));
	}

	public void pop() {
		s.pop();
		currMin.pop();
	}

	public int top() {
		return s.peek();
	}

	public int getMin() {
		return currMin.peek();
	}
}

package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
	final Deque<Integer> s = new ArrayDeque<>();
	final Deque<Integer> t = new ArrayDeque<>();

	MyQueue() {

	}

	public static void main(String[] args) {
		final MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		assert myQueue.peek() == 1; // return 1
		assert myQueue.pop() == 1; // return 1, queue is [2]
		assert !myQueue.empty(); // return false
	}

	public void push(int x) {
		s.push(x);
	}

	public int pop() {
		if (t.isEmpty())
			copyToTarget();
		return t.pop();
	}

	public int peek() {
		if (t.isEmpty())
			copyToTarget();
		return t.peek();
	}

	public boolean empty() {
		return s.isEmpty() && t.isEmpty();
	}

	private void copyToTarget() {
		while (!s.isEmpty())
			t.push(s.pop());
	}
}

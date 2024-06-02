package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FreqStack {
	private final List<Deque<Integer>> freqList = new ArrayList<>();
	private final Map<Integer, Integer> freq = new HashMap<>();

	FreqStack() {

	}

	public static void main(String[] args) {
		final FreqStack freqStack1 = new FreqStack();
		freqStack1.push(5);
		freqStack1.push(7);
		freqStack1.push(5);
		freqStack1.push(7);
		freqStack1.push(4);
		freqStack1.push(5);
		assert freqStack1.pop() == 5;
		assert freqStack1.pop() == 7;
		assert freqStack1.pop() == 5;
		assert freqStack1.pop() == 4;

		final FreqStack freqStack2 = new FreqStack();
		freqStack2.push(4);
		freqStack2.push(0);
		freqStack2.push(9);
		freqStack2.push(3);
		freqStack2.push(4);
		freqStack2.push(2);
		assert freqStack2.pop() == 4;
		freqStack2.push(6);
		assert freqStack2.pop() == 6;
		freqStack2.push(1);
		assert freqStack2.pop() == 1;
		freqStack2.push(1);
		assert freqStack2.pop() == 1;
		freqStack2.push(4);
		assert freqStack2.pop() == 4;
		assert freqStack2.pop() == 2;
		assert freqStack2.pop() == 3;
		assert freqStack2.pop() == 9;
		assert freqStack2.pop() == 0;
		assert freqStack2.pop() == 4;
	}

	public void push(int val) {
		freq.merge(val, 1, Integer::sum);
		final int f = freq.get(val);
		if (freqList.size() + 1 == f)
			freqList.add(new ArrayDeque<>());
		freqList.get(f - 1).push(val);
	}

	public int pop() {
		final int maxFreq = freqList.size();
		final Deque<Integer> highestFreqStack = freqList.get(maxFreq - 1);
		final int ans = highestFreqStack.pop();
		freq.put(ans, maxFreq - 1);
		if (highestFreqStack.isEmpty())
			freqList.remove(maxFreq - 1);
		return ans;
	}
}

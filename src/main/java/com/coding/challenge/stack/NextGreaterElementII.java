package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class NextGreaterElementII {
	NextGreaterElementII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 1 };
		final int[] expOne = { 2, -1, 2 };
		assert Arrays.equals(expOne, nextGreaterElements(numsOne));

		final int[] numsTwo = { 1, 2, 3, 4, 3 };
		final int[] expTwo = { 2, 3, 4, -1, 4 };
		assert Arrays.equals(expTwo, nextGreaterElements(numsTwo));
	}

	static int[] nextGreaterElements(int[] nums) {
		final int n = nums.length;
		final int[] a = new int[n];
		final Deque<Integer> s = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			a[i] = -1;
			while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
				a[s.peek()] = nums[i];
				s.pop();
			}
			s.push(i);
		}
		// treating the remaining elements in the stack.
		for (int i = 0; i < n; i++) {
			while (nums[s.peek()] < nums[i]) {
				a[s.peek()] = nums[i];
				s.pop();
			}
		}

		return a;
	}
}

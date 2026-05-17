package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

class JumpGameIII {
	JumpGameIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 4, 2, 3, 0, 3, 1, 2 };
		assert canReach(arr1, 5);

		final int[] arr2 = { 4, 2, 3, 0, 3, 1, 2 };
		assert canReach(arr2, 0);

		final int[] arr3 = { 3, 0, 2, 1, 2 };
		assert !canReach(arr3, 2);
	}

	static boolean canReach(int[] arr, int start) {
		final int n = arr.length;
		final Deque<Integer> q = new ArrayDeque<>();
		final boolean[] d = new boolean[n];
		q.offer(start);
		d[start] = true;

		while (!q.isEmpty()) {
			final int k = q.poll();
			if (arr[k] == 0)
				return true;

			final int[] adjList = { k + arr[k], k - arr[k] };
			for (int p : adjList) {
				if (p >= 0 && p < n && !d[p]) {
					d[p] = true;
					q.offer(p);
				}
			}
		}
		return false;
	}
}

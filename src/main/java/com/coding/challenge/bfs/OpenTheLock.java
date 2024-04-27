package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class OpenTheLock {
	OpenTheLock() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] deadends1 = { "0201", "0101", "0102", "1212", "2002" };
		assert openLock(deadends1, "0202") == 6;

		final String[] deadends2 = { "8888" };
		assert openLock(deadends2, "0009") == 1;

		final String[] deadends3 = { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
		assert openLock(deadends3, "8888") == -1;

		final int[] adjList1 = adjacentVertices(202);
		System.out.println(Arrays.toString(adjList1));

		final int[] adjList2 = adjacentVertices(9202);
		System.out.println(Arrays.toString(adjList2));
	}

	static int openLock(String[] deadends, String target) {
		final boolean[] deadendsArr = new boolean[10000];
		for (String deadend : deadends)
			deadendsArr[Integer.parseInt(deadend)] = true;

		final boolean[] d = new boolean[10000];
		final Queue<Vertex> q = new ArrayDeque<>();
		d[Integer.parseInt(target)] = true;
		q.offer(new Vertex(Integer.parseInt(target), 0));

		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			if (u.num == 0)
				return u.d;

			for (int i = 0, prefix = 0, positionalVal = 1000, num = u.num; i < 4; i++) {
				final int currDigit = num / positionalVal;
				num = num % positionalVal;
				final int[] v = { currDigit + 1, currDigit - 1 };
				for (int newDigit : v) {
					if (newDigit == -1)
						newDigit = 9;
					else if (newDigit == 10)
						newDigit = 0;
					final int key = prefix + newDigit * positionalVal + num;
					if (!deadendsArr[key] && !d[key]) {
						d[key] = true;
						q.offer(new Vertex(key, u.d + 1));
					}
				}
				prefix = prefix + positionalVal * currDigit;
				positionalVal = positionalVal / 10;
			}
		}
		return -1;
	}

	private static int[] adjacentVertices(int num) {
		final int[] a = new int[8];
		for (int i = 0, curr = 0, prefix = 0, positionalVal = 1000, val = num; i < 4; i++) {
			final int currDigit = val / positionalVal;
			val = val % positionalVal;
			final int[] v = { currDigit + 1, currDigit - 1 };
			for (int newDigit : v) {
				if (newDigit == -1)
					newDigit = 9;
				else if (newDigit == 10)
					newDigit = 0;
				a[curr] = prefix + newDigit * positionalVal + val;
				curr = curr + 1;
			}
			prefix = prefix + positionalVal * currDigit;
			positionalVal = positionalVal / 10;
		}
		return a;
	}

	static class Vertex {
		final int num;
		final int d;

		Vertex(int num, int d) {
			this.num = num;
			this.d = d;
		}
	}
}

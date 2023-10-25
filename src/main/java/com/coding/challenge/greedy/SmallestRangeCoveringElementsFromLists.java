package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class SmallestRangeCoveringElementsFromLists {
	SmallestRangeCoveringElementsFromLists() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> numsOne = Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20),
				Arrays.asList(5, 18, 22, 30));
		final int[] ansOne = smallestRange(numsOne);
		assert ansOne[0] == 20 && ansOne[1] == 24;

		final List<List<Integer>> numsTwo = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3));
		final int[] ansTwo = smallestRange(numsTwo);
		assert ansTwo[0] == 1 && ansTwo[1] == 1;
	}

	static int[] smallestRange(List<List<Integer>> nums) {
		final int k = nums.size();
		final Queue<int[]> h = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
		int max = -100001;
		// add first element from each list into the heap.
		for (int i = 0; i < k; i++) {
			final int elt = nums.get(i).get(0);
			h.add(new int[] { elt, i, 1 });
			max = Math.max(max, elt);
		}
		int[] smallest = h.peek();
		final int[] ans = { h.peek()[0], max };

		while (smallest[2] < nums.get(smallest[1]).size()) {
			h.poll();
			final int[] elt = { nums.get(smallest[1]).get(smallest[2]), smallest[1], smallest[2] + 1 };
			h.offer(elt);
			max = Math.max(max, elt[0]);
			smallest = h.peek();
			if ((max - smallest[0]) < ans[1] - ans[0]) {
				ans[0] = smallest[0];
				ans[1] = max;
			}
		}
		return ans;
	}
}

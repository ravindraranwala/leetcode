package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RobotCollisions {
	RobotCollisions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] positions1 = { 5, 4, 3, 2, 1 };
		final int[] healths1 = { 2, 17, 9, 15, 10 };
		final String directions1 = "RRRRR";
		assert Arrays.asList(2, 17, 9, 15, 10).equals(survivedRobotsHealths(positions1, healths1, directions1));

		final int[] positions2 = { 3, 5, 2, 6 };
		final int[] healths2 = { 10, 10, 15, 12 };
		final String directions2 = "RLRL";
		assert Arrays.asList(14).equals(survivedRobotsHealths(positions2, healths2, directions2));

		final int[] positions3 = { 1, 2, 5, 6 };
		final int[] healths3 = { 10, 10, 11, 11 };
		final String directions3 = "RLRL";
		assert Collections.emptyList().equals(survivedRobotsHealths(positions3, healths3, directions3));
	}

	static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
		final int n = positions.length;
		final Map<Integer, Integer> positionToIdx = new HashMap<>();
		for (int i = 0; i < n; i++) 
			positionToIdx.put(positions[i], i);
		

		Arrays.sort(positions);
		final boolean[] removed = new boolean[n];
		final Deque<Integer> s = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			final int originalIdx = positionToIdx.get(positions[i]);
			if (directions.charAt(originalIdx) == 'L') {
				while (!s.isEmpty() && healths[s.peek()] < healths[originalIdx]) {
					removed[s.pop()] = true;
					healths[originalIdx] = healths[originalIdx] - 1;
				}
				if (!s.isEmpty()) {
					removed[originalIdx] = true;
					if (healths[s.peek()] == healths[originalIdx])
						removed[s.pop()] = true;
					else
						healths[s.peek()] = healths[s.peek()] - 1;
				}
			} else
				s.push(originalIdx);
		}

		final List<Integer> h = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (!removed[i])
				h.add(healths[i]);
		return h;
	}
}

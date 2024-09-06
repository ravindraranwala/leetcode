package com.coding.challenge.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WalkingRobotSimulation {
	WalkingRobotSimulation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] commands1 = { 4, -1, 3 };
		assert robotSim(commands1, new int[0][0]) == 25;

		final int[] commands2 = { 4, -1, 4, -2, 4 };
		final int[][] obstacles2 = { { 2, 4 } };
		assert robotSim(commands2, obstacles2) == 65;

		final int[] commands3 = { 6, -1, -1, 6 };
		assert robotSim(commands3, new int[0][0]) == 36;

		final int[] commands4 = { -2, -1, -2, 3, 7 };
		final int[][] obstacles4 = { { 1, -3 }, { 2, -3 }, { 4, 0 }, { -2, 5 }, { -5, 2 }, { 0, 0 }, { 4, -4 },
				{ -2, -5 }, { -1, -2 }, { 0, 2 } };
		assert robotSim(commands4, obstacles4) == 100;
	}

	static int robotSim(int[] commands, int[][] obstacles) {
		final Map<Integer, Set<Integer>> t = new HashMap<>();
		for (int[] obst : obstacles)
			t.computeIfAbsent(obst[0], unused -> new HashSet<>()).add(obst[1]);

		final int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x = 0;
		int y = 0;
		int move = 0;
		int eucDist = 0;
		// execute commands one by one.
		for (int cmd : commands) {
			if (cmd == -1)
				move = (move + 1) % 4;
			else if (cmd == -2)
				move = (move + 3) % 4;
			else {
				boolean obstFound = false;
				for (int i = 0; i < cmd && !obstFound; i++) {
					final int newX = x + direction[move][0];
					final int newY = y + direction[move][1];
					obstFound = t.containsKey(newX) && t.get(newX).contains(newY);
					if (!obstFound) {
						x = newX;
						y = newY;
						eucDist = Math.max(eucDist, x * x + y * y);
					}
				}
			}
		}
		return eucDist;
	}
}

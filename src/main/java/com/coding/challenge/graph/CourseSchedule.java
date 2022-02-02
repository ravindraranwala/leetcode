package com.coding.challenge.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.coding.challenge.graph.CourseSchedule.Color.*;

class CourseSchedule {
	CourseSchedule() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] p1 = { { 1, 0 } };
		boolean f = canFinish(2, p1);
		System.out.println(f);

		final int[][] p2 = { { 1, 0 }, { 0, 1 } };
		f = canFinish(2, p2);
		System.out.println(f);
	}

	static boolean canFinish(int numCourses, int[][] prerequisites) {
		final Map<Integer, Collection<Integer>> adjList = new HashMap<>();
		final Map<Integer, Color> cTab = new HashMap<>();
		for (int[] p : prerequisites) {
			adjList.computeIfAbsent(p[0], unused -> new ArrayList<>()).add(p[1]);
			cTab.put(p[0], WHITE);
			cTab.put(p[1], WHITE);
		}
		boolean r = true;
		for (int u : adjList.keySet()) {
			if (cTab.get(u) == WHITE)
				r = r && detectCycles(adjList, cTab, u);
		}
		return r;
	}

	static boolean detectCycles(Map<Integer, Collection<Integer>> adjList, Map<Integer, Color> cTab, int u) {
		cTab.put(u, GRAY);
		boolean r = true;
		for (int v : adjList.getOrDefault(u, Collections.emptyList())) {
			if (cTab.get(v) == WHITE)
				r = r && detectCycles(adjList, cTab, v);
			if (cTab.get(v) == GRAY)
				// back edge detected.
				return false;
		}
		cTab.put(u, BLACK);
		return r;
	}

	static enum Color {
		WHITE, GRAY, BLACK;
	}
}

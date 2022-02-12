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
		final Color[] c = new Color[numCourses];
		for (int[] e : prerequisites) {
			adjList.computeIfAbsent(e[0], unused -> new ArrayList<>()).add(e[1]);
			c[e[0]] = WHITE;
			c[e[1]] = WHITE;
		}
		boolean r = true;
		for (int u : adjList.keySet()) {
			if (c[u] == WHITE)
				r = r && canFinishVisit(adjList, c, u);
		}
		return r;
	}

	static boolean canFinishVisit(Map<Integer, Collection<Integer>> adjList, Color[] c, int u) {
		c[u] = GRAY;
		boolean r = true;
		for (int v : adjList.getOrDefault(u, Collections.emptyList())) {
			if (c[v] == WHITE)
				r = r && canFinishVisit(adjList, c, v);
			if (c[v] == GRAY)
				// back edge detected.
				return false;
		}
		c[u] = BLACK;
		return r;
	}

	static enum Color {
		WHITE, GRAY, BLACK;
	}
}

package com.coding.challenge.graph;

import static com.coding.challenge.graph.CourseSchedule.Color.BLACK;
import static com.coding.challenge.graph.CourseSchedule.Color.GRAY;
import static com.coding.challenge.graph.CourseSchedule.Color.WHITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.graph.CourseSchedule.Color;

class ParallelCourses {
	ParallelCourses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] relations1 = { { 1, 3 }, { 2, 3 } };
		final int[] time1 = { 3, 2, 5 };
		final int n1 = 3;
		int minTime = minimumTime(n1, relations1, time1);
		System.out.println(minTime);

		final int[][] relations2 = { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
		final int[] time2 = { 1, 2, 3, 4, 5 };
		final int n2 = 5;
		minTime = minimumTime(n2, relations2, time2);
		System.out.println(minTime);

		final int[][] relations3 = {};
		final int[] time3 = { 7 };
		minTime = minimumTime(1, relations3, time3);
		System.out.println(minTime);
	}

	static int minimumTime(int n, int[][] relations, int[] time) {
		final Map<Integer, Collection<Integer>> adjList = new HashMap<>();
		for (int[] e : relations)
			adjList.computeIfAbsent(e[0], unused -> new ArrayList<>()).add(e[1]);

		final Color[] c = new Color[n + 1];
		final int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			c[i] = WHITE;
			d[i] = 0;
		}

		int m = 0;
		for (int u = 1; u <= n; u++) {
			if (c[u] == WHITE)
				m = Math.max(m, minimumTimeVisit(adjList, c, u, time, d));
		}
		return m;
	}

	static int minimumTimeVisit(Map<Integer, Collection<Integer>> adjList, Color[] c, int u, int[] time, int[] d) {
		c[u] = GRAY;
		int m = 0;
		for (int v : adjList.getOrDefault(u, Collections.emptyList())) {
			if (c[v] == WHITE)
				m = Math.max(m, minimumTimeVisit(adjList, c, v, time, d));
			if (c[v] == BLACK)
				m = Math.max(m, d[v]);
		}
		c[u] = BLACK;
		d[u] = time[u - 1] + m;
		return d[u];
	}
}

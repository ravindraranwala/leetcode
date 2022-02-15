package com.coding.challenge.graph;

import static com.coding.challenge.graph.CourseSchedule.Color.BLACK;
import static com.coding.challenge.graph.CourseSchedule.Color.GRAY;
import static com.coding.challenge.graph.CourseSchedule.Color.WHITE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.challenge.graph.CourseSchedule.Color;

class CourseOrder {
	CourseOrder() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] p1 = { { 1, 0 } };
		int[] order = findOrder(2, p1);
		System.out.println(Arrays.toString(order));

		final int[][] p2 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		order = findOrder(4, p2);
		System.out.println(Arrays.toString(order));

		final int[][] p3 = {};
		order = findOrder(1, p3);
		System.out.println(Arrays.toString(order));

		final int[][] p4 = { { 1, 0 }, { 0, 1 } };
		order = findOrder(2, p4);
		System.out.println(Arrays.toString(order));
	}

	static int[] findOrder(int numCourses, int[][] prerequisites) {
		final Map<Integer, Collection<Integer>> adjList = new HashMap<>();
		final Color[] c = new Color[numCourses];
		for (int[] e : prerequisites)
			adjList.computeIfAbsent(e[0], unused -> new ArrayList<>()).add(e[1]);

		for (int i = 0; i < numCourses; i++)
			c[i] = WHITE;

		final List<Integer> l = new ArrayList<>();
		for (int u = 0; u < numCourses; u++) {
			if (c[u] == WHITE) {
				final boolean r = findOrderVisit(adjList, c, u, l);
				if (!r)
					return new int[0];
			}
		}
		final int[] s = new int[numCourses];
		for (int i = 0; i < l.size(); i++)
			s[i] = l.get(i);
		return s;
	}

	static boolean findOrderVisit(Map<Integer, Collection<Integer>> adjList, Color[] c, int u, Collection<Integer> l) {
		c[u] = GRAY;
		boolean r = true;
		for (int v : adjList.getOrDefault(u, Collections.emptyList())) {
			if (c[v] == WHITE)
				r = r && findOrderVisit(adjList, c, v, l);
			if (c[v] == GRAY)
				// back edge detected.
				return false;
		}
		c[u] = BLACK;
		// As each vertex is finished, insert it into the tail of the linked list l
		l.add(u);
		return r;
	}
}

package com.coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

	public static void main(String[] args) {
		int[][] edges = new int[][] { { 0, 1 } };
		int[][] edges2 = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[][] edges3 = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] edges4 = new int[][] { { 1, 0 }, { 2, 0 }, { 0, 1 } };
		int[] courseOrder = findOrder(3, edges4);

		System.out.println(Arrays.toString(courseOrder));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		final Deque<Integer> courses = new ArrayDeque<>();
		final COLOR[] discoveryStatus = new COLOR[numCourses];
		for (int i = 0; i < numCourses; i++)
			discoveryStatus[i] = COLOR.WHITE;
		final Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int[] edge : prerequisites)
			adjList.merge(edge[1], new ArrayList<>(Arrays.asList(edge[0])), (l1, l2) -> {
				l1.addAll(l2);
				return l1;
			});

		for (int u = 0; u < numCourses; u++) {
			if (discoveryStatus[u] == COLOR.WHITE) {
				final boolean dependencyFound = findDependencies(u, courses, discoveryStatus, adjList);
				if (!dependencyFound)
					return new int[0];
			}
		}

		final int[] coursesArr = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			coursesArr[i] = courses.poll();

		return coursesArr;
	}

	private static boolean findDependencies(final int u, Deque<Integer> courses, final COLOR[] discoveryStatus,
			final Map<Integer, List<Integer>> adjList) {
		discoveryStatus[u] = COLOR.GRAY;
		boolean dependencyExist = true;
		for (Iterator<Integer> it = adjList.getOrDefault(u, Collections.emptyList()).iterator(); dependencyExist
				&& it.hasNext();) {
			final int v = it.next();
			if (discoveryStatus[v] == COLOR.WHITE)
				dependencyExist = findDependencies(v, courses, discoveryStatus, adjList);
			else if (discoveryStatus[v] == COLOR.GRAY)
				// A cycle is found
				return false;
		}

		discoveryStatus[u] = COLOR.BLACK;
		courses.addFirst(u);

		return dependencyExist;
	}

	static enum COLOR {
		WHITE, GRAY, BLACK;
	}
}

package com.coding.challenge.dijkstras;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.coding.challenge.dijkstras.PriorityQueue.Vertex;

class FindAllPeopleWithSecret {
	FindAllPeopleWithSecret() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] meetings1 = { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } };
		assert Set.of(0, 1, 2, 3, 5).equals(new HashSet<>(findAllPeople(6, meetings1, 1)));

		final int[][] meetings2 = { { 3, 1, 3 }, { 1, 2, 2 }, { 0, 3, 3 } };
		assert Set.of(0, 3, 1).equals(new HashSet<>(findAllPeople(4, meetings2, 3)));

		final int[][] meetings3 = { { 3, 4, 2 }, { 1, 2, 1 }, { 2, 3, 1 } };
		assert Set.of(0, 1, 2, 3, 4).equals(new HashSet<>(findAllPeople(5, meetings3, 1)));
	}

	static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] m : meetings) {
			// undirected graph.
			adjList.get(m[0]).add(new Vertex(m[1], m[2]));
			adjList.get(m[1]).add(new Vertex(m[0], m[2]));
		}

		// init.
		final int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = Integer.MAX_VALUE;

		d[0] = 0;
		d[firstPerson] = 0;
		final PriorityQueue h = new PriorityQueue();
		for (int i = 0; i < n; i++)
			h.insert(new Vertex(i, d[i]));

		final List<Integer> l = new ArrayList<>();
		while (!h.isEmpty()) {
			final Vertex u = h.extractMin();
			if (u.distance != Integer.MAX_VALUE) {
				for (Vertex v : adjList.get(u.id)) {
					// edge relaxation step.
					if (v.distance >= u.distance && d[v.id] > v.distance) {
						d[v.id] = v.distance;
						h.decreaseKey(v.id, d[v.id]);
					}
				}
				l.add(u.id);
			}
		}
		return l;
	}
}

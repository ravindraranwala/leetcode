package com.coding.challenge.prim;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MSTPrim {

	public static void main(String[] args) {
		// Min Cost to Connect All Nodes (Minimum Spanning Tree I)
		int n = 6;
		int[][] edges = new int[][] { { 1, 4 }, { 4, 5 }, { 2, 3 } };
		int[][] newEdges = { { 1, 2, 5 }, { 1, 3, 10 }, { 1, 6, 2 }, { 5, 6, 5 } };
		int cost = minCostToConnectAllNodes(n, edges, newEdges);

		System.out.println(String.format("Min Cost to Connect All Nodes: %d", cost));
	}

	private static int minCostToConnectAllNodes(int n, int[][] edges, int[][] newEdges) {
		final int newEdgesLen = newEdges.length;
		int edgesLen = edges.length;
		int[][] weightedEdges = new int[edgesLen + newEdgesLen][3];
		System.arraycopy(newEdges, 0, weightedEdges, 0, newEdgesLen);
		for (int i = 0; i < edgesLen; i++)
			weightedEdges[i + newEdgesLen] = new int[] { edges[i][0], edges[i][1], 0 };

		return mstPrim(n, weightedEdges);
	}

	private static int mstPrim(int n, int[][] edges) {
		Vertex[] vertices = new Vertex[n + 1];
		boolean[] existenceInQ = new boolean[n + 1];
		Queue<Vertex> q = new PriorityQueue<>(Comparator.comparingInt(v -> v.key));
		Map<Integer, Set<Integer>> adjList = new HashMap<>();
		Map<List<Integer>, Integer> edgeToWeight = new HashMap<>();

		for (int[] edge : edges) {
			adjList.computeIfAbsent(edge[0], unused -> new HashSet<>()).add(edge[1]);
			edgeToWeight.put(Arrays.asList(edge[0], edge[1]), edge[2]);
		}

		for (int i = 1; i <= n; i++) {
			final Vertex vertex = new Vertex(i);
			vertices[i] = vertex;
			q.add(vertex);
			existenceInQ[i] = true;
		}
		// Start from vertex 1.
		vertices[1].key = 0;
		int cost = 0;
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			// Removed from queue
			existenceInQ[u.id] = false;
			for (Integer v : adjList.getOrDefault(u.id, Collections.emptySet())) {
				final int newWeight = edgeToWeight.get(Arrays.asList(u.id, v));
				final int currentWeight = vertices[v].key;
				if (existenceInQ[v] && newWeight < currentWeight) {
					/*
					 * We have found a more optimal path, so, erase the current edge from our MST and
					 * add the newly found edge to it.
					 */
					if (currentWeight != Integer.MAX_VALUE)
						cost -= currentWeight;
					vertices[v].key = newWeight;
					cost += newWeight;
				}

			}
		}
		return cost;
	}

	static final class Vertex {
		final int id;
		int key;

		public Vertex(int id) {
			super();
			this.id = id;
			this.key = Integer.MAX_VALUE;
		}
	}
}

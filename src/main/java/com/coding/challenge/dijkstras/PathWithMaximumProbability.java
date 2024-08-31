package com.coding.challenge.dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

class PathWithMaximumProbability {
	PathWithMaximumProbability() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		final double[] succProb1 = { 0.5, 0.5, 0.2 };
		System.out.println(maxProbability(3, edges1, succProb1, 0, 2));

		final int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		final double[] succProb2 = { 0.5, 0.5, 0.3 };
		System.out.println(maxProbability(3, edges2, succProb2, 0, 2));

		final int[][] edges3 = { { 0, 1 } };
		final double[] succProb3 = { 0.5 };
		System.out.println(maxProbability(3, edges3, succProb3, 0, 2));

		final int[][] edges4 = { { 1, 4 }, { 2, 4 }, { 0, 4 }, { 0, 3 }, { 0, 2 }, { 2, 3 } };
		final double[] succProb4 = { 0.37, 0.17, 0.93, 0.23, 0.39, 0.04 };
		System.out.println(maxProbability(5, edges4, succProb4, 3, 4));
	}

	static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		final int l = edges.length;
		for (int j = 0; j < l; j++) {
			final int u = edges[j][0];
			final int v = edges[j][1];
			final double c = 1 / succProb[j];
			// undirected graph.
			adjList.get(u).add(new Vertex(v, c));
			adjList.get(v).add(new Vertex(u, c));
		}

		final double[] d = dijkstras(start_node, n, adjList);
		return 1 / d[end_node];
	}

	private static double[] dijkstras(int s, int n, List<List<Vertex>> adjList) {
		// init.
		final double[] d = new double[n];
		for (int i = 0; i < n; i++)
			d[i] = Double.MAX_VALUE;
		// identity value of multiplication.
		d[s] = 1;
		final PriorityQueue h = new PriorityQueue();
		for (int i = 0; i < n; i++)
			h.insert(new Vertex(i, d[i]));

		while (!h.isEmpty()) {
			final Vertex u = h.extractMin();
			for (Vertex v : adjList.get(u.id)) {
				// edge relaxation step.
				if (d[u.id] != Double.MAX_VALUE && d[v.id] > d[u.id] * v.distance) {
					d[v.id] = d[u.id] * v.distance;
					h.decreaseKey(v.id, d[v.id]);
				}
			}
		}
		return d;
	}

	static class PriorityQueue {
		private Vertex[] a;
		private int size = 0;
		private final Map<Integer, Integer> vertexToIdx = new HashMap<>();

		PriorityQueue() {
			a = new Vertex[11];
			a[0] = null; // dummy head
		}

		private int parent(int i) {
			return i / 2;
		}

		private int left(int i) {
			return i * 2;
		}

		private int right(int i) {
			return i * 2 + 1;
		}

		private void ensureCapacity(int mincap) {
			final int oldcap = a.length;
			if (mincap > oldcap) {
				int newcap = Math.max(mincap, (oldcap * 3) / 2 + 1);
				Vertex[] oldarr = a;
				a = new Vertex[newcap];
				a[0] = null;
				System.arraycopy(oldarr, 1, a, 1, size);
			}
		}

		void insert(Vertex elt) {
			Objects.requireNonNull(elt);
			ensureCapacity(size + 2);
			a[size + 1] = elt;
			vertexToIdx.put(elt.id, size + 1);
			decreaseKey(size + 1);
			size++;
		}

		void decreaseKey(int id, double distance) {
			final int idx = vertexToIdx.get(id);
			a[idx].distance = distance;
			decreaseKey(idx);
		}

		private void decreaseKey(int i) {
			while (i > 1 && a[parent(i)].distance > a[i].distance) {
				exchange(parent(i), i);
				i = parent(i);
			}
		}

		Vertex extractMin() {
			if (this.size == 0)
				throw new NoSuchElementException();
			final Vertex head = a[1];
			vertexToIdx.remove(head.id);
			a[1] = a[size];
			vertexToIdx.put(a[1].id, 1);
			a[size] = null;
			size--;
			minHeapify(1);
			return head;
		}

		private void minHeapify(int i) {
			final int l = left(i);
			final int r = right(i);
			int smallest = i;
			if (l <= size && a[l].distance < a[i].distance)
				smallest = l;
			if (r <= size && a[r].distance < a[smallest].distance)
				smallest = r;
			if (smallest != i) {
				// exchange the elements and build the heap property.
				exchange(i, smallest);
				minHeapify(smallest);
			}
		}

		boolean isEmpty() {
			return size == 0;
		}

		private void exchange(int i, int j) {
			final Vertex tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			vertexToIdx.put(a[i].id, i);
			vertexToIdx.put(a[j].id, j);
		}
	}
	

	static class Vertex {
		final int id;
		double distance;

		Vertex(int id, double distance) {
			this.id = id;
			this.distance = distance;
		}
	}
}

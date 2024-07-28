package com.coding.challenge.dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

class CityWithSmallestNumOfNeighborsAtThresholdDistance {
	CityWithSmallestNumOfNeighborsAtThresholdDistance() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		System.out.println(findTheCity(4, edges1, 4));

		final int[][] edges2 = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		System.out.println(findTheCity(5, edges2, 2));

		final int[][] edges3 = { { 0, 3, 7 }, { 2, 4, 1 }, { 0, 1, 5 }, { 2, 3, 10 }, { 1, 3, 6 }, { 1, 2, 1 } };
		System.out.println(findTheCity(6, edges3, 417));
	}

	static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		// First create the adjacency list.
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(new Vertex(edge[1], edge[2]));
			adjList.get(edge[1]).add(new Vertex(edge[0], edge[2]));
		}

		int city = -1;
		int neighbours = Integer.MAX_VALUE;

		for (int s = 0; s < n; s++) {
			final int[] d = dijkstras(s, n, adjList);

			int c = 0;
			for (int dist : d)
				if (dist <= distanceThreshold)
					c = c + 1;

			if (c <= neighbours) {
				city = s;
				neighbours = c;
			}

		}

		return city;
	}

	private static int[] dijkstras(int s, int n, List<List<Vertex>> adjList) {
		// init.
		final int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = Integer.MAX_VALUE;
		d[s] = 0;
		final PriorityQueue h = new PriorityQueue();
		for (int i = 0; i < n; i++)
			h.insert(new Vertex(i, d[i]));

		while (!h.isEmpty()) {
			final Vertex u = h.extract();
			for (Vertex v : adjList.get(u.id)) {
				// edge relaxation step.
				if (d[u.id] != Integer.MAX_VALUE && d[v.id] > d[u.id] + v.distance) {
					d[v.id] = d[u.id] + v.distance;
					h.decreaseKey(v.id, d[v.id]);
				}
			}
		}
		return d;
	}

	private static class PriorityQueue {
		private Vertex[] a;
		private int size = 0;
		private final Map<Integer, Integer> vertexToIdx = new HashMap<>();

		private PriorityQueue() {
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

		private void insert(Vertex elt) {
			Objects.requireNonNull(elt);
			ensureCapacity(size + 2);
			a[size + 1] = elt;
			vertexToIdx.put(elt.id, size + 1);
			decreaseKey(size + 1);
			size++;
		}

		private void decreaseKey(int id, int distance) {
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

		private Vertex extract() {
			if (this.size == 0)
				throw new NoSuchElementException();
			final Vertex head = a[1];
			vertexToIdx.remove(head.id);
			a[1] = a[size];
			vertexToIdx.put(a[1].id, 1);
			a[size] = null;
			size--;
			minHeapify(1, size);
			return head;
		}

		private void minHeapify(int i, int heapSize) {
			if (heapSize > size)
				throw new IllegalArgumentException("Heap size cannot be larger than array length.");
			final int l = left(i);
			final int r = right(i);
			int smallest = i;
			if (l <= heapSize && a[l].distance < a[i].distance)
				smallest = l;
			if (r <= heapSize && a[r].distance < a[smallest].distance)
				smallest = r;
			if (smallest != i) {
				// exchange the elements and build the heap property.
				exchange(i, smallest);
				minHeapify(smallest, heapSize);
			}
		}

		private boolean isEmpty() {
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

	private static class Vertex {
		private final int id;
		private int distance;

		Vertex(int id, int distance) {
			this.id = id;
			this.distance = distance;
		}
	}
}

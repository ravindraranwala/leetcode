package com.coding.challenge.dijkstras;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PriorityQueue {
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

	void decreaseKey(int id, int distance) {
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
	
	static class Vertex {
		final int id;
		int distance;

		Vertex(int id, int distance) {
			this.id = id;
			this.distance = distance;
		}
	}
}

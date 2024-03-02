package com.coding.challenge.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class KeysAndRooms {
	KeysAndRooms() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> rooms1 = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3),
				Collections.emptyList());
		assert canVisitAllRooms(rooms1);

		final List<List<Integer>> rooms2 = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2),
				Arrays.asList(0));
		assert !canVisitAllRooms(rooms2);
	}

	static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		final int n = rooms.size();
		final boolean[] d = new boolean[n];
		connectedComponent(rooms, d, 0);
		boolean connected = true;
		for (int i = 0; i < n; i++)
			connected = connected && d[i];
		return connected;
	}

	private static void connectedComponent(List<List<Integer>> rooms, boolean[] d, int u) {
		d[u] = true;
		for (int v : rooms.get(u))
			if (!d[v])
				connectedComponent(rooms, d, v);
	}
}

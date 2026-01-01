package com.coding.challenge.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class LastDayWhereYouCanStillCross {
	private static final int[][] MOVES = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	LastDayWhereYouCanStillCross() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] cells1 = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 2, 2 } };
		assert latestDayToCross(2, 2, cells1) == 2;

		final int[][] cells2 = { { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		assert latestDayToCross(2, 2, cells2) == 1;

		final int[][] cells3 = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 2, 2 }, { 1, 1 }, { 1, 3 }, { 2, 3 }, { 3, 2 },
				{ 3, 1 } };
		assert latestDayToCross(3, 3, cells3) == 3;
	}

	static int latestDayToCross(int row, int col, int[][] cells) {
		// init.
		final int n = cells.length;
		final Map<Coordinate, Integer> w = new HashMap<>();
		final Queue<WaterCell> h = new PriorityQueue<>((wc1, wc2) -> Integer.compare(wc1.day, wc2.day));
		final Set<Coordinate> d = new HashSet<>();
		for (int i = 0; i < n; i++) {
			final int[] wc = cells[i];
			final Coordinate coord = new Coordinate(wc[0], wc[1]);
			w.put(coord, i + 1);
			if (wc[1] == 1) {
				d.add(coord);
				h.add(new WaterCell(wc[0], wc[1], i + 1));
			}
		}

		while (!h.isEmpty()) {
			final WaterCell u = h.remove();
			if (u.col == col)
				return u.day - 1;

			for (int[] move : MOVES) {
				final int r = u.row + move[0];
				final int c = u.col + move[1];
				final Coordinate cn = new Coordinate(r, c);
				if (r > 0 && r <= row && c > 0 && c <= col && !d.contains(cn) && w.containsKey(cn)) {
					d.add(cn);
					final int minDay = Math.max(u.day, w.get(cn));
					h.add(new WaterCell(r, c, minDay));
				}
			}
		}
		return n;
	}

	static class WaterCell {
		final int row;
		final int col;
		final int day;

		WaterCell(int row, int col, int day) {
			super();
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}

	static class Coordinate {
		final int row;
		final int col;

		Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int hashCode() {
			int result = Integer.hashCode(row);
			return result * 31 + Integer.hashCode(col);
		}

		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof Coordinate))
				return false;
			final Coordinate cn = (Coordinate) o;
			return cn.row == row && cn.col == col;
		}
	}
}

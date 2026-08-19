package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CinemaSeatAllocation {
	private static final int GROUP_SIZE = 4;
	private static final int FIRST_GROUP_START = 2;
	private static final int SECOND_GROUP_START = 4;
	private static final int THIRD_GROUP_START = 6;
	private static final int ROW_LENGTH = 10;
	private static final boolean[] EMPTY_ROW = new boolean[0];
	private static final int MAX_AVAIL_GROUPS_PER_ROW = 2;

	CinemaSeatAllocation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] reservedSeats1 = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };
		assert maxNumberOfFamilies(3, reservedSeats1) == 4;

		final int[][] reservedSeats2 = { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		assert maxNumberOfFamilies(2, reservedSeats2) == 2;

		final int[][] reservedSeats3 = { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		assert maxNumberOfFamilies(4, reservedSeats3) == 4;
	}

	static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		final Map<Integer, boolean[]> reservationsByRow = new HashMap<>();
		for (int[] r : reservedSeats)
			reservationsByRow.computeIfAbsent(r[0], unused -> new boolean[ROW_LENGTH + 1])[r[1]] = true;

		int availGroups = 0;
		for (int row : reservationsByRow.keySet())
			if (allFree(reservationsByRow.getOrDefault(row, EMPTY_ROW), FIRST_GROUP_START, GROUP_SIZE + GROUP_SIZE))
				availGroups = availGroups + 2;
			else if (allFree(reservationsByRow.getOrDefault(row, EMPTY_ROW), FIRST_GROUP_START, GROUP_SIZE))
				availGroups = availGroups + 1;
			else if (allFree(reservationsByRow.getOrDefault(row, EMPTY_ROW), SECOND_GROUP_START, GROUP_SIZE))
				availGroups = availGroups + 1;
			else if (allFree(reservationsByRow.getOrDefault(row, EMPTY_ROW), THIRD_GROUP_START, GROUP_SIZE))
				availGroups = availGroups + 1;

		return MAX_AVAIL_GROUPS_PER_ROW * (n - reservationsByRow.size()) + availGroups;
	}

	private static boolean allFree(boolean[] rowOfSeats, int start, int len) {
		final int lastPos = start + len - 1;
		for (int j = start; j <= lastPos; j++)
			if (rowOfSeats[j])
				return false;

		return true;
	}
}

package com.coding.challenge.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QueensThatCanAttackTheKing {
	QueensThatCanAttackTheKing() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] queens1 = { { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 } };
		final int[] king1 = { 0, 0 };
		System.out.println(queensAttacktheKing(queens1, king1));

		final int[][] queens2 = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 4 }, { 3, 5 }, { 4, 4 }, { 4, 5 } };
		final int[] king2 = { 3, 3 };
		System.out.println(queensAttacktheKing(queens2, king2));

		final int[][] queens3 = { { 5, 6 }, { 7, 7 }, { 2, 1 }, { 0, 7 }, { 1, 6 }, { 5, 1 }, { 3, 7 }, { 0, 3 },
				{ 4, 0 }, { 1, 2 }, { 6, 3 }, { 5, 0 }, { 0, 4 }, { 2, 2 }, { 1, 1 }, { 6, 4 }, { 5, 4 }, { 0, 0 },
				{ 2, 6 }, { 4, 5 }, { 5, 2 }, { 1, 4 }, { 7, 5 }, { 2, 3 }, { 0, 5 }, { 4, 2 }, { 1, 0 }, { 2, 7 },
				{ 0, 1 }, { 4, 6 }, { 6, 1 }, { 0, 6 }, { 4, 3 }, { 1, 7 } };
		final int[] king3 = { 3, 4 };
		System.out.println(queensAttacktheKing(queens3, king3));
	}

	static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		final List<List<Integer>> l = new ArrayList<>();
		final boolean[][] board = new boolean[8][8];
		for (int[] q : queens)
			board[q[0]][q[1]] = true;
		// row right positions.
		for (int j = king[1] + 1, n = l.size(); j < 8 && l.size() == n; j++)
			if (board[king[0]][j])
				l.add(Arrays.asList(king[0], j));

		// row left positions.
		for (int j = king[1] - 1, n = l.size(); j >= 0 && n == l.size(); j--)
			if (board[king[0]][j])
				l.add(Arrays.asList(king[0], j));

		// column up positions.
		for (int i = king[0] - 1, n = l.size(); i >= 0 && n == l.size(); i--)
			if (board[i][king[1]])
				l.add(Arrays.asList(i, king[1]));

		// column down positions.
		for (int i = king[0] + 1, n = l.size(); i < 8 && n == l.size(); i++)
			if (board[i][king[1]])
				l.add(Arrays.asList(i, king[1]));

		// diagonal north west position.
		for (int i = king[0], j = king[1], n = l.size(); i >= 0 && j >= 0 && n == l.size(); i--, j--)
			if (board[i][j])
				l.add(Arrays.asList(i, j));

		// diagonal south east position.
		for (int i = king[0], j = king[1], n = l.size(); i < 8 && j < 8 && n == l.size(); i++, j++)
			if (board[i][j])
				l.add(Arrays.asList(i, j));

		// diagonal north east position.
		for (int i = king[0], j = king[1], n = l.size(); i >= 0 && j < 8 && n == l.size(); i--, j++)
			if (board[i][j])
				l.add(Arrays.asList(i, j));

		// diagonal south west position.
		for (int i = king[0], j = king[1], n = l.size(); i < 8 && j >= 0 && n == l.size(); i++, j--)
			if (board[i][j])
				l.add(Arrays.asList(i, j));

		return l;
	}
}

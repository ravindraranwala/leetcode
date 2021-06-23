package com.coding.challenge.dfs;

public class NumOfIslands {
	private static final int[][] MOVES = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };

		char[][] grid2 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

		final int islandCnt = numIslands(grid2);
		System.out.println(String.format("Number of Islands: %d", islandCnt));
	}

	private static int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;

		int islandCnt = 0;
		final int numOfRows = grid.length;
		final int numOfCols = grid[0].length;
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfCols; j++)
				if (grid[i][j] == '1') {
					islandCnt++;
					doscoverIsland(grid, new Vertex(i, j));
				}
		return islandCnt;
	}

	private static void doscoverIsland(char[][] map, Vertex u) {
		map[u.row][u.col] = '0';// vertex discovered.
		final int numOfCols = map[0].length;
		final int numOfRows = map.length;

		for (int[] move : MOVES) {
			final int newRow = u.row + move[0];
			final int newCol = u.col + move[1];
			if ((0 <= newRow && newRow < numOfRows) && (0 <= newCol && newCol < numOfCols)
					&& map[newRow][newCol] == '1')
				doscoverIsland(map, new Vertex(newRow, newCol));
		}
	}
}

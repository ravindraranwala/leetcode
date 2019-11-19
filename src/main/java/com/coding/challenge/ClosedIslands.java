package com.coding.challenge;

public class ClosedIslands {
	private static final int[][] MOVES = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		final int[][] grid = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 },
				{ 1, 0, 1, 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };

		final int[][] grid2 = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
		final int[][] grid3 = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };

		final int[][] grid4 = new int[][] { { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };

		final int numOfClosedIslands = closedIsland(grid4);
		System.out.println(String.format("Number of closed islands: %d", numOfClosedIslands));
	}

	private static int closedIsland(int[][] grid) {
		if (grid.length == 0)
			return 0;
		int islandCnt = 0;
		final int numOfRows = grid.length;
		final int numOfCols = grid[0].length;
		boolean[][] discoveryMatrix = new boolean[numOfRows][numOfCols];
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfCols; j++)
				if (!discoveryMatrix[i][j] && grid[i][j] == 0 && doscoverIsland(grid, discoveryMatrix, new Vertex(i, j)))
					islandCnt++;
		return islandCnt;
	}

	private static boolean doscoverIsland(int[][] map, boolean[][] discoveryMatrix, Vertex u) {
		discoveryMatrix[u.row][u.col] = true;// vertex discovered.
		final int numOfCols = map[0].length;
		final int numOfRows = map.length;

		boolean isIsland = true;

		if (u.row == 0 || u.row == numOfRows - 1 || u.col == 0 || u.col == numOfCols - 1)
			isIsland = false; // Not a closed island.
		for (int[] move : MOVES) {
			final int newRow = u.row + move[0];
			final int newCol = u.col + move[1];
			if ((0 <= newRow && newRow < numOfRows) && (0 <= newCol && newCol < numOfCols)
					&& !discoveryMatrix[newRow][newCol] && map[newRow][newCol] == 0
					&& !doscoverIsland(map, discoveryMatrix, new Vertex(newRow, newCol)))
				isIsland = false;

		}
		return isIsland;
	}
}

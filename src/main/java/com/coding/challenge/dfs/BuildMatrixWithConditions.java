package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class BuildMatrixWithConditions {
	private boolean cycle = false;

	BuildMatrixWithConditions() {

	}

	public static void main(String[] args) {
		final int[][] rowConditions1 = { { 1, 2 }, { 3, 2 } };
		final int[][] colConditions1 = { { 2, 1 }, { 3, 2 } };
		System.out.println(
				Arrays.deepToString(new BuildMatrixWithConditions().buildMatrix(3, rowConditions1, colConditions1)));

		final int[][] rowConditions2 = { { 1, 2 }, { 2, 3 }, { 3, 1 }, { 2, 3 } };
		final int[][] colConditions2 = { { 2, 1 } };
		System.out.println(
				Arrays.deepToString(new BuildMatrixWithConditions().buildMatrix(3, rowConditions2, colConditions2)));
	}

	int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
		final List<List<Integer>> rowAdjList = new ArrayList<>();
		final List<List<Integer>> colAdjList = new ArrayList<>();
		final Color[] color1 = new Color[k + 1];
		final Color[] color2 = new Color[k + 1];
		for (int i = 0; i <= k; i++) {
			rowAdjList.add(new ArrayList<>());
			colAdjList.add(new ArrayList<>());
			color1[i] = Color.WHITE;
			color2[i] = Color.WHITE;
		}

		for (int[] rowDependency : rowConditions)
			rowAdjList.get(rowDependency[0]).add(rowDependency[1]);

		final LinkedList<Integer> rowList = new LinkedList<>();
		for (int i = 1; i <= k; i++)
			if (Color.WHITE == color1[i])
				dfsVisit(rowAdjList, color1, i, rowList);

		for (int[] colDependency : colConditions)
			colAdjList.get(colDependency[0]).add(colDependency[1]);

		final LinkedList<Integer> colList = new LinkedList<>();
		for (int i = 1; i <= k; i++)
			if (color2[i] == Color.WHITE)
				dfsVisit(colAdjList, color2, i, colList);

		if (cycle)
			return new int[0][0];

		final int[][] positions = new int[k + 1][2];
		for (int p = 0; p < k; p++) {
			positions[rowList.remove()][0] = p;
			positions[colList.remove()][1] = p;
		}

		// construct the output matrix.
		final int[][] m = new int[k][k];
		for (int j = 1; j <= k; j++)
			m[positions[j][0]][positions[j][1]] = j;

		return m;

	}

	private void dfsVisit(List<List<Integer>> adjList, Color[] color, int u, LinkedList<Integer> l) {
		color[u] = Color.GRAY;
		for (int v : adjList.get(u)) {
			if (Color.GRAY == color[v])
				cycle = true; // No Topological order exist.
			else if (Color.WHITE == color[v])
				dfsVisit(adjList, color, v, l);
		}
		l.addFirst(u);
		color[u] = Color.BLACK;
	}

	static enum Color {
		WHITE, GRAY, BLACK;
	}
}

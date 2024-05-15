package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class DetonateTheMaximumBombs {
	DetonateTheMaximumBombs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] bombs1 = { { 2, 1, 3 }, { 6, 1, 4 } };
		assert maximumDetonation(bombs1) == 2;

		final int[][] bombs2 = { { 1, 1, 5 }, { 10, 10, 5 } };
		assert maximumDetonation(bombs2) == 1;

		final int[][] bombs3 = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
		assert maximumDetonation(bombs3) == 5;

		final int[][] bombs4 = { { 54, 95, 4 }, { 99, 46, 3 }, { 29, 21, 3 }, { 96, 72, 8 }, { 49, 43, 3 },
				{ 11, 20, 3 }, { 2, 57, 1 }, { 69, 51, 7 }, { 97, 1, 10 }, { 85, 45, 2 }, { 38, 47, 1 }, { 83, 75, 3 },
				{ 65, 59, 3 }, { 33, 4, 1 }, { 32, 10, 2 }, { 20, 97, 8 }, { 35, 37, 3 } };
		assert maximumDetonation(bombs4) == 1;

		final int[][] bombs5 = { { 85024, 58997, 3532 }, { 65196, 42043, 9739 }, { 85872, 75029, 3117 },
				{ 73014, 91183, 7092 }, { 29098, 40864, 7624 }, { 11469, 13607, 4315 }, { 98722, 69681, 9656 },
				{ 75140, 42250, 421 }, { 92580, 44040, 4779 }, { 58474, 78273, 1047 }, { 27683, 4203, 6186 },
				{ 10714, 24238, 6243 }, { 60138, 81791, 3496 }, { 16227, 92418, 5622 }, { 60496, 64917, 2463 },
				{ 59241, 62074, 885 }, { 11961, 163, 5815 }, { 37757, 43214, 3402 }, { 21094, 98519, 1678 },
				{ 49368, 22385, 1431 }, { 6343, 53798, 159 }, { 80129, 9282, 5139 }, { 69565, 32036, 6827 },
				{ 59372, 64978, 6575 }, { 44948, 71199, 7095 }, { 46390, 91701, 1667 }, { 37144, 98691, 8128 },
				{ 13558, 81505, 4653 }, { 41234, 48161, 9304 }, { 14852, 3206, 5369 } };
		assert maximumDetonation(bombs5) == 3;
	}

	static int maximumDetonation(int[][] bombs) {
		final int n = bombs.length;
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				final double dist = straightLineDistance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
				if (dist <= bombs[i][2])
					adjList.get(i).add(j);

				if (dist <= bombs[j][2])
					adjList.get(j).add(i);
			}
		}

		int ans = 0;
		for (int u = 0; u < n; u++)
			ans = Math.max(ans, dfs(u, new boolean[n], adjList));

		return ans;
	}

	private static double straightLineDistance(int x1, int y1, int x2, int y2) {
		final long dx = Math.abs(x1 - x2);
		final long dy = Math.abs(y1 - y2);
		return Math.sqrt(dx * dx + dy * dy);
	}

	private static int dfs(int u, boolean[] d, List<List<Integer>> adjList) {
		d[u] = true;
		int cnt = 1;
		for (int v : adjList.get(u))
			if (!d[v])
				cnt = cnt + dfs(v, d, adjList);

		return cnt;
	}
}

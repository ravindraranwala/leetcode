package com.coding.challenge.dp;

class NetworkDelayTime {
	NetworkDelayTime() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] times1 = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		assert networkDelayTime(times1, 4, 2) == 2;

		final int[][] times2 = { { 1, 2, 1 } };
		assert networkDelayTime(times2, 2, 1) == 1;

		final int[][] times3 = { { 1, 2, 1 } };
		assert networkDelayTime(times3, 2, 2) == -1;

		final int[][] times4 = { { 1, 2, 1 }, { 2, 1, 3 } };
		assert networkDelayTime(times4, 2, 2) == 3;
	}

	static int networkDelayTime(int[][] times, int n, int k) {
		final int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++)
			d[i] = 10000;
		d[k] = 0;

		for (int i = 1; i < n; i++) {
			for (int[] e : times) {
				final int u = e[0];
				final int v = e[1];
				final int w = e[2];
				// edge relaxation step.
				if (d[v] > d[u] + w)
					d[v] = d[u] + w;
			}
		}

		int time = 0;
		for (int i = 1; i <= n; i++)
			time = Math.max(time, d[i]);

		return time == 10000 ? -1 : time;
	}
}

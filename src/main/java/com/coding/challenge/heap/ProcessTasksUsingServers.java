package com.coding.challenge.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class ProcessTasksUsingServers {
	ProcessTasksUsingServers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] servers1 = { 3, 3, 2 };
		final int[] tasks1 = { 1, 2, 3, 2, 1, 2 };
		final int[] ans1 = { 2, 2, 0, 2, 1, 2 };
		assert Arrays.equals(ans1, assignTasks(servers1, tasks1));

		final int[] servers2 = { 5, 1, 4, 3, 2 };
		final int[] tasks2 = { 2, 1, 2, 4, 5, 2, 1 };
		final int[] ans2 = { 1, 4, 1, 4, 1, 3, 2 };
		assert Arrays.equals(ans2, assignTasks(servers2, tasks2));
	}

	static int[] assignTasks(int[] servers, int[] tasks) {
		final int n = servers.length;
		final int m = tasks.length;
		final Queue<Server> availSvrs = new PriorityQueue<>(
				(s1, s2) -> servers[s1.idx] == servers[s2.idx] ? Integer.compare(s1.idx, s2.idx)
						: Integer.compare(servers[s1.idx], servers[s2.idx]));
		for (int svr = 0; svr < n; svr++) {
			availSvrs.add(new Server(svr, 0));
		}

		final Queue<Server> allocSvrs = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.freeAt, s2.freeAt));
		final Queue<Integer> tasksQueue = new ArrayDeque<>();
		final int[] ans = new int[m];
		for (int t = 0; t < m; t++) {
			tasksQueue.add(t);
			while (!allocSvrs.isEmpty() && allocSvrs.peek().freeAt == t) {
				availSvrs.offer(allocSvrs.remove());
			}

			while (!availSvrs.isEmpty() && !tasksQueue.isEmpty()) {
				final int taskIdx = tasksQueue.remove();
				final Server svr = availSvrs.remove();
				allocSvrs.add(new Server(svr.idx, t + tasks[taskIdx]));
				ans[taskIdx] = svr.idx;
			}
		}

		while (!tasksQueue.isEmpty()) {
			if (availSvrs.isEmpty()) {
				final Server nextFreeSvr = allocSvrs.peek();
				while (!allocSvrs.isEmpty() && allocSvrs.peek().freeAt == nextFreeSvr.freeAt) {
					availSvrs.add(allocSvrs.remove());
				}
			}

			final int nextTask = tasksQueue.remove();
			final Server svr = availSvrs.remove();
			allocSvrs.add(new Server(svr.idx, svr.freeAt + tasks[nextTask]));
			ans[nextTask] = svr.idx;
		}

		return ans;
	}

	static class Server {
		private final int idx;
		private final int freeAt;

		Server(int idx, int freeAt) {
			this.idx = idx;
			this.freeAt = freeAt;
		}
	}
}

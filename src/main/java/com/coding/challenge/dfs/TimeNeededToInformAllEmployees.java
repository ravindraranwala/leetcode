package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class TimeNeededToInformAllEmployees {
	TimeNeededToInformAllEmployees() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] manager1 = { -1 };
		final int[] informTime1 = { 0 };
		assert numOfMinutes(1, 0, manager1, informTime1) == 0;

		final int[] manager2 = { 2, 2, -1, 2, 2, 2 };
		final int[] informTime2 = { 0, 0, 1, 0, 0, 0 };
		assert numOfMinutes(6, 2, manager2, informTime2) == 1;
	}

	static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		final List<List<Integer>> subordinates = new ArrayList<>();
		for (int i = 0; i < n; i++)
			subordinates.add(new ArrayList<>());

		for (int i = 0; i < n; i++)
			if (i != headID)
				subordinates.get(manager[i]).add(i);

		return timeToInform(subordinates, headID, 0, informTime);
	}

	private static int timeToInform(List<List<Integer>> subordinateList, int empId, int time, int[] informTime) {
		final List<Integer> subordinates = subordinateList.get(empId);
		int maxTime = time;
		for (int sub : subordinates)
			maxTime = Math.max(maxTime, timeToInform(subordinateList, sub, time + informTime[empId], informTime));

		return maxTime;
	}
}

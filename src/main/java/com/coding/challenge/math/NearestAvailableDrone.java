package com.coding.challenge.math;

class NearestAvailableDrone {
	private static final int UNDEFINED_IDX = -1;

	NearestAvailableDrone() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] drones1 = { { 0, 0, 8 }, { 2, 2, 9 } };
		final int[] target1 = { 3, 4 };
		System.out.println(nearestDrone(drones1, target1));

		final int[][] drones2 = { { 2, 1, 5 }, { 4, 4, 5 }, { 6, 6, 8 } };
		final int[] target2 = { 5, 5 };
		System.out.println(nearestDrone(drones2, target2));

		final int[][] drones3 = { { 4, 4, 5 } };
		final int[] target3 = { 8, 6 };
		System.out.println(nearestDrone(drones3, target3));
	}

	static int nearestDrone(int[][] drones, int[] target) {
		final int n = drones.length;
		int idx = UNDEFINED_IDX;
		for (int i = 0; i < n; i++) {
			int currDistance = manhattanDistanceToTarget(drones[i][0], drones[i][1], target[0], target[1]);
			if (idx == UNDEFINED_IDX) {
				if (currDistance <= drones[i][2])
					idx = i;
			} else if (currDistance <= drones[i][2]
					&& currDistance < manhattanDistanceToTarget(drones[idx][0], drones[idx][1], target[0], target[1]))
				idx = i;
		}
		return idx;
	}

	private static int manhattanDistanceToTarget(int x, int y, int targetX, int targetY) {
		return Math.abs(targetX - x) + Math.abs(targetY - y);
	}
}

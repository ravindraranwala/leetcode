package com.coding.challenge.array;

class FindTheHighestAltitude {
	FindTheHighestAltitude() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] gain1 = { -5, 1, 5, 0, -7 };
		assert largestAltitude(gain1) == 1;

		final int[] gain2 = { -4, -3, -2, -1, 4, 3, 2 };
		assert largestAltitude(gain2) == 0;
	}

	static int largestAltitude(int[] gain) {
		int maxAltitude = 0;
		int currentAltitude = 0;
		for (int delta : gain) {
			currentAltitude = currentAltitude + delta;
			maxAltitude = Math.max(maxAltitude, currentAltitude);
		}
		return maxAltitude;
	}
}

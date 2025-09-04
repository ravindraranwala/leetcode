package com.coding.challenge.math;

class FindClosestPerson {
	FindClosestPerson() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert findClosest(2, 7, 4) == 1;
		assert findClosest(2, 5, 6) == 2;
		assert findClosest(1, 5, 3) == 0;
	}

	static int findClosest(int x, int y, int z) {
        final int d1 = Math.abs(z - x);
        final int d2 = Math.abs(z - y);
        if (d1 == d2)
        	return 0;
        if (d1 < d2)
        	return 1;
        return 2;
    }
}

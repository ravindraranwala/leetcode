package com.coding.challenge.math;

class WaterBottles {
	WaterBottles() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numWaterBottles(9, 3) == 13;
		assert numWaterBottles(15, 4) == 19;
	}

	static int numWaterBottles(int numBottles, int numExchange) {
		int consumed = numBottles;
		int empty = numBottles;
		while (empty >= numExchange) {
			final int fullBottles = empty / numExchange;
			consumed = consumed + fullBottles;
			empty = fullBottles + empty % numExchange;
		}
		return consumed;
	}
}

package com.coding.challenge.simulation;

class WaterBottles {
	WaterBottles() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(numWaterBottles(9, 3));
		System.out.println(numWaterBottles(15, 4));
	}

	static int numWaterBottles(int numBottles, int numExchange) {
        int c = 0;
        int fullBottles = numBottles;
        int emptyBottles = 0;
        
        while (fullBottles != 0) {
        	// consume the full bottles.
        	c = c + fullBottles;
        	// exchange the empty bottles to full bottles.
        	emptyBottles = fullBottles + emptyBottles;
        	fullBottles = emptyBottles / numExchange;
        	emptyBottles = emptyBottles % numExchange;
        }
        return c;
    }
}

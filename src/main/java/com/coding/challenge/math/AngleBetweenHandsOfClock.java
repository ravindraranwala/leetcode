package com.coding.challenge.math;

class AngleBetweenHandsOfClock {
	private static final int HOUR_HAND_DEGREES_MOVE_PER_HOUR = 30;
	private static final double HOUR_HAND_DEGREES_MOVE_PER_MINUTE = 0.5;
	private static final int MINUTE_HAND_DEGREES_MOVE_PER_MINUTE = 6;

	AngleBetweenHandsOfClock() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert Math.abs(165 - angleClock(12, 30)) <= 0.00001;
		assert Math.abs(75 - angleClock(3, 30)) <= 0.00001;
		assert Math.abs(7.5 - angleClock(3, 15)) <= 0.00001;
		assert Math.abs(0 - angleClock(12, 0)) <= 0.00001;
		assert Math.abs(112.5 - angleClock(12, 45)) <= 0.00001;
		assert Math.abs(140.0 - angleClock(12, 40)) <= 0.00001;
		assert Math.abs(115.0 - angleClock(10, 10)) <= 0.00001;
		assert Math.abs(57.5 - angleClock(11, 5)) <= 0.00001;
	}

	static double angleClock(int hour, int minutes) {
		final double hourAngle = HOUR_HAND_DEGREES_MOVE_PER_HOUR * (hour % 12)
				+ HOUR_HAND_DEGREES_MOVE_PER_MINUTE * (minutes % 60);
		final double minuteAngle = MINUTE_HAND_DEGREES_MOVE_PER_MINUTE * (minutes % 60);
		final double angle = Math.abs(hourAngle - minuteAngle);
		return angle <= 180 ? angle : 360 - angle;
	}
}

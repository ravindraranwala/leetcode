package com.coding.challenge.string;

class CountDaysSpentTogether {
	private static final int[] DAYS_PER_MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int MM_LENGTH = 2;
	private static final int DELIMITER_LENGTH = 1;

	CountDaysSpentTogether() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countDaysTogether("08-15", "08-18", "08-16", "08-19") == 3;
		assert countDaysTogether("10-01", "10-31", "11-01", "12-31") == 0;
		assert countDaysTogether("03-20", "08-25", "04-16", "10-15") == 132;
	}

	static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		if (arriveBob.compareTo(leaveAlice) > 0)
			return 0;
		else if (arriveAlice.compareTo(leaveBob) > 0)
			return 0;

		final String lateStart = arriveBob.compareTo(arriveAlice) > 0 ? arriveBob : arriveAlice;
		final String earlyFinish = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
		final int lateStartMonth = Integer.parseInt(lateStart.substring(0, MM_LENGTH));
		final int lateStartDay = Integer.parseInt(lateStart.substring(MM_LENGTH + DELIMITER_LENGTH));
		final int earlyFinishMonth = Integer.parseInt(earlyFinish.substring(0, MM_LENGTH));
		final int earlyFinishDay = Integer.parseInt(earlyFinish.substring(MM_LENGTH + DELIMITER_LENGTH));
		if (lateStartMonth == earlyFinishMonth)
			return earlyFinishDay - lateStartDay + 1;

		int d = DAYS_PER_MONTH[lateStartMonth] - lateStartDay + 1;
		int m = lateStartMonth + 1;
		while (m < earlyFinishMonth) {
			d = d + DAYS_PER_MONTH[m];
			m = m + 1;
		}
		return d + earlyFinishDay;
	}
}

package com.coding.challenge.simulation;

class CrawlerLogFolder {
	CrawlerLogFolder() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] logs1 = { "d1/", "d2/", "../", "d21/", "./" };
		assert minOperations(logs1) == 2;

		final String[] logs2 = { "d1/", "d2/", "./", "d3/", "../", "d31/" };
		assert minOperations(logs2) == 3;

		final String[] logs3 = { "d1/", "../", "../", "../" };
		assert minOperations(logs3) == 0;
	}

	static int minOperations(String[] logs) {
		int d = 0;
		for (String op : logs) {
			if ("../".equals(op))
				d = Math.max(0, d - 1);
			else if (!"./".equals(op))
				d = d + 1;
		}
		return d;
	}
}

package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ValidBinaryStringsWithCostLimit {
	private static final char ZERO = '0';
	private static final char ONE = '1';

	ValidBinaryStringsWithCostLimit() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert Set.of("000", "100", "010").equals(new HashSet<>(generateValidStrings(3, 1)));
		assert Set.of("0", "1").equals(new HashSet<>(generateValidStrings(1, 0)));
	}

	static List<String> generateValidStrings(int n, int k) {
		final Map<String, Integer> validBinStrings = generateBinStrings(k, n - 1);
		return new ArrayList<>(validBinStrings.keySet());
	}

	private static Map<String, Integer> generateBinStrings(int k, int idx) {
		// trivial case of the recursion.
		if (idx == 0) {
			final Map<String, Integer> t = new HashMap<>();
			t.put(ZERO + "", 0);
			t.put(ONE + "", 0);
			return t;
		}

		final Map<String, Integer> binStrToCost = new HashMap<>();
		// compute the current cost.
		for (Entry<String, Integer> entry : generateBinStrings(k, idx - 1).entrySet()) {
			final String binStr = entry.getKey();
			final int cost = entry.getValue();
			if (binStr.charAt(idx - 1) == ZERO) {
				binStrToCost.put(binStr + ZERO, cost);
				if (cost + idx <= k)
					binStrToCost.put(binStr + ONE, cost + idx);
			} else
				binStrToCost.put(binStr + ZERO, cost);
		}
		return binStrToCost;
	}
}

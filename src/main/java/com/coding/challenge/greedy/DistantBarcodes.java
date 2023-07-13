package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class DistantBarcodes {
	DistantBarcodes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] barcodesOne = { 1, 1, 1, 2, 2, 2 };
		final int[] expectedOne = { 1, 2, 1, 2, 1, 2 };
		assert Arrays.equals(expectedOne, rearrangeBarcodes(barcodesOne));

		final int[] barcodesTwo = { 1, 1, 1, 1, 2, 2, 3, 3 };
		final int[] expectedTwo = { 1, 3, 1, 2, 1, 2, 3, 1 };
		assert Arrays.equals(expectedTwo, rearrangeBarcodes(barcodesTwo));

		final int[] barcodesThree = { 4 };
		final int[] expectedThree = { 4 };
		assert Arrays.equals(expectedThree, rearrangeBarcodes(barcodesThree));

		final int[] barcodesFour = { 4, 7 };
		final int[] expectedFour = { 4, 7 };
		assert Arrays.equals(expectedFour, rearrangeBarcodes(barcodesFour));

		final int[] barcodesFive = { 2, 2, 1, 3 };
		final int[] expectedFive = { 2, 3, 1, 2 };
		assert Arrays.equals(expectedFive, rearrangeBarcodes(barcodesFive));

		final int[] barcodesSix = { 1, 2, 3, 4, 4, 4, 4 };
		final int[] expectedSix = { 4, 2, 4, 3, 4, 1, 4 };
		assert Arrays.equals(expectedSix, rearrangeBarcodes(barcodesSix));

		final int[] barcodesSeven = { 1, 2, 2 };
		final int[] expectedSeven = { 2, 1, 2 };
		assert Arrays.equals(expectedSeven, rearrangeBarcodes(barcodesSeven));

		final int[] barcodesEight = { 1, 1, 2 };
		final int[] expectedEight = { 1, 2, 1 };
		assert Arrays.equals(expectedEight, rearrangeBarcodes(barcodesEight));

		final int[] barcodesNine = { 7, 7, 7, 8, 5, 7, 5, 5, 5, 8 };
		final int[] expectedNine = { 5, 7, 5, 7, 8, 7, 5, 7, 8, 5 };
		assert Arrays.equals(expectedNine, rearrangeBarcodes(barcodesNine));
	}

	static int[] rearrangeBarcodes(int[] barcodes) {
		/*
		 * heap based solution: always pick the two highest frequencies and then include
		 * them in the output. After including, reduce the frequency by one, and insert
		 * it back again to the heap. If the frequency is 0, then no need to add back
		 * into the heap again. Do until heap becomes empty.
		 */
		final Map<Integer, Integer> f = new HashMap<>();
		for (int bc : barcodes)
			f.merge(bc, 1, Integer::sum);

		final Queue<Entry<Integer, Integer>> p = new PriorityQueue<>(
				(a, b) -> Integer.compare(b.getValue(), a.getValue()));
		for (Entry<Integer, Integer> e : f.entrySet())
			p.add(e);

		final int[] d = new int[barcodes.length];
		int i = 0;
		while (p.size() > 1) {
			final Entry<Integer, Integer> h = p.poll();
			d[i] = h.getKey();
			i = i + 1;
			final Entry<Integer, Integer> l = p.poll();
			d[i] = l.getKey();
			i = i + 1;
			if (h.getValue() > 1) {
				h.setValue(h.getValue() - 1);
				p.add(h);
			}
			if (l.getValue() > 1) {
				l.setValue(l.getValue() - 1);
				p.add(l);
			}
		}
		if (p.size() == 1)
			d[i] = p.poll().getKey();
		return d;
	}
}

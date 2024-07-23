package com.coding.challenge.radix.sort;

import java.util.Arrays;

class SortThePeople {
	SortThePeople() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] names1 = { "Mary", "John", "Emma" };
		final int[] heights1 = { 180, 165, 170 };
		final String[] sortedPeople1 = { "Mary", "Emma", "John" };
		assert Arrays.equals(sortedPeople1, sortPeople(names1, heights1));

		final String[] names2 = { "Alice", "Bob", "Bob" };
		final int[] heights2 = { 155, 185, 150 };
		final String[] sortedPeople2 = { "Bob", "Alice", "Bob" };
		assert Arrays.equals(sortedPeople2, sortPeople(names2, heights2));
	}

	static String[] sortPeople(String[] names, int[] heights) {
		final int n = names.length;
		final Person[] people = new Person[n];
		for (int i = 0; i < n; i++)
			people[i] = new Person(heights[i], names[i]);

		final Person[] sortedPeople = radixSort(people, 6);
		final String[] sortedNames = new String[n];
		for (int i = 0; i < n; i++)
			sortedNames[n - 1 - i] = sortedPeople[i].name;
		return sortedNames;
	}

	private static Person[] radixSort(Person[] a, int d) {
		Person[] b = a;
		for (int i = 0; i < d; i++)
			b = countingSort(b, 9, i);
		return b;
	}

	private static Person[] countingSort(Person[] a, int k, int d) {
		final int n = a.length;
		final Person[] b = new Person[n];
		final int[] c = new int[k + 1];

		final int denominator = (int) Math.pow(10, d);
		for (int j = 0; j < n; j++) {
			final int digit = (a[j].height / denominator) % (k + 1);
			c[digit] = c[digit] + 1;
		}

		for (int i = 1; i <= k; i++)
			c[i] = c[i] + c[i - 1];

		for (int j = n - 1; j >= 0; j--) {
			final int digit = (a[j].height / denominator) % (k + 1);
			b[c[digit] - 1] = a[j];
			c[digit] = c[digit] - 1;
		}
		return b;
	}

	private static class Person {
		final int height;
		final String name;

		public Person(int height, String name) {
			this.height = height;
			this.name = name;
		}

	}
}

package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class DisplayTableOfRestaurantFoodOrders {
	DisplayTableOfRestaurantFoodOrders() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<String>> ordersOne = Arrays.asList(Arrays.asList("David", "3", "Ceviche"),
				Arrays.asList("Corina", "10", "Beef Burrito"), Arrays.asList("David", "3", "Fried Chicken"),
				Arrays.asList("Carla", "5", "Water"), Arrays.asList("Carla", "5", "Ceviche"),
				Arrays.asList("Rous", "3", "Ceviche"));
		assert "[[Table, Beef Burrito, Ceviche, Fried Chicken, Water], [3, 0, 2, 1, 0], [5, 0, 1, 0, 1], [10, 1, 0, 0, 0]]"
				.equals(displayTable(ordersOne).toString());

		final List<List<String>> ordersTwo = Arrays.asList(Arrays.asList("James", "12", "Fried Chicken"),
				Arrays.asList("Ratesh", "12", "Fried Chicken"), Arrays.asList("Amadeus", "12", "Fried Chicken"),
				Arrays.asList("Adam", "1", "Canadian Waffles"), Arrays.asList("Brianna", "1", "Canadian Waffles"));
		assert "[[Table, Canadian Waffles, Fried Chicken], [1, 2, 0], [12, 0, 3]]"
				.equals(displayTable(ordersTwo).toString());

		final List<List<String>> ordersThree = Arrays.asList(Arrays.asList("Laura", "2", "Bean Burrito"),
				Arrays.asList("Jhon", "2", "Beef Burrito"), Arrays.asList("Melissa", "2", "Soda"));
		assert "[[Table, Bean Burrito, Beef Burrito, Soda], [2, 1, 1, 1]]".equals(displayTable(ordersThree).toString());
	}

	static List<List<String>> displayTable(List<List<String>> orders) {
		final Set<String> foodItems = new TreeSet<>();
		final Map<Integer, Map<String, Integer>> foodByTable = new TreeMap<>();
		for (List<String> order : orders) {
			foodItems.add(order.get(2));
			foodByTable.computeIfAbsent(Integer.parseInt(order.get(1)), unused -> new HashMap<>()).merge(order.get(2),
					1, Integer::sum);
		}

		// generating header.
		final List<String> header = new ArrayList<>();
		header.add("Table");
		header.addAll(foodItems);
		final List<List<String>> displayTable = new ArrayList<>();
		displayTable.add(header);
		// adding table rows.
		for (int table : foodByTable.keySet()) {
			final List<String> tableRow = new ArrayList<>();
			tableRow.add(table + "");
			final Map<String, Integer> ordersByTable = foodByTable.get(table);
			for (String food : foodItems)
				tableRow.add(ordersByTable.getOrDefault(food, 0) + "");
			displayTable.add(tableRow);
		}
		return displayTable;
	}
}

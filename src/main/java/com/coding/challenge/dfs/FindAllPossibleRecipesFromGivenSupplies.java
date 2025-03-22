package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FindAllPossibleRecipesFromGivenSupplies {
	FindAllPossibleRecipesFromGivenSupplies() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] recipes1 = { "bread" };
		final List<List<String>> ingredients1 = Arrays.asList(Arrays.asList("yeast", "flour"));
		final String[] supplies1 = { "yeast", "flour", "corn" };
		System.out.println(findAllRecipes(recipes1, ingredients1, supplies1));

		final String[] recipes2 = { "bread", "sandwich" };
		final List<List<String>> ingredients2 = Arrays.asList(Arrays.asList("yeast", "flour"),
				Arrays.asList("bread", "meat"));
		final String[] supplies2 = { "yeast", "flour", "meat" };
		System.out.println(findAllRecipes(recipes2, ingredients2, supplies2));

		final String[] recipes3 = { "bread", "sandwich", "burger" };
		final List<List<String>> ingredients3 = Arrays.asList(Arrays.asList("yeast", "flour"),
				Arrays.asList("bread", "meat"), Arrays.asList("sandwich", "meat", "bread"));
		final String[] supplies3 = { "yeast", "flour", "meat" };
		System.out.println(findAllRecipes(recipes3, ingredients3, supplies3));
	}

	static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		final int n = recipes.length;
		final Map<String, Integer> recipeIdx = new HashMap<>();
		final Color[] d = new Color[n];
		for (int i = 0; i < n; i++) {
			recipeIdx.put(recipes[i], i);
			d[i] = Color.WHITE;
		}

		final Set<String> sup = new HashSet<>();
		for (String s : supplies)
			sup.add(s);

		final boolean[] ans = new boolean[n];
		final List<String> l = new ArrayList<>();
		for (int u = 0; u < n; u++)
			if (d[u] == Color.WHITE)
				dfsVisit(recipes, ingredients, u, sup, recipeIdx, d, ans, l);

		return l;
	}

	private static boolean dfsVisit(String[] recipes, List<List<String>> ingredients, int u, Set<String> supplies,
			Map<String, Integer> recipeIdx, Color[] d, boolean[] ans, List<String> l) {
		d[u] = Color.GRAY;
		ans[u] = true;
		for (String ingredient : ingredients.get(u)) {
			if (recipeIdx.containsKey(ingredient)) {
				final int v = recipeIdx.get(ingredient);
				if (d[v] == Color.WHITE)
					ans[u] = ans[u] && dfsVisit(recipes, ingredients, v, supplies, recipeIdx, d, ans, l);
				else if (d[v] == Color.GRAY)
					ans[u] = false;
				else
					ans[u] = ans[u] && ans[v];
			} else
				ans[u] = ans[u] && supplies.contains(ingredient);
		}
		if (ans[u])
			l.add(recipes[u]);
		d[u] = Color.BLACK;
		return ans[u];
	}

	private static enum Color {
		WHITE, GRAY, BLACK
	}
}

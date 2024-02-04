package com.coding.challenge.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeeImportance {
	EmployeeImportance() {
		throw new AssertionError();
	}

	public static void main(String[] args) {

	}

	static int getImportance(List<Employee> employees, int id) {
		final Map<Integer, Employee> empById = new HashMap<>();
		for (Employee emp : employees)
			empById.put(emp.id, emp);
		return visitHierarchy(empById.get(id), empById);
	}

	private static int visitHierarchy(Employee emp, Map<Integer, Employee> empById) {
		int importance = emp.importance;
		for (int subId : emp.subordinates)
			importance = importance + visitHierarchy(empById.get(subId), empById);
		return importance;
	}

	class Employee {
		private int id;
		private int importance;
		private List<Integer> subordinates;
	};
}

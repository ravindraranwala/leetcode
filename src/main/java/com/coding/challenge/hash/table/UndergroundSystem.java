package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
	final Map<Integer, CheckinData> inTransit = new HashMap<>();
	final Map<String, Map<String, Integer>> totalTime = new HashMap<>();
	final Map<String, Map<String, Integer>> freq = new HashMap<>();

	UndergroundSystem() {

	}

	public static void main(String[] args) {
		final UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(27, "Waterloo", 20);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		undergroundSystem.checkIn(10, "Leyton", 24);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		undergroundSystem.checkOut(10, "Waterloo", 38);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
	}

	public void checkIn(int id, String stationName, int t) {
		inTransit.put(id, new CheckinData(id, stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		final CheckinData chkinData = inTransit.remove(id);
		totalTime.computeIfAbsent(chkinData.station, unused -> new HashMap<>()).merge(stationName, t - chkinData.time,
				Integer::sum);
		freq.computeIfAbsent(chkinData.station, unused -> new HashMap<>()).merge(stationName, 1, Integer::sum);
	}

	public double getAverageTime(String startStation, String endStation) {
		return totalTime.get(startStation).get(endStation) * 1.0 / freq.get(startStation).get(endStation);
	}

	static class CheckinData {
		private final int id;
		private final String station;
		private final int time;

		CheckinData(int id, String station, int time) {
			this.id = id;
			this.station = station;
			this.time = time;
		}
	}
}

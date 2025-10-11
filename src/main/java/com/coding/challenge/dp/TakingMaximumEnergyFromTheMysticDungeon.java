package com.coding.challenge.dp;

class TakingMaximumEnergyFromTheMysticDungeon {
	TakingMaximumEnergyFromTheMysticDungeon() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] energy1 = { 5, 2, -10, -5, 1 };
		assert maximumEnergyOptimized(energy1, 3) == 3;

		final int[] energy2 = { -2, -3, -1 };
		assert maximumEnergyOptimized(energy2, 2) == -1;
	}

	static int maximumEnergy(int[] energy, int k) {
		// init.
		final int n = energy.length;
		final int[] ans = new int[n];
		for (int j = 0; j < k; j++)
			ans[j] = energy[j];

		for (int i = k; i < n; i++)
			ans[i] = Math.max(ans[i - k] + energy[i], energy[i]);

		// constructing an optimal solution.
		int maxEnergy = Integer.MIN_VALUE;
		for (int j = n - k; j < n; j++)
			maxEnergy = Math.max(maxEnergy, ans[j]);

		return maxEnergy;
	}

	static int maximumEnergyOptimized(int[] energy, int k) {
		final int n = energy.length;
		int maxEnergy = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			int j = i;
			int jumpMaxEnergy = 0;
			while (j < n) {
				jumpMaxEnergy = Math.max(jumpMaxEnergy + energy[j], energy[j]);
				j = j + k;
			}
			maxEnergy = Math.max(maxEnergy, jumpMaxEnergy);	
		}
		return maxEnergy;
	}
}

package com.coding.challenge.array;

class Bank {
	private final long[] balance;

	public Bank(long[] balance) {
		this.balance = balance;
	}

	public static void main(String[] args) {
		final long[] balance1 = { 10, 100, 20, 50, 30 };
		final Bank bank = new Bank(balance1);
		assert bank.withdraw(3, 10);
		assert bank.transfer(5, 1, 20);
		assert bank.deposit(5, 20);
		assert !bank.transfer(3, 4, 15);
		assert !bank.withdraw(10, 50);
	}

	public boolean transfer(int account1, int account2, long money) {
		if (validateAccountNumber(account2) && withdraw(account1, money)) {
			deposit(account2, money);
			return true;
		}
		return false;
	}

	public boolean deposit(int account, long money) {
		if (validateAccountNumber(account)) {
			balance[account - 1] = balance[account - 1] + money;
			return true;
		}
		return false;
	}

	public boolean withdraw(int account, long money) {
		if (validateAccountNumber(account) && money <= balance[account - 1]) {
			balance[account - 1] = balance[account - 1] - money;
			return true;
		}
		return false;
	}

	private boolean validateAccountNumber(int account) {
		return account > 0 && account <= balance.length;
	}
}

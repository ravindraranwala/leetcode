package com.coding.challenge.queue;

class CircularQueue {
	final int capacity;
	final int[] a;
	int head = 0;
	int tail = -1;
	int size = 0;

	CircularQueue(int k) {
		this.capacity = k;
		a = new int[k];
	}

	public static void main(String[] args) {
		final CircularQueue circularQueue = new CircularQueue(3);
		assert circularQueue.enQueue(1);
		assert circularQueue.enQueue(2);
		assert circularQueue.enQueue(3);
		assert !circularQueue.enQueue(4);
		assert circularQueue.Rear() == 3;
		assert circularQueue.isFull();
		assert circularQueue.deQueue();
		assert circularQueue.enQueue(4);
		assert circularQueue.Rear() == 4;

		final CircularQueue circularQueueTwo = new CircularQueue(3);
		assert circularQueueTwo.enQueue(2);
		assert circularQueueTwo.Rear() == 2;
		assert circularQueueTwo.Front() == 2;
		assert circularQueueTwo.deQueue();
		assert circularQueueTwo.Front() == -1;
		assert !circularQueueTwo.deQueue();
		assert circularQueueTwo.Front() == -1;
		assert circularQueueTwo.enQueue(4);
		assert circularQueueTwo.enQueue(2);
		assert circularQueueTwo.enQueue(2);
		assert !circularQueueTwo.enQueue(3);
		assert circularQueueTwo.Front() == 4;
	}

	public boolean enQueue(int value) {
		if (size == capacity)
			return false;
		tail = (tail + 1) % capacity;
		a[tail] = value;
		size = size + 1;
		return true;
	}

	public boolean deQueue() {
		if (size == 0)
			return false;
		head = (head + 1) % capacity;
		size = size - 1;
		return true;
	}

	public int Front() {
		if (size == 0)
			return -1;
		return a[head];
	}

	public int Rear() {
		if (size == 0)
			return -1;
		return a[tail];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}
}

package basic.algorithm.implementation;

public class ArrayQueue {
	public Integer[] arr;
	private Integer size;
	private Integer start;
	private Integer end;

	public ArrayQueue(int initSize) {
		if (initSize < 0) {
			throw new IllegalArgumentException("This init size is less than 0");
		}

		arr = new Integer[initSize];
		size = 0;
		start = 0;
		end = 0;
	}

	public Integer peek() {
		if (size == 0) {
			return null;
		}

		return arr[start];
	}

	public void push(int obj) {
		if (size == arr.length) {
			throw new IllegalArgumentException("The queue is full");
		}
		size++;
		arr[end] = obj;
		end = (end == arr.length - 1) ? 0 : end+1;
	}

	public Integer poll() {
		if (size == 0) {
			throw new IllegalArgumentException("The queue is empty");

		}
		size--;
		int tmp = start;
		start = (start == arr.length - 1) ? 0 : start + 1;
		return arr[tmp];
	}
	
	public void print(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString() + " ");
		}
	}
 	
	
	public static void main(String args[]) {
		ArrayQueue q = new ArrayQueue(3);
		q.push(10);	
		q.push(20);
		q.push(30);
		System.out.println(q.poll() + " Popped from queue");
	}
}

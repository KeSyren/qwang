package basic.algorithm.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
	private Queue<Integer> data;
	private Queue<Integer> help;

	public TwoQueueStack() {
		this.data = new LinkedList<Integer>();
		this.help = new LinkedList<Integer>();
	}

	public void push(int pushInt) {
		this.data.add(pushInt);
	}
	
	public int peek() {
		if (data.isEmpty()) {
			throw new RuntimeException("Stack is  mpty");
		}
		while (data.size() > 1) {
			help.add(data.poll());
		}
		int res = data.poll();
		swap();
		return res;
	}

	public int pop() {
		if (data.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		while (data.size() > 1) {
			help.add(data.poll());
		}
		int res = data.poll();
		swap();
		return res;
	}
	
	/**
	 * swap pointers
	 */
	private void swap() {
		Queue<Integer> tmp = help;
		help = data;
		data = tmp;
	}
	
	public static void main(String[] args) {
		TwoQueueStack sq = new TwoQueueStack();
		sq.push(4);
		sq.push(2);
		sq.push(12);
		System.out.print(sq.peek());
	}

}

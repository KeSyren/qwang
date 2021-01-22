package basic.algorithm.implementation;

import java.util.Stack;

public class TwoStackQueue {

	Stack<Integer> stackPush;
	Stack<Integer> stackPop;
	
	public TwoStackQueue() {
		this.stackPop = new Stack<Integer>();
		this.stackPush = new Stack<Integer>();
	}
	
	public void push(int pushInt) {
		stackPush.push(pushInt);
	}
	
	public int poll() {
		if(stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty");
			
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		} 
		return stackPop.pop();
	}
	
	public int peek() {
		if(stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty");
			
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		} 
		return stackPop.peek();
	}
	
	
	public static void main(String[] args) {
			TwoStackQueue sq = new TwoStackQueue();
			sq.push(4);
			sq.push(2);
			sq.push(12);
			System.out.print(sq.poll());
		}
	
	
}

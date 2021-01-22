package basic.algorithm.implementation;

import java.util.Stack;

public class StackMin {
	Stack<Integer> stackData;
	Stack<Integer> stackMin;
	
	public StackMin() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>(); 
	}
	
	public void push(int obj) {
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(obj);
		} else if (stackMin.peek() > obj) {
			this.stackMin.push(obj);
		} else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(obj);
	}
	
	public Integer pop() {
		if (this.stackData.isEmpty()) {
			throw new IllegalArgumentException("The stack is empty");
		} 
		this.stackMin.pop();
		return this.stackData.pop();
		
	}
	
	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new IllegalArgumentException("The stack is empty");
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args) {
		StackMin sm = new StackMin();
		sm.push(4);
		sm.push(2);
		sm.push(12);
		System.out.print(sm.getMin());
		
		System.out.println();
		sm.push(1);
		
		System.out.print(sm.getMin());
		System.out.println();
	}
}

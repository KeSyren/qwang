package basic.algorithm.implementation;

import java.util.Stack;

public class StackMin {
	Stack<Integer> a = new Stack<Integer>();
	Stack<Integer> b = new Stack<Integer>();
	
	public void push(int obj) {
		a.push(obj);
		
		if (b.isEmpty()) {
			b.push(obj);
		} else if (b.peek() > obj) {
			b.push(obj);
		} else {;}
		
	}
	
	public Integer pop() {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("The stack is empty");
		} 
		if (a.peek() == b.peek()) {
			b.pop();
		}
		return a.pop();
		
	}
	
	public int getMin() {
		if (b.isEmpty()) {
			throw new IllegalArgumentException("The stack is empty");
		}
		return b.peek();
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

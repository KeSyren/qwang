package basic.algorithm.implementation;

/**
 * use array to implement a stack (data structure to data structure)
 * 
 * @author qingwang
 *
 */
public class ArrayStack {
	private Integer[] arr;
	private Integer index;

	/**
	 * Constructor
	 * 
	 * @param initSize
	 */
	public ArrayStack(int initSize) {
		if (initSize < 0)
			throw new IllegalArgumentException("This init size is less than 0.");
		arr = new Integer[initSize];
		index = 0;
	}

	/**
	 * return top value.
	 * 
	 * @return
	 */
	public Integer peek() {
		if (index == 0) {
			return null;
		}
		return arr[index - 1];
	}

	public void push(int obj) {
		if (index == arr.length) {
			throw new ArrayIndexOutOfBoundsException("This queue is full.");
		}
		arr[index++] = obj;
	}

	public Integer pop() {
		if (index == 0) {
			throw new ArrayIndexOutOfBoundsException("This queue is empty.");
		}

		return arr[--index];
	}

	public static void main(String args[]) {
		ArrayStack s = new ArrayStack(3);
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}

}

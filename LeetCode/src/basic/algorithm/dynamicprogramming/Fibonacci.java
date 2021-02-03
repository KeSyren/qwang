package basic.algorithm.dynamicprogramming;

public class Fibonacci {

	// recursive way
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	// Fibonacci series using dynamic programming
	public static int fib2(int n) {
		// declare an array to store Fibonacci numbers
		if (n <= 1)
			return n;

		int f[] = new int[n + 1];
		int i;

		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}
	
	// Assume the n is non-negative numbers.
	public static int fib3(int n) {
	  if (n <= 1) return n;
	  // Declare an array to store Fibonacci numbers
	  int fib_nums[] = new int[n]; 
	  
	  fib_nums[0] = 1;
	  fib_nums[1] = 1;
	  
	  for(int i = 2; i < n; i++) {
	   fib_nums[i] = fib_nums[i - 1] + fib_nums[i - 2];
	  }
	  
	  return fib_nums[n - 1];
	 }
	
	// Assume the n is non-negative numbers.
	public static int fib4(int n) {
	  if (n <= 1) return n;
	 
	  int fib_previous = 1;
	  int fib_current = 1;
	  int fib_next = 2;
	  
	  for(int i = 2; i < n; i++) {
	   fib_next = fib_current + fib_previous;
	   fib_previous = fib_current;
	   fib_current = fib_next;
	  }
	  
	  return fib_current;
	 }

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fib2(i));
		}
		System.out.println(fib3(3));
	}
}

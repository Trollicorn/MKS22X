public class Recursion{

	public int fact(int n){
		if (n < 0){
			throw new IllegalArgumentException();
		}
		if (n == 0){
			return 1;
		}
		return n * fact(n-1);
	}


	public int fib(int n){
		if (n < 0){
			throw new IllegalArgumentException();
		}
		return fibHelper(0, 1, 0, n);
	}

	private int fibHelper(int now, int next, int at, int target){
		if (at == target){
			return now;
		}
		return fibHelper(next, next + now, at + 1, target);
	}

	public double sqrt(double n){
		if (n < 0){
			throw new IllegalArgumentException();
		}
		if (n == 0){
			return 0;
		}
		return sqrtHelper(1,n);
	}

	private double sqrtHelper(double guess, double target){
		if (Math.abs(target - Math.pow(guess,2)) < 0.0000000000001){
			return guess;
		}
		guess = (target/guess + guess)/2;
		return sqrtHelper(guess, target);
	}

	public static void main(String[] args){
		Recursion test = new Recursion();

		System.out.println(test.fact(0));
		System.out.println(test.fact(1));
		System.out.println(test.fact(10));

		System.out.println(test.fib(0));
		System.out.println(test.fib(1));
		System.out.println(test.fib(2));		
		System.out.println(test.fib(5));
		System.out.println(test.fib(10)); 

		System.out.println(test.sqrt(0));
		System.out.println(test.sqrt(4));
		System.out.println(test.sqrt(100));
		System.out.println(test.sqrt(10));
		System.out.println(test.sqrt(2));
		System.out.println(test.sqrt(0.0001));
		System.out.println(test.sqrt(0.001));

	}

}
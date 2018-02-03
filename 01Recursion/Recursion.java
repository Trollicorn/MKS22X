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
		
	}


}
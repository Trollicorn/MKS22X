import java.util.Arrays;

public class Sorts{

	public static void heapsort(int[] data){
		int i = data.length - 1;
		while (i > -1){
			if (!pushUp(data, i)){
				i--;
			}
		}

	}

	private static boolean pushUp(int[] data, int n){
		int p = (n - 1) / 2;
	//	int p = n - 1;
		if (n == 0){
			return false;
		}

		if (data[p] > data[n]){
			swap(data, p, n);
			pushUp(data, p);
			return true;
		}
		return false;

	}

	private static void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public static void main(String[] args){
		int[] b = {4, 2, 3, 5, 6, 1, 4, 6, 1, 5, 7,3, 9, 0, 3};
		System.out.println(Arrays.toString(b));
		heapsort(b);
		System.out.println(Arrays.toString(b));
	}

}

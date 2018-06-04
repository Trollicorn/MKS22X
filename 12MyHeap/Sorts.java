import java.util.Arrays;

public class Sorts{

	public static void heapsortNew(int[] data){
		for (int i = 0; i < data.length; i++){
			heapify(data, i);
		}
	}

	public static void heapsort(int[] data){
		MyHeap<Integer> heap = new MyHeap<>();
		for (int i = 0; i < data.length; i++){
			heap.add(data[i]);
		}
		while (heap.size() != 0){
			data[heap.size() - 1] = heap.remove();
		}
	}

	private static void heapify(int[] data, int begin){
		int i = data.length - 1;
		while (i > begin ){
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
		heapsortNew(b);
		System.out.println(Arrays.toString(b));
	}

}

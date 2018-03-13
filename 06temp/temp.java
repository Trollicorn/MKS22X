public class temp{


	public static int partition(int[] data, int start, int end){
		
		int pi = (int) (Math.random() * data.length);
		int pivot = data[pi];
		System.out.println(pi);
		swap(data, 0, pi);

		int small = 0;
		int large = data.length;

		while (small < data.length && large > 0){
			if (data[small] < pivot){
				small += 1;
			}else if (data[small] >= pivot){
				swap(data, small, large);
				large -= 1;
			}
			if (small == large){
				if (data[small] < pivot){
					pi = small;
					swap(data, small, 0);
				}else{
					pi = small - 1;
					swap(data, small - 1, 0);
				}
				return pi;
			}
		}
		return -1;
	}

	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args){
		int[] test = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
		System.out.println(temp.partition(test, 0, 9));
	}

}
public class Quick{

	public static int quickSelect(int[] data, int k){
		
		int start = 0;
		int end = data.length - 1;

	//	int index = quickH(data, k, start, end);
	//	return data[index];

		while (true){
			int pi = partition(data, start, end);
			if (pi == k){
				return data[pi];
			}else if (pi > k){
				end = pi - 1;
			}else{
				start = pi + 1;
			}
		}
	}

	public static int partition(int[] data, int start, int end){
		
		int pi = (int) (Math.random() * (end - start)) + start;
		int pivot = data[pi];
		swap(data, start, pi);

		int small = start + 1;
		int large = end;

		while (small != large){
			if (data[small] < pivot){
				small += 1;
			}else if (data[small] >= pivot){
				swap(data, small, large);
				large -= 1;
			}
			
		}

		if (data[small] < pivot){
			pi = small;
			swap(data, small, start);
		}else{
			pi = small - 1;
			swap(data, small - 1, start);
		}
		return pi;

	}

	private static void print(int[] stuff){
		String gather = "{ ";
		for (int i = 0; i < stuff.length; i++){
			gather += stuff[i] + ", ";
		}
		System.out.println(gather + "}");
	}

	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


	public static void main(String[] args){
	/*	int[] p = {999,999,999,4,1,0,3,2,999,999,999};
		System.out.println(Quick.partition(p, 0, p.length - 1));
		for (int i = 0; i < p.length; i++){
			System.out.println(p[i] + " ");
		}
	*/
		int[] test = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
		System.out.println(Quick.quickSelect(test, 3));
		String gather = "{";
		for (int i = 0; i < test.length; i++){
			gather += test[i] + ", ";
		}
		System.out.println(gather + "}");
	}

}
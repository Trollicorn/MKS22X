public class Quick{

	public static int quickselect(int[] data, int k){
		
		int start = 0;
		int end = data.length - 1;

	//	int index = quickH(data, k, start, end);
	//	return data[index];

		while (true){
			int pi = partition(data, start, end);
			if (pi == k - 1){
				return data[pi];
			}else if (pi > k - 1){
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

		while (small <= large){
			if (data[small] < pivot){
				small += 1;
			}else{
				swap(data, small, large);
				large -= 1;
			}
			
		}

		swap(data, start, large);

	/*	if (data[small] < pivot){
			pi = small;
			swap(data, small, start);
		}else{
			pi = small - 1;
			swap(data, small - 1, start);
		}*/
		return large;

	}

	public static void part(int[] data, int start, int end){
		
		int pi = (int) (Math.random() * (end - start)) + start;
		int pivot = data[pi];
		swap(data, start, pi);

		int small = start + 1;
		int equal = small + 1;
		int large = end;

		while (equal <= large){
			if (data[equal] == pivot){
				equal += 1;
			}else if(data[equal] > pivot){
				swap(data, equal, large);
				large -= 1;
			}else{ 
				swap(data, small, equal);
				small += 1;
				equal += 1;
			}
			
		}
		swap(data, start, large);
		part(data, start, small);
		part(data, equal, large);
	}


	public static void quicksort(int[] data){
		//
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
		System.out.println(partition(p, 0, p.length - 1));
		print(p); 
		int[] test = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
		System.out.println(quickselect(test, 7));
		print(test); */
		int[] test = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
		part(test,0,test.length-1);
		print(test);
	}

}
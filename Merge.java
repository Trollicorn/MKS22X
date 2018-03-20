public class Merge{


	public static void mergesort(int[] data){
		mergeHelp(data, 0, data.length - 1);
	}

	private static void mergeHelp(int[] data, int start, int end){
		if (start == end){
			return;
		}
		int mid = (start + end) / 2;		
		mergeHelp(data, start, mid);
		mergeHelp(data, mid + 1, end);
		int[] temp = merge(data, start, mid, end);
		for (int i = start; i < end + 1; i++){
			data[i] = temp[i - start];
		}
	}

	private static int[] merge(int[] data, int start, int mid, int end){
		int[] temp = new int[end - start + 1];
		int left = 0;
		int right = 0;
		while (start + left < mid + 1 && mid + 1 + right < end + 1){
			if (data[start + left] < data[mid + 1 + right]){
				temp[left + right] = data[start + left];
				left++;
			}else{
				temp[left + right] = data[mid + 1 + right];
				right++;
			}
		}
		if (start + left == mid + 1 && mid + 1 + right != end + 1){
			while (mid + 1 + right < end + 1){
				temp[left + right] = data[mid + 1 + right];
				right++;
			}
		}else if (mid + 1 + right == end + 1 && start + left != mid + 1){
			while (start + left < mid + 1){
				temp[left + right] = data[start + left];
				left++;
			}
		}
		return temp;
	}

	public static void forMerge(int[] data){
		for (int deno = 1; deno < (Math.log(data.length)/Math.log(2)) + 1; deno++){

		}
	}

	private static void print(int[] data){
		String gather = "[";
		for (int i = 0; i < data.length; i++){
			gather += data[i];
			if (i < data.length - 1){
				gather += ",";
			}
		}
		gather += "]";
		System.out.println(gather);
	}

	public static void main(String[] args){
		int[] test = {4,2,8,1,6,3};
		mergesort(test);
		print(test);
		int i = (int) (Math.log(53)/Math.log(2));
		System.out.println(i);
	}


}
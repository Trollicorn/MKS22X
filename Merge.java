public class Merge{


	public static void mergesortOld(int[] data){
		mergeHelp(data, 0, data.length - 1);
	}

	public static void mergesort(int[] data){
		int[] temp = new int[data.length];
		msort(data, temp, 0, data.length - 1);
	}

	private static void msort(int[] data, int[] temp, int start, int end){
		if (start == end){
			return;
		}
		int mid = (start + end) / 2;		
		msort(temp, data, start, mid);
		msort(temp, data, mid + 1, end);
		merge(temp, data, start, mid, end);
	}

	private static void merge(int[] data, int[] temp, int start, int mid, int end){
		int left = 0;
		int right = 0;
		int inc = 0;
		while (start + left < mid + 1 && mid + 1 + right < end + 1){
			if (data[start + left] < data[mid + 1 + right]){
				temp[start + inc] = data[start + left];
				left++;
				inc++;
			}else{
				temp[start] + inc] = data[mid + 1 + right];
				right++;
				inc++;
			}
		}
		if (start + left == mid + 1 && mid + 1 + right != end + 1){
			while (mid + 1 + right < end + 1){
				temp[start + inc] = data[mid + 1 + right];
				right++;
				inc++;
			}
		}else if (mid + 1 + right == end + 1 && start + left != mid + 1){
			while (start + left < mid + 1){
				temp[start + inc] = data[start + left];
				left++;
				inc++;
			}
		}
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
		int[] test = {4,2,8,1,6,9,4,5};
		mergesort(test);
		print(test);
	}


}
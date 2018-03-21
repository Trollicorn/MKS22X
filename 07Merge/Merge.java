public class Merge{


	public static void mergesortOld(int[] data){
		mergeHelp(data, 0, data.length - 1);
	}

	public static void mergesort(int[] data){
		int[] temp = new int[data.length];
		msort(data, temp, 0, data.length - 1);
		int len = data.length;
		if ( (int)(Math.log(len)/Math.log(2)) % 2 == 1 ){
			merge(data, temp, 0, (data.length - 1)/2, data.length-1);
		}
	}

	private static void msort(int[] data, int[] temp, int start, int end){
		if (start == end){
			return;
		}
		int mid = (start + end) / 2;		
		msort(temp, data, start, mid);
		msort(temp, data, mid + 1, end);
		merge(temp, data, start, mid, end); // temp into data
	}

	private static void merge(int[] data, int[] temp, int start, int mid, int end){
		int left = 0;
		int right = 0;
		int inc = 0;
		while (start + left < mid + 1 && mid + 1 + right < end + 1){
			if (temp[start + left] < temp[mid + 1 + right]){
				data[start + inc] = temp[start + left];
				left++;
				inc++;
			}else{
				data[start + inc] = temp[mid + 1 + right];
				right++;
				inc++;
			}
		}
		if (start + left == mid + 1 && mid + 1 + right != end + 1){
			while (mid + 1 + right < end + 1){
				data[start + inc] = temp[mid + 1 + right];
				right++;
				inc++;
			}
		}else if (mid + 1 + right == end + 1 && start + left != mid + 1){
			while (start + left < mid + 1){
				data[start + inc] = temp[start + left];
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
		int log = (int)(Math.log(data.length)/Math.log(2)) + 1;
		for (int level = 1; level < log; level++){
			int[] temp = new int[(int)Math.pow(2,level)];
			//print(temp);
			for (int i = 0; i < data.length; i += (int)Math.pow(2,level)){
			//	System.out.println(data[i]);
				int j = 0;
				int inc1 = 0;
				int inc2 = 0;
				while (j < temp.length && inc1 < (int)Math.pow(2,level-1) && inc2 < (int)Math.pow(2,level-1)){
				//	System.out.println(inc1 + "," + inc2);
				//	System.out.println(data[i + inc1] + "," + data[i + (int)Math.pow(2,level-1) + inc2]);
					if (data[i + inc1] < data[i + (int)Math.pow(2,level-1) + inc2]){
						temp[j] = data[i + inc1];
						inc1++;
					}else{
						temp[j] = data[i + (int)Math.pow(2,level-1) + inc2];
						inc2++;
					}
					j++;
				}
				if (j < temp.length){
					if (inc1 == (int)Math.pow(2,level-1) && inc2 < (int)Math.pow(2,level-1)){
						while(inc2 < (int)Math.pow(2,level-1)){
							temp[j] = data[i + (int)Math.pow(2,level-1) + inc2];
							inc2++;
						}
					}else if (inc2 == (int)Math.pow(2,level-1)){
						while(inc1 < (int)Math.pow(2,level-1)){
							temp[j] = data[i + inc1];
							inc1++;
						}
					}
				}
			//	print(temp);
				for (int k = 0; k < temp.length; k++){
					//System.out.println(i+k+","+k);
					data[i+k] = temp[k];
					//print(data);
				}
		//		print(data);
			}
			//print(data);
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
		int[] test = {4,2,8,1,5};
	//	int[] test = {4,2,8,1,6,9,3,5};
	//	int[] test = {4,2,8,1,6,9,3,5};
	//	int[] test = {4,2,8,1,6,9,3,5};
	//	int[] test = {4,2,8,1,6,9,3,5};
		//mergesort(test);
		forMerge(test);
		print(test);
	}


}
public class Sorts{

	public static void radixsort(MyLinkedListImproved<Integer> data){

		@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];
		for (int m = 0; m < 10; m++){
			bucket[m] = new MyLinkedListImproved<Integer>();
		}
		int max = data.get(data.max());
		int digits = (int)Math.log10(max) + 1;
		for (int d = 0; d < digits; d++){
			for (Integer j : data){
				int num = (j / (int)Math.pow(10,d)) % 10;
				bucket[num].add(j);
			}
			data.clear();
			for (int i = 0; i < 10; i++){
				data.extend(bucket[i]);
			}
		}

	}

	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){

		@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];
		MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
		MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();
		for (int m = 0; m < 10; m++){
			bucket[m] = new MyLinkedListImproved<Integer>();
		}

		
		for (Integer j : data){
			if (j >= 0){
				pos.add(j);
			}else{
				neg.add(j);
			}
		}
		data.clear();

		int max = pos.get(pos.max());
		int digitP = (int)Math.log10(max) + 1;
		for (int d = 0; d < digitP; d++){
			for (Integer j : pos){
				int num = (j / (int)Math.pow(10,d)) % 10;
				bucket[num].add(j);
			}
			data.clear();
			for (int i = 0; i < 10; i++){
				pos.extend(bucket[i]);
			}
		}

	//	System.out.println(pos);
	//	System.out.println(neg);

		int min = neg.get(neg.min());
		int digitN = (int)Math.log10(-1 * min) + 1;
		for (int d = 0; d < digitN; d++){
			for (Integer j : data){
				int num = (-1 * j / (int) Math.pow(10,d)) % 10;
				bucket[9 - num].add(j);
			}
			data.clear();
			for (int i = 0; i < 10; i++){
				data.extend(bucket[i]);
			}
		}

		data.extend(neg);
		data.extend(pos);



/*		@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];
		MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
		int i = 0;
		for (Integer j : data){
			if (j >= 0){
				pos.add(data.remove(i));
			}else{
				i++;
			}
		}
		int max = pos.get(pos.max());
		int min = data.get(data.min());
		int digitP = (int) Math.ceil(Math.log10(max));
		int digitN= (int) Math.ceil(Math.log10(min * -1));
		
		for	(int dig = 1; dig < digitN + 1; dig++){
			for (Integer j : data){
				int temp = (j / (int)Math.pow(10,dig - 1)) % 10;
				bucket[temp].add(j);
				data.remove(0);
			}
			for (int k = 0; k < 10; k++){
				data.extend(bucket[9-k]);
			}
		}
*/
	}

	public static void main(String[] args){
		MyLinkedListImproved<Integer> L = new MyLinkedListImproved<>();
		for (int i = 0; i < 6; i++){
			L.add( (int)(Math.random() * 20) - 10);
		}
		System.out.println(L);
		radixsortIncludingNegatives(L);
		System.out.println(L);
	}

}
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

		System.out.println(pos);
		System.out.println(neg);

		int max = pos.get(pos.max());
		int digitP = (int)Math.log10(max) + 1;
		for (int d = 0; d < digitP; d++){
			for (Integer j : pos){
				int num = (j / (int)Math.pow(10,d)) % 10;
				bucket[num].add(j);
			}
			pos.clear();
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
				bucket[num].add(0,j);
			}
			neg.clear();
			for (int i = 0; i < 10; i++){
		//		System.out.println("bucket" + i);
		//		System.out.println(bucket[i]);
				neg.extend(bucket[9-i]);
			}
			System.out.println(d);
			System.out.println(neg);
		}

		System.out.println(pos);
		System.out.println(neg);

		data.extend(neg);
		data.extend(pos);

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
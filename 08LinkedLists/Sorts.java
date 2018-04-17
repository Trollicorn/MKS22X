public class Sorts{

	public static void radixsort(MyLinkedListImproved<Integer> data){

		@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];
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

	}

	public static void main(String[] args){

	}

}
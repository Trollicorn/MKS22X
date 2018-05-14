public class MyHeap<T extends Comparable<T>>{

	private T[] data;
	private boolean isMax;
	private int length;

	@SuppressWarnings("unchecked")
	public MyHeap(){
		data = (T[]) new Comparable[10];
		isMax = true;
		length = 0;
	} 

	@SuppressWarnings("unchecked")
	public MyHeap(boolean max){
		data = (T[]) new Comparable[10];
		isMax = max;
		length = 0;
	}

	public int size(){
		return length;
	}

	public T peek(){
		return data[0];
	}

	public void add(T s){
		data[size()] = s;
		pushUp(size());
		length++;
	}

	public T remove(){
		T str = data[0];
		swap(0, size());
		pushDown(0);
		length--;
		return str;
	}

	private void pushUp(int n){
		int p = (n - 1) / 2;
		if (n == 0){
			return;
		}
		if (isMax && data[p].compareTo(data[n]) < 0 || !isMax && data[p].compareTo(data[n]) > 0){
			swap(p, n);
			pushUp(p);
		}
	}

	private void pushDown(int n){
		int cL = 2 * n + 1;
		int cR = 2 * n + 2;

		if (isMax){
			if (data[cL].compareTo(data[n]) > 0){
				swap(cL, n);
				pushDown(cL);
			}else if (data[cR].compareTo(data[n]) > 0){
				swap(cR, n);
				pushDown(cR);
			}
		}else{ // is min
			if (data[cL].compareTo(data[n]) < 0){
				swap(cL, n);
				pushDown(cL);
			}else if (data[cR].compareTo(data[n]) < 0){
				swap(cR, n);
				pushDown(cR);
			}
		}

	}

	private void swap(int i, int j){
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void heapsort(){
		
	}


	public static void main(String[] args) {
		MyHeap<String> L = new MyHeap<>(false);
		L.add("aaa");
		L.add("bbb");
		L.add("ccc");
		L.add("beb");
		L.add("a");
		L.add("aac");
		L.add("d");
	//	System.out.println(L.remove());
		System.out.println(L.peek());
	}

}
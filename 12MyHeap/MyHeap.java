import java.util.Arrays;

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

	@SuppressWarnings("unchecked")
	public void resize(){
		T[] temp = (T[]) new Comparable[data.length * 2];
		for (int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}

	public int size(){
		return length;
	}

	public T peek(){
		return data[0];
	}

	public void add(T s){
		if (size() == data.length){
			resize();
		}
		data[size()] = s;
		pushUp(size());
		length++;
	}

	public T remove(){
		T str = data[0];
		swap(0, size() - 1);
		data[size() - 1] = null;
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

			if (exists(cL) && data[cL].compareTo(data[n]) > 0){
				swap(n, cL);
				pushDown(cL);
			}else if (exists(cR) && data[cR].compareTo(data[n]) > 0){
				swap(n, cR);
				pushDown(cR);
			}
		}else{ // is min
			if (exists(cL) && data[cL].compareTo(data[n]) < 0){
				swap(n, cL);
				pushDown(cL);
			}else if (exists(cR) && data[cR].compareTo(data[n]) < 0){
				swap(n, cR);
				pushDown(cR);
			}
		}

	}

	private boolean exists(int i){
		return i >= 0 && i < data.length && data[i] != null;
	}

	private void swap(int i, int j){
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public String toString(){
		return Arrays.toString(data);
	}

	public static void main(String[] args) {
		MyHeap<Integer> L = new MyHeap<>(false);
		L.add(23);
		L.add(42);
		L.add(99);
		L.add(32);
		L.add(1);
		L.add(22);
		L.add(7);
		System.out.println(L);
		System.out.println(L.remove());
	//	System.out.println(L.peek());
		System.out.println(L.remove());
		System.out.println(L.remove());
		System.out.println(L);
	}

}
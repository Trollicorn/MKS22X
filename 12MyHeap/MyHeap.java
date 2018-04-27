public class MyHeap{

	private String[] data;
	private boolean isMax;
	private int length;

	public MyHeap(){
		data = new String[10];
		isMax = true;
		length = 0;
	} 

	public MyHeap(boolean max){
		data = new String[10];
		isMax = max;
		length = 0;
	}

	public int size(){
		return length;
	}

	public String peek(){
		return data[0];
	}

	public void add(String s){
		data[size()] = s;
		pushUp(size());
		length++;
	}

	public String remove(){
		String str = data[0];
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
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}


}
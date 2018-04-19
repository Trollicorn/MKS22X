public class MyDeque<E>{

	private E[] data;
	private int length;
	private int front, back;

	@SuppressWarnings("unchecked")
	public MyDeque(){
		data = (E[]) new Object[10];
		length = 0;
	}

	@SuppressWarnings("unchecked")
	public MyDeque(int size){
		data = (E[]) new Object[size];
		length = 0;
	}

	public int size(){
		return length;
	}	

	@SuppressWarnings("unchecked")
	private void resize(){
		E[] temp = (E[]) new Object[data.length*2];
		for (int i = 0; i < size(); i++){
			temp[0] = data[(front + i)%size()];
		}
		data = temp;
	}

	public void addFirst(E value){
		if (value == null){
			throw new NullPointerException();
		}
		if (length == size() - 1){
			resize();
		}
		if (size() == 0){
			data[0] = value;
			front = 0;
			back = 0;
		}else if (front == 0){
			
		}
		length++;
	}

}
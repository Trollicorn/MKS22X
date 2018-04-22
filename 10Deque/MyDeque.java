import java.util.NoSuchElementException;

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
			front = data.length - 1;
			data[front] = value;			
		}else{
			front -= 1;
			data[front] = value;
		}
		length++;
	}

	public void addLast(E value){
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
		}else if (back == data.length - 1){
			back = 0;
			data[back] = value;			
		}else{
			back += 1;
			data[back] = value;
		}
		length++;
	}

	public E removeFirst(){
		if (size() == 0){
			throw new NoSuchElementException();
		}
		E temp = getFirst();
		data[front] = null;
		front = (front + 1) % data.length;
		return temp;
	}

	public E removeLast(){
		if (size() == 0){
			throw new NoSuchElementException();
		}
		E temp = getLast();
		data[back] = null;
		back = (back - 1) % data.length;
		if (back < 0){
			back += data.length;
		}
		return temp;
	}

	public E getFirst(){
		if (size() == 0){
			throw new NoSuchElementException();
		}
		return data[front];
	}

	public E getLast(){
		if (size() == 0){
			throw new NoSuchElementException();
		}
		return data[back];
	}





}
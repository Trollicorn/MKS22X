public class MyLinkedListImproved<E>{

	private Node<E> first; 
	private Node<E> last;
	private int length;

	private class Node<E>{
		private Node<E> next;
		private Node<E> prev; 
		private E data;

		private Node(E element){
			data = element;
			next = null; 
			prev = null;
		}

		private Node<E> getNext(){
			return next;
		}
		private Node<E> getPrev(){
			return prev;
		}
		private E getValue(){
			return data;
		}
		public String toString(){
			return "" + data;
		}
		private void setNext(Node<E> n){
			next = n;
		}
		private void setPrev(Node<E> n){
			prev = n;
		}
		private void setValue(E i){
			data = i;
		}
	}

	public MyLinkedListImproved(){
		first = null;
		last = null; 
		length = 0;
	}

	private Node getNode(int index){
		Node node = first;
		for (int i = 0; i < index; i++){
			node = node.getNext();
		}
		return node;
	}

	public boolean add(E value){
		
		Node<E> temp = new Node<E>(value);

		if (size() == 0){
			first = temp;
			last = temp;
		}else{
			last.setNext(temp);
			temp.setPrev(last);
			last = temp;
		}
		length++;
		return true;
	}

	public int size(){
		return length;
	}

	public void clear(){
		first = null;
		last = null;
		length = 0;
	}

	public String toString(){
		String gather = "[";
		Node<E> node = first;
		while (node != null){
			gather += " " + node + ",";
			node = node.getNext();
		}
		if (gather.length() != 1){
			gather = gather.substring(0, gather.length() - 1) + " ";
		}
		return gather + "]";
	}

	public E get(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node<E> node = getNode(index);
		return node.getValue();
	}

	public E set(int index, E element){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node<E> node = getNode(index);
		E re = node.getValue();
		node.setValue(element);
		return re;
	}

	public int indexOf(E value){
		Node<E> node = first;
		int i = 0;
		while (node != null){
			if (node.getValue().equals(value)){
				return i;
			}
			node = node.getNext();
			i++;
		}
		return -1; 
	}

	public void add(int index, E value){
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		if (index == size()){
			add(value);
			return;
		}
		if (index == 0){
			Node<E> temp = new Node<E>(value);
			temp.setNext(first);
			first.setPrev(temp);
			first = temp;
			length++;
			return;
		}
		Node<E> node = getNode(index - 1);
		Node<E> temp = new Node<E>(value);
		temp.setPrev(node);
		temp.setNext(node.getNext());
		temp.getNext().setPrev(temp);
		temp.getPrev().setNext(temp);
		length++;
	}

	public E remove(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		E re;
		if (size() == 1){
			re = first.getValue();
			first = null;
			last = null;
		}else if (index == size() - 1){
			re = last.getValue();
			last.getPrev().setNext(null);
			last = last.getPrev();
		}else if (index == 0){
			re = first.getValue();
			first = first.getNext();
		}else{
			Node<E> node = getNode(index);
			re = node.getValue();
			node.getNext().setPrev(node.getPrev());
			node.getPrev().setNext(node.getNext());
		}
		length--;
		return re;
	}

	public boolean remove(E value){
		Node<E> node = first;
		int i = 0;
		while (node != null){
			if (node.getValue().equals(value)){
				if (size() == 1){
					first = null;
					last = null;
				}else if (i == size() - 1){
					last.getPrev().setNext(null);
					last = last.getPrev();
				}else if (i == 0){
					first = first.getNext();
				}else{
					node.getNext().setPrev(node.getPrev());
					node.getPrev().setNext(node.getNext());
				}
				length--;
				return true;
			}
			node = node.getNext();
			i++;
		}
		return false;
	}

	public static void main(String[] args){
		MyLinkedListImproved<String> L = new MyLinkedListImproved<>();
		L.add("two"); 
		L.add(1, "four");
		L.add(0, "one"); 
		L.add(2, "three");
		L.add(4, "five"); 
		System.out.println(L);
		System.out.println(L.remove("three"));
		System.out.println(L);

	}

}
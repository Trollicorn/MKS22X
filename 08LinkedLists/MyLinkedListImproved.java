import java.util.*;

public class MyLinkedListImproved<T> implements Iterable<T>{

	private Node first; 
	private Node last;
	private int length;

	private class Node{
		private Node next;
		private Node prev; 
		private T data;

		private Node(T element){
			data = element;
			next = null; 
			prev = null;
		}

		private Node getNext(){
			return next;
		}
		private Node getPrev(){
			return prev;
		}
		private T getValue(){
			return data;
		}
		public String toString(){
			return "" + data;
		}
		private void setNext(Node n){
			next = n;
		}
		private void setPrev(Node n){
			prev = n;
		}
		private void setValue(T i){
			data = i;
		}
	}

	public MyLinkedListImproved(){
		first = null;
		last = null; 
		length = 0;
	}

	public Iterator<T> iterator(){
		return new Listerator(first);
	}

	public class Listerator implements Iterator<T>{
		private Node cursor;

		public Listerator(Node first){
			cursor = first;
		}

		public boolean hasNext(){
			return cursor != null;
		}

		public T next(){
			if (hasNext()){
				T value = cursor.getValue();
				cursor = cursor.getNext();
				return value;
			}
			throw new NoSuchElementException();
		}

	}

	private Node getNode(int index){
		Node node = first;
		for (int i = 0; i < index; i++){
			node = node.getNext();
		}
		return node;
	}

	public boolean add(T value){
		
		Node temp = new Node(value);

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
		Node node = first;
		while (node != null){
			gather += " " + node + ",";
			node = node.getNext();
		}
		if (gather.length() != 1){
			gather = gather.substring(0, gather.length() - 1) + " ";
		}
		return gather + "]";
	}

	public T get(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = getNode(index);
		return node.getValue();
	}

	public T set(int index, T element){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = getNode(index);
		T re = node.getValue();
		node.setValue(element);
		return re;
	}

	public int indexOf(T value){
		Node node = first;
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

	public void add(int index, T value){
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		if (index == size()){
			add(value);
			return;
		}
		if (index == 0){
			Node temp = new Node(value);
			temp.setNext(first);
			first.setPrev(temp);
			first = temp;
			length++;
			return;
		}
		Node node = getNode(index - 1);
		Node temp = new Node(value);
		temp.setPrev(node);
		temp.setNext(node.getNext());
		temp.getNext().setPrev(temp);
		temp.getPrev().setNext(temp);
		length++;
	}

	public T remove(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		T re;
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
			Node node = getNode(index);
			re = node.getValue();
			node.getNext().setPrev(node.getPrev());
			node.getPrev().setNext(node.getNext());
		}
		length--;
		return re;
	}

	public boolean remove(T value){
		Node node = first;
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

		for (String str : L){
			System.out.println(str);
		}

	}

}
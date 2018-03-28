public class MyLinkedList{

	private Node first; 
	private Node last;
	private int length;

	private class Node{
		private Node next;
		private Node prev; 
		private int data;

		private Node(int element){
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
		private int getValue(){
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
		private void setValue(int i){
			data = i;
		}
	}

	public MyLinkedList(){
		first = null;
		last = null; 
		length = 0;
	}

	public boolean add(int value){
		
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

	public String toString(){
		String gather = "[";
		Node node = first;
		while (node != null){
			gather += " " + node + ",";
			node = node.getNext();
		}
//		if (gather.length() != 1){
//			gather = gather.substring(0, gather.length() - 1);
//		}
		return gather + "]";
	}

	public int get(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = first;
		int i = 0;
		while (i < index){
			node = node.getNext();
			i++;
		}
		return node.getValue();
	}

	public int set(int index, int element){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = first;
		int i = 0;
		while (i < index){
			node = node.getNext();
			i++;
		}
		int re = node.getValue();
		node.setValue(element);
		return re;
	}

	public int indexOf(int value){
		Node node = first;
		int i = 0;
		while (node != null){
			if (node.getValue() == value){
				return i;
			}
			node = node.getNext();
			i++;
		}
		return -1; 
	}

	public void add(int index, int value){
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		if (index == size()){
			add(value);
			return;
		}
		Node node = first;
		int i = 0;
		while (i < index){
			node = node.getNext();
			i++;
		}
		Node temp = new Node(value);
		temp.setPrev(node);
		temp.setNext(node.getNext());
		temp.getNext().setPrev(temp);
		temp.getPrev().setNext(temp);
		length++;
	}

	public int remove(int index){
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		if (size() == 1){
			int re = first.getValue();
			first = null;
			last = null;
			return re;
		}
		if (index == size() - 1){
			int re = last.getValue();
			last.getPrev().setNext(null);
			last = last.getPrev();
			return re;
		}
		if (index == 0){
			int re = first.getValue();
			first = first.getNext();
			return re;
		}
		Node node = first;
		int i = 0;
		while (i < index){
			node = node.getNext();
			i++;
		}
		int re = node.getValue();
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		length--;
		return re;
	}

	public static void main(String[] args){
		MyLinkedList L = new MyLinkedList();
		L.add(9);
		L.add(8);
		L.add(7);
		L.add(6);
		L.remove(2);
		L.remove(2);
	//	L.remove(2);
		System.out.println(L);
	}

}
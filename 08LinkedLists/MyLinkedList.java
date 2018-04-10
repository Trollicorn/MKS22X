public class MyLinkedList{

	private Node first; 
	private Node last;
	private int length;

	private class Node{
		private Node next;
		private Node prev; 
		private Integer data;

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
		private Integer getValue(){
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

	public boolean add(Integer value){
		
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

	private Node getNode(int index){
		Node node = first;
		for (int i = 0; i < index; i++){
			node = node.getNext();
		}
		return node;
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

	private void printF(){
		String gather = toString();
		System.out.println(gather);
	}

	private void printR(){
		String gather = "[";
		Node node = last;
		while (node != null){
			gather += " " + node + ",";
			node = node.getPrev();
		}
		if (gather.length() != 1){
			gather = gather.substring(0, gather.length() - 1) + " ";
		}
		System.out.println(gather + "]");	
	}

	public Integer get(int index){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = getNode(index);
		return node.getValue();
	}

	public int set(int index, Integer element){
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node node = getNode(index);
		Integer re = node.getValue();
		node.setValue(element);
		return re;
	}

	public int indexOf(Integer value){
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

	public void add(int index, Integer value){
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

	public Integer remove(int index){
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		if (size() == 1){
			Integer re = first.getValue();
			first = null;
			last = null;
			length--;
			return re;
		}
		if (index == size() - 1){
			Integer re = last.getValue();
			last.getPrev().setNext(null);
			last = last.getPrev();
			length--;
			return re;
		}
		if (index == 0){
			Integer re = first.getValue();
			first = first.getNext();
			length--;
			return re;
		}
		Node node = getNode(index);
		Integer re = node.getValue();
		node.getNext().setPrev(node.getPrev());
		node.getPrev().setNext(node.getNext());
		length--;
		return re;
	}

	public boolean remove(Integer value){
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
		MyLinkedList L = new MyLinkedList();
		L.add(9);
		L.add(1, 8);
		L.add(0, 7);
		L.add(2, 6);
		L.add(4, 4);
		System.out.println(L.remove(2));
		L.printF();
		L.printR();
	}

}
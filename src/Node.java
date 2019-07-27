public class Node<E> {
	E data=null;
	Node<E> next=null;
	public Node(E data, Node<E> next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node(E element) {
		data=element;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public boolean equals(Node<E> e) {
		return data.equals(e.getData());
	}
	public String toString() {
		return data.toString();
	}
	
}
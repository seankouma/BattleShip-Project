
interface LinkedListInterface<E> {
	public Node<E> getHead();
	public int size();
	public void setSize(int size);
	public void addLast(E element);
	public void add(E element, int index);
	public Node<E> removeFirst();
	public void removeLast();
	public void remove(int index);
	public Node<E> getAt(int position);
	public String toString();
	void addFirst(E element);
	boolean contains(Node<E> e);
	void setHead(Node<E> head);
	

}

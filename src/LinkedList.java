
public class LinkedList<E> implements LinkedListInterface<E> {
	Node<E> head=null;
	int size=0;
	public LinkedList() {
	}
	public LinkedList (Node<E> head, int size) {
		this.head = head;
		this.size = size;
	}
	@Override
	public Node<E> getHead() {
		return head;
	}
	@Override
	public void setHead(Node<E> head) {
		this.head = head;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public void addFirst(E element) {
		Node<E> temp = new Node<E>(element);
		temp.next = head;
		head = temp;
		size++;
	}
	@Override
	public void addLast(E element) {
		if(head == null) {
			addFirst(element);
		}
		else {
			Node<E> current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(element);
			size++;
		}
	}
	@Override
	public void add(E element, int index) {
		if(index<=0) {
			addFirst(element);
		}else if(index>=size) {
			addLast(element);
		}else {
		Node<E> current=head;
		for(int i=0;i<index-1;i++) {
			current=current.next;
		}
		Node<E> temp=current.next;
		current.next=new Node<E>(element);
		current.next.next=temp;
		size++;
		}
	}
	@Override
	public Node<E> removeFirst() {
		if(size==1) {
			Node<E>temp=head;
			head=null;
			return temp;
		}else {
			Node<E> temp=head;
			head=head.next;
			size--;
			return temp;
		}
	}
	public void removeLast() {
		Node<E> current=head;
		for(int i=0;i<size-1;i++) {
			current=current.next;
		}
		current.next=null;
		size--;
	}
	public void remove(int index) {
		Node<E> current=head;
		if (index == 0) {
			head = head.next;
		} else if (index == 1) {
			
		} else {
		for(int i=0;i<index;i++) {
			current=current.next;
		}
		current.next=null;
		current.next=current.next.next;
		}
		size--;
	}
	@Override
	public Node<E> getAt(int position) {
		Node<E> current=head;
		for(int i=0;i<position;i++) {
			current=current.next;
		}
		return current;
	}
	
	@Override
	public boolean contains(Node<E> e) {
		for(int i=0;i<size;i++) {
			if(getAt(i)==e) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		Node<E> current=head;
		String end="";
		for(int i=0;i<size;i++) {
			end+=current+" ";
			current=current.next;
		}
		return end;
	}
}

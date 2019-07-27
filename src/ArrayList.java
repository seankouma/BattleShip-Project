
public class ArrayList<E> {
	Node[] array;
	int size;
	public ArrayList (int space){
		array=new Node[space];
		size=0;
	}
	public ArrayList() {
		array=new Node[10];
		size=0;
	}
	public void add(E e) {
		if(size>=array.length) {
			resetArray();
		}
		array[size]=new Node<E>(e);
		size++;
	}
	public void add(int index,E element) {
		if(index==size) {
			resetArray();
		}
		for(int i=size-1;i>=index;i--) {
			array[i+1]=array[i];
		}
		array[index]=new Node<E>(element);
		size++;
	}
	public E get(int index) {
		return (E) array[index].getData();
	}
	public int indexOf(E element) {
		Node<E> temp=new Node<E>(element);
		for(int i=0;i<size;i++) {
			if(array[i].equals(temp)) {
				return i;
			}
		}
		return -1;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public E remove(int index) {
		if(index>=size-1) {
			E temp=(E) array[size-1].getData();
			array[size-1]=null;
			size--;
			return temp;
		}else {
			E temp=(E) array[index].getData();
			for(int i=index;i<size-1;i++) {
				array[i]=array[i+1];
			}
			array[size-1]=null;
			size--;
			return temp;
		}
	}
	public void set(int index, E element) {
		if(index>=0&&index<size) {
			array[index]=new Node<E>(element);
		}
	}
	public void resetArray() {
		Node<E>[] temp=array;
		array=new Node[array.length+1];
		for(int i=0;i<temp.length;i++) {
			array[i]=temp[i];
		}
	}
	public int size() {
		return size;
	}
}

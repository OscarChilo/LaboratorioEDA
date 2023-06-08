import java.util.EmptyStackException;

public class Stack<T>{
	private Node <T> top;
	private int size;
	
	public Stack() {
		top=null;
		size=0;
	}
	
	//comprobar si la pila esta vacia
	
	public boolean isEmpty() {
		return size==0;
	}
	
	//retornar tamaño de la pila
	
	public int size() {
		return size;
	}
	
	//añadir un elemento en la pila
	
	public void push (T data) {
		Node<T> newNode =new Node<>(data);
		newNode.setNext(top);
		top=newNode;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}
	
	public int search(T element) {
		int index=1;
		Node<T> auxiliar=top;
		while (auxiliar!=null) {
			if(auxiliar.getData().equals(element)) {
				return index;
			}
			auxiliar =auxiliar.getNext();
			index++;
		}
		return -1;
	}
	
	
	
}
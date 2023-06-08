public class Node<T> {

	private T data;
	private Node<T> next;
	
	//constructor
	
	public Node (T data) {
		this.data=data;
		this.next=null;
	}
	
	//Obtener atributo data
	
	public T getData() {
		return data;
	}
	
	//establecer atributo data
	
	public void setData(T data) {
		this.data=data;
	}
	
	//obtener el siguiente nodo
	
	public Node<T> getNext(){
		return next;
	}
	
	//establecer el siguiente nodo
	
	public void setNext(Node<T> next) {
		this.next=next;
	}
}
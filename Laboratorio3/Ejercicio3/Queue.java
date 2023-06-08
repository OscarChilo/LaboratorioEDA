public class Queue <T>{
	
	private Node<T> first;
	private Node<T> last;
	private int length;
	
	public Queue() {
		this.first=null;
		this.last=null;
	}
	
	public boolean empty() {
		return this.length==0;
	}
	
	public T getFirst() {
		return this.first.getData();
	}
	
	public T deQueue() {
		if(isEmpty()) {
			System.out.println("Queue empty");
			return null;
		}
		T data=this.first.getData();
		this.first=this.first.getNext();
		this.length--;
		return data;
	}
	
	public void enQueue(T item) {
		if(this.first==null) {
			this.first=new Node<T>(item);
			this.last=this.first;
		}else {
			Node<T> newNode=new Node<T> (item);
			this.last.setNext(newNode);
			this.last=newNode;
			
			this.length++;
		}
	}
	
	public int search(Object o) {
		Node<T> aux=this.first;
		int pos=0;
		while(aux!=null&&!aux.getData().equals(o)) {
			aux=aux.getNext();
			pos++;
		}
		if(aux!=null) {
			return pos;
		}else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return this.length==0;
	}
	
	public String toString() {
		String s="";
		Node<T> aux=this.first;
		while(aux!=null) {
			s+=aux.getData()+" => ";
			aux=aux.getNext();
		}
		s+="null";
		return s;
	}
	
}
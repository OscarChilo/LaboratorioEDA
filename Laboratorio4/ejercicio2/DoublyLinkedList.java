package Laboratorio4.ejercicio2;



public class DoublyLinkedList <T> implements DoublyList<T> {
    private NodeDoble<T> head;
    private NodeDoble<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void insertFirst(T obj) {
        NodeDoble<T> newNode=new NodeDoble<T>(obj);
        if (this.isEmpty()) {
            this.head=newNode;
            this.tail=newNode;
        } else {
            newNode.setNextNode(this.head);
            this.head.setPreviousNode(newNode);
            this.head=newNode;
        }
        this.size++;
    }

    public void insertLast(T obj) {
        NodeDoble<T> newNode=new NodeDoble<T>(obj);
        if (this.isEmpty()) {
            this.head=newNode;
            this.tail=newNode;
        } else {
            newNode.setPreviousNode(this.tail);
            this.tail.setNextNode(newNode);
            this.tail=newNode;
        }
        this.size++;
    }

    public T removeFirst() throws ExceptionNoFound {
        if (this.isEmpty()) {
            throw new ExceptionNoFound("la lista is empty....");
        }
        T aux =head.getNode();
        if (this.head==this.tail) {
            this.head=null;
            this.tail=null;
        } else {
            this.head=this.head.getNextNode();
            this.head.setPreviousNode(null);
        }
        return aux;
    }

    public T removeLast() throws ExceptionNoFound{
         if (this.isEmpty()) {
            throw new ExceptionNoFound("la lista is empty....");
        }
        T aux =this.tail.getNode();
        if (this.head==this.tail) {
            this.head=null;
            this.tail=null;
        } else {
            this.tail=this.tail.getPreviousNode();
            this.tail.setNextNode(null);
        }
        return aux;
    }

    public NodeDoble<T> getFirst() throws ExceptionNoFound {
        if (this.isEmpty()) {
            throw new ExceptionNoFound("la lista es Empty....");
        } 
        return this.head;
    }

    public NodeDoble<T> getLast() throws ExceptionNoFound {
        if (this.isEmpty()) {
            throw new ExceptionNoFound("la lista es Empty....");
        } 
        return this.tail;
    }

    public boolean isEmpty(){
        return this.head==null && this.tail==null;
    }

    public void put(T valor) {
        if (size==0) {
            head=new NodeDoble(valor);
            tail=head;
            size++;
            return;
        } else {
            tail.setNextNode(new NodeDoble(valor));
            NodeDoble next=tail.getNextNode();
            next.setPreviousNode(tail);
            tail=next;
            size++;
        }
    }

    public int getSize() {
        return this.size;
    }
}

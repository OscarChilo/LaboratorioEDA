package Laboratorio4;

/**
 * Node
 */
public class Node<T> {
    private T valor;
    private Node next;
    
    public T getValor(){
        return valor;
    }
    public void setValor(T valor) {
        this.valor=valor;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next) {
        this.next=next;
    }
    public Node (T valor) {
        this.valor=valor;
    }
    public Node(T valor, Node next){
        this.valor=valor;
        this.next=next;
    }
}
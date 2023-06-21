package Laboratorio4.ejercicio1;

//import org.w3c.dom.Node;

/**
 * Node
 */
public class Node<T> {
    private T data;
    private Node<T> nextNode;

    public Node(){
    }

    public Node(T data){
        this.data=data;
    }

    public Node(T data, Node<T> nextNode) {
        this.data=data;
        this.nextNode=nextNode;
    }
    
    public T getData(){
        return this.data;
    }
    public void setData(T data) {
        this.data=data;
    }
    public Node getNextNode(){
        return this.nextNode;
    }
    public void setNextNode(Node<T> nextnNode) {
        this.nextNode=nextNode;
    }
    
}
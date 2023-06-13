package Laboratorio4;
import java.util.*;
//import org.w3c.dom.NodeList;

/**
 * NodeList
 */
public class NodeList<T>{

    private Node<T> raiz;
    private int size=0;

    public Node<T>getRaiz(){
        return raiz;
    }
    public void setRaiz(Node<T> raiz) {
        this.raiz=raiz;
    }
    public int getSize(){
        return size;
    }

    public void setSize(int size) {
        this.size=size;  
    }
    public NodeList(){

    }
    public Node<T> get(int indice){
        Node<T> aux=raiz;
        for(int i=0;i<indice;i++){
            aux=aux.getNext();
        }
        return aux;
    }
    public void remove(int indice) {
        if (indice<size) {
            if (indice==0) {
                raiz=raiz.getNext();
            } else {
                Node<T>anterior =this.get(indice-1);
                anterior.setNext(this.get(indice+1));
            }            
            size--;
        }
    }
    public void put(T valor) {
        if (size==0) {
            raiz=new Node(valor);
            size++;
            return;
        }
        get(size-1).setNext(new Node(valor));
        size++;
    }
    public void replace(int indice, T valor) {
        get(indice).setValor(valor);
    }
    public Node<T> getPrevious(){
        return previous;
    }
}
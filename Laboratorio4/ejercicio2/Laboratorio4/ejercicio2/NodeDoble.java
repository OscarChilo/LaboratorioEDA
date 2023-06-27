package Laboratorio4.ejercicio2;

import java.util.prefs.NodeChangeEvent;

public class NodeDoble<T>{
    private T node;
    private NodeDoble<T> nextNode;
    private NodeDoble<T> previousNode;

    NodeDoble(){
        this.node=null;
        this.nextNode=null;
        this.previousNode=null;
    }
    NodeDoble(T data){
        this.node=data;
        this.nextNode=null;
        this.previousNode=null;
    }
    NodeDoble( T data, NodeDoble<T> nextNode, NodeDoble<T> previousNode){
        this.node=data;
        this.nextNode=nextNode;
        this.previousNode=previousNode;
    }
    public void setPreviousNode(NodeDoble<T> previousNode) {
        this.previousNode = previousNode;
    }
    public void setNode(T node) {
        this.node=node;
    }
    public void setNextNode(NodeDoble<T> nextNode) {
        this.nextNode = nextNode;
    }
    public NodeDoble<T> getPreviousNode() {
        return this.previousNode;
    }
    public T getNode(){
        return this.node;
    }
    public NodeDoble<T> getNextNode() {
        return this.nextNode;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.node.toString();
    }

}

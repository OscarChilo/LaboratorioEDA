package Laboratorio4.ejercicio1;

import java.util.*;

/**
 * NodeList
 */
public class NodeList<T> {

    private Node<T> raiz;
    private int size;
    private long time;
    private int index;

    public NodeList() {
        this.raiz = null;
        this.size = 0;
    }

    public Node<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Node<T> raiz) {
        this.raiz = raiz;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void add(int index, T element) {
        if (index <= this.size) {
            if (this.raiz != null) {
                Node<T> newNode = new Node<>();
                newNode.setData(element);

                Node<T> currentNode = this.raiz;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.getNextNode();
                }
                if (currentNode.getNextNode() != null) {
                    newNode.setNextNode(currentNode.getNextNode());
                }

                currentNode.setNextNode(newNode);
            } else {
                this.add(index, element);
            }
            this.size++;
        }
    }

    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            this.add(index, element);
        }
    }

    public void addAll(int index, Collection<? extends T> c) {
        for (T element : c) {
            this.add(index, element);
            index++;
        }
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index <= 0 || index < this.size) {
            Node<T> node = this.raiz;
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
            return node.getData();
        } else {
            return null;
        }
    }

    public void set(int index, T element) {
        if (index >= 0 && index < this.size) {
            Node<T> currentNode = this.raiz;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setData(element);
        }
    }

    public void remove(int index) {
        if (index >= 0 || index < this.size()) {
            Node<T> node = this.raiz;
            if (index == 0) {
                this.raiz = node.getNextNode();
            } else if (index == this.size() - 1) {
                for (int i = 0; i < index - 1; i++) {
                    node = node.getNextNode();
                }

                node.setNextNode(null);
            } else {
                for (int i = 0; i < index - 1; i++) {
                    node = node.getNextNode();
                }
                node.setNextNode(node.getNextNode().getNextNode());
            }
            size--;
        }
    }

    public String toString() {
        String listComplet = "";
        Node<T> now = raiz;
        boolean nodof = true;

        while (now != null) {
            if (nodof) {
                listComplet += now.getData();
                nodof = false;
            } else {
                listComplet += " - " + now.getData();
            }
            now = now.getNextNode();
        }

        return listComplet;
    }
}
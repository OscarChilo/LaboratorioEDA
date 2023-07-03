package Laboratorio51;

public class NodeAvl<T> {
    private T data;
    private NodeAvl<T> left;
    private NodeAvl<T> right;
    private int bf;

    public NodeAvl(T data, NodeAvl<T> left, NodeAvl<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.bf = 0;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public NodeAvl(T data) {
        this(data, null, null);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeAvl<T> getLeft() {
        return this.left;
    }

    public void setLeft(NodeAvl<T> left) {
        this.left = left;
    }

    public NodeAvl<T> getRight() {
        return this.right;
    }

    public void setRight(NodeAvl<T> right) {
        this.right = right;
    }

    public String toString() {
        // TODO Auto-generated method stub
        return this.data.toString() + "(" + this.bf + ")";
    }
}

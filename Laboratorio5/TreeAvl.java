//import javax.swing.text.DefaultEditorKit.InsertBreakAction;

//import Laboratorio4.ejercicio2.ExceptionNoFound;

import Laboratorio4.ejercicio2.ExceptionNoFound;

public class TreeAvl<T extends Comparable<T>> {
    private NodeAvl<T> root;
    private boolean height;

    public TreeAvl() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T x) throws ExceptionNoFound {
        this.root = insert(x, this.root);
        this.height = false;
    }

    public NodeAvl<T> insert(T x, NodeAvl<T> current) throws ExceptionNoFound {
        NodeAvl<T> res = current;
        if (current == null) {
            rest = new NodeAvl<T>();
            this.height = true;
        } else {
            int resC = current.getData().compareTo(x);
            if (resC == 0)
                throw new ExceptionNoFound("Elemento ya se encuentra en el arbol");
            if (resC < 0) {
                res.setRight(insert(x, current.getRight()));
                if (this.height) {
                    switch (res.getBf) {
                        case -1:
                            res.setBf(0);
                            this.height = false;
                            break;
                        case 0:
                            rest.setBf(1);
                            break;
                        case 1:
                            res = balanceToLeft(res);
                            this.height = false;
                            break;
                    }
                }
            } else {
                res.setLeft(insert(x, current.getLeft()));
            }
        }
        return res;
    }

    private NodeAvl<T> balanceToLeft(NodeAvl<T> node) {
        NodeAvl<T> son = node.getRight();
        if (son.getBf() == 1) {
            node.setBf(0);
            son.setBf(0);
            node = rotateRsl(node);
        } else if (son.getBf() == 1) {
            switch (gSon.getBf()) {
                case -1:
                    nod.setBf(0);
                    son.setBf(-1);
                    break;
                case 0:
                    nod.setBf(0);
                    son.setBf(0);
                    break;
                case 1:
                    nod.setBf(1);
                    son.setBf(0);
                    break;
            }
            gSon.setBf(0);

            node.setRight(rotateRSR(son));
        }
        return node;
    }

    private NOdeAvl<T> rotateRSL(NodeAvl<T> node) {
        NOdeAvl<T> son = node.getRight();
        node.setRight(son.getLeft());
        son.setLeft(node);
        node = son;
        return node;
    }

    private NodeAvl<T> rotateRSR(NodeAvl<T> node) {
        NOdeAvl<T> son = node.getLeft();
        node.setLeft(son.getRight());
        son.setRight(node);
        node = son;
        return node;
    }

    public T getRoot() {
        return this.root.getData();
    }

    public T search(T x) throws ExceptionNoFound {
        nodeAvl<T> aux = search(x, this.root);
        if (aux == null)
            throw new ExceptionNoFound("El elemento no se encuentra en el arbol");
        return aux.getData();
    }

    private nodeAvl<T> search(T x, NodeAvl<T> current) throws ExceptionNoFound {
        if (current == null) {
            return null;
        } else {
            int resC = current.getData().compareTo(x);
            if (resC == 0)
                return current;
            if (resC < 0) {
                return search(x, current.getRight());
            } else {
                return search(x, current.getLeft());
            }
        }
    }

    public void remove(T x, NodeAvl<T> current) throws ExceptionNoFound {
        NodeAvl<T> res = current;
        if (current == null) {
            throw new ExceptionNoFound("Elemento no se encuentra en el arbol");
        } else {
            int resC = current.getData().compareTo(x);
            if (resC < 0) {
                res.setRight(remove(x, current.getRight()));
            } else {
                if (resC > 0)
                    res.setLeft(remove(x, current.getLeft()));
                else {
                    if (current.getLeft() != null && current.getRight() != null) {

                    } else {
                        if (isLeaf(current)) {
                            res = null;
                        } else {
                            res = current.getLeft() != 0 ? current.getLeft() : current.getRight();
                        }
                    }
                }
            }

        }
        return res;
    }

    public boolean isLeaf(NodeAvl<T> current) {
        return current.getLeft() == null && current.getRight() == null;
    }

    public void inOrden() {
        if (isEmpty()) {
            System.out.println("El Arbol esta vacio......");
        } else {
            inOrden(this.root);
            System.out.println();
        }
    }
}

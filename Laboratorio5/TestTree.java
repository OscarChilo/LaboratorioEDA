package Laboratorio5;

//import Laboratorio4.ejercicio2.ExceptionNoFound;
//import myExceptions.ExceptionNoFound;
public class TestTree {
    public static void main(String[] args) throws ExceptionNoFound {
        TreeAvl<Integer> n = new TreeAvl<Integer>();

        n.insert(30);
        n.inOrden();
        n.insert(40);
        n.inOrden();
        System.out.println("root: " + n.getRoot());
        n.insert(50);
        n.inOrden();
        System.out.println("root: " + n.getRoot());
        n.insert(60);
        n.inOrden();
        n.insert(70);
        n.inOrden();
    }
}

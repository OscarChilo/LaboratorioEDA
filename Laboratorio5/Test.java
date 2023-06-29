import Laboratorio4.ejercicio2.ExceptionNoFound;

public class Test {
    public static void main(String[] args) throws ExceptionNoFound {
        TreeAvl<Integer> n = new TreeAvl<Integer>();

        n.insert(20);
        n.inOrden();
        n.insert(30);
        n.inOrden();
        System.out.println("root: " + b.getRoot());
    }
}

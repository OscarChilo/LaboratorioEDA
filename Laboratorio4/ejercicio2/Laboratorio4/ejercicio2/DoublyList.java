package Laboratorio4.ejercicio2;

public interface DoublyList <T>{
    void insertFirst(T obj);
    void insertLast(T obj);
    T removeFirst() throws ExceptionNoFound;
    T removeLast() throws ExceptionNoFound;
    NodeDoble<T> getFirst() throws ExceptionNoFound;
    NodeDoble<T> getLast() throws ExceptionNoFound;
    boolean isEmpty();
}

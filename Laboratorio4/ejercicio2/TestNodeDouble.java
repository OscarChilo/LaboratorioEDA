package Laboratorio4.ejercicio2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import com.panayotis.gnuplot.JavaPlot;


public class TestNodeDouble {
    public static void main(String[] args)throws IOException, ExceptionNoFound {
        int tamaño;
        Scanner scan=new Scanner(System.in);

        System.out.println("Ingresa el tamaño del ultimo arreglo: ");
        tamaño=scan.nextInt();

        ArrayList<DoublyLinkedList> cases =new ArrayList<DoublyLinkedList>(tamaño);
        String dataInsertion="insertion.txt";
        PrintWriter es=new PrintWriter(dataInsertion);

        for (int n = 0; n<=tamaño; n++) {
            DoublyLinkedList temp=new DoublyLinkedList<>();
            generateWorseCase(n,temp);
            cases.add(temp);
        }
        Iterator<DoublyLinkedList> pointer=cases.iterator();
        int i=0;
        while (pointer.hasNext()) {
            es.println(String.valueOf(insertionSort(pointer.next())));
            i++;
        }

        es.close();
        JavaPlot p=new JavaPlot();
        p.addPlot("\"./insertion.txt\"with lines");
        p.plot();
    }

    private static void generateWorseCase(int n, DoublyLinkedList listaNodos) {
        int[] list=new int[n];
        for (int i = 0; i < n; i++) {
            list[i]=n-i;
        }
        for (int i = 0; i < list.length; i++) {
            listaNodos.insertLast(list[i]);
        }
    }

    private static long insertionSort(DoublyLinkedList lista) {
        long nano_startTime=System.nanoTime();
        try {
            int key;
            int i;
            NodeDoble temp=lista.getFirst().getNextNode();
            for (int j = 0; j < lista.getSize(); j++) {
                key=(int)temp.getNode();

                i=j-1;
                NodeDoble tempcopy=temp;
                while (i>-1 && (int)tempcopy.getPreviousNode().getNode()>key) {
                    NodeDoble antes =tempcopy.getPreviousNode();
                    tempcopy.setNode(antes.getNode());
                    i=i-1;
                    tempcopy=tempcopy.getPreviousNode();
                }
                tempcopy.setNode(key);
                temp=temp.getNextNode();
            }
        } catch (Exception err) {
            // TODO: handle exception
            System.out.println(err);
        }
        long nano_endTime=System.nanoTime();
        return nano_endTime-nano_startTime;
    }
}

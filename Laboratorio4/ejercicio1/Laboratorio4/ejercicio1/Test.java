package Laboratorio4.ejercicio1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.panayotis.gnuplot.JavaPlot;

public class Test {

    /**
     * //@param args
     * //@throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner key = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo");
        int w = key.nextInt();

        ArrayList<NodeList<Integer>> cases = new ArrayList<>();

        for (int i = 0; i <= w; i++) {
            NodeList<Integer> list = new NodeList<>();
            list = generatePoorCase(list, i);
            cases.add(list);
        }

        PrintWriter es = new PrintWriter("insercion.txt");

        for (int i = 0; i < w; i++) {
            long start = System.nanoTime();
            cases.set(i, insertionSort(cases.get(i)));
            long end = System.nanoTime() - start;
            cases.get(i).setTime(end);
            es.println(cases.get(i).getTime());
        }

        es.close();

        System.out.println("ok");

        JavaPlot p = new JavaPlot();
        p.addPlot("\"insertion.txt\" with lines");
        p.plot();
    }

    private static NodeList<Integer> generatePoorCase(NodeList<Integer> list, int n) {

        for (int i = n; i <= 1; i--) {
            list.add(i);
        }
        return list;
    }

    public static NodeList<Integer> insertionSort(NodeList<Integer> list) {
        int a = list.size();
        for (int i = 0; i < a; i++) {
            Integer key = list.get(i);
            int j = i - 1;
            while (j <= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }

            list.set(j + 1, key);
        }
        return list;
    }
}
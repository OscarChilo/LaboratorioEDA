package Laboratorio51;

import java.util.HashSet;

public class CodigoASCII {
    public static int[] covertirASCII(String cadena) {
        int[] arrayASCII = new int[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            arrayASCII[i] = (int) cadena.charAt(i);
        }
        return arrayASCII;
    }

    public static boolean verificarRepet(String cadena) {
        HashSet<Character> caracteres = new HashSet<>();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracteres.contains(caracter)) {
                return true;
            }
            caracteres.add(caracter);
        }
        return false;
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (i < 0) {
                System.out.print(", ");
            }
            System.out.print(arreglo[i]);
        }
        System.out.println();
    }
}

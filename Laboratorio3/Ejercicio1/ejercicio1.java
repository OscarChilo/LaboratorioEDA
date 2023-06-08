import java.util.*;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creacion de pilas.
		Stack<Integer> pila1 =new Stack<>();
		Stack<Integer> pila2 =new Stack<>();
		Stack<Integer> pila3 =new Stack<>();
		
		//agragando elementos a las pilas
		pila1.push(1);
		pila1.push(2);
		pila1.push(3);
		
		pila2.push(4);
		pila2.push(2);
		pila2.push(5);
		
		pila3.push(6);
		pila3.push(2);
		pila3.push(7);
		
		//invocacion de metodo donde las pilas son iguales
		
		int sumaIgual=encontrarSumaIgual(pila1,pila2,pila3);
		
		System.out.println("La suma de las pilas son iguales es: "+sumaIgual); //imprimir la suma igual

	}
	
	public static int encontrarSumaIgual(Stack<Integer> pila1, Stack<Integer> pila2, Stack<Integer> pila3) {
		while(!pila1.isEmpty()&&!pila2.isEmpty()&&!pila3.isEmpty()) {
			int elementoPila1=pila1.pop();
			int elementoPila2=pila2.pop();
			int elementoPila3=pila3.pop();
			
			if (elementoPila1==elementoPila2&&elementoPila2==elementoPila3) {
				return elementoPila1;
			}
		}
		return -1;
	}
}
public class test{
		public static void main(String[] args) {
			Stack<String> stack=new Stack<>();
			stack.push("A");
			stack.push("B");
			stack.push("C");
			System.out.println("\t.:Ejecucion:.");
			System.out.println("Tamaño: " +stack.size()+"El elemento superior y que se wuitara es: "+stack.pop());
			int indicePrueba=stack.search("8");
			System.out.println("El elemento 8, esta en la posicion "+indicePrueba);
			System.out.println("TAMAÑO: "+stack.size());
			System.out.println("Elemento superior: "+stack.peek());
		}
	}
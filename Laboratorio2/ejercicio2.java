public class ejercicio2 {
    public static ArrayList<Integer> A= new ArrayList<Integer>();
	public static ArrayList<Integer> Aiz= new ArrayList<Integer>();
	public static int d =0;
	
	public static ArrayList<Integer> crearMatriz (ArrayList<Integer>matriz){
		int length=(int)(Math.random()*8+3);
		Integer aux;
		for (int i=0;i<length;i++) {
			aux=(int)(Math.random()*10+1);
			matriz.add(aux);
		}
		return matriz;
	}
	public static ArrayList<Integer> rotarIzquierdaArray(ArrayList<Integer> A){
		int aux=d;
		for(int i=aux;i<A.size();i++) {
			Aiz.add(A.get(aux));
			aux++;
		}
		for (int z=0;z<d;z++) {
			Aiz.add(A.get(z));
		}
		return Aiz;
	}
	
	public static void mostrarMatriz(ArrayList<Integer>matriz) {
		for (int i=0;i<matriz.size();i++) {
			System.out.print(matriz.get(i)+" ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		crearMatriz(A);
		System.out.print("La matriz es: \n A=[");
		mostrarMatriz(A);
		System.out.print("Introdusca un numero menor a "+A.size()+": ");
		d=scan.nextInt();
		Aiz=rotarIzquierdaArray(A);
		System.out.print("la matriz ivertida es: \n Aiz =[");
		mostrarMatriz(Aiz);
	}
}
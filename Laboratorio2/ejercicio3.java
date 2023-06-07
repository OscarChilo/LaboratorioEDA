public class ejercicio3{
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Ingresa la base del triangulo a mostrar: ");
		int base =scan.nextInt();
		trianguloRecursivo(base);
	}
	public static void trianguloRecursivo(int b) {
		if(b>0) {
			trianguloRecursivo(b-1);
			for(int i=0;i<b;i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
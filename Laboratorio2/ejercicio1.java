public class ejercicio1{

    public static void main(String[] args){
        int array[]={1,2,3};
        int invertido[]=new int[array.lenght];

        for(int i=invertido.lenght-1, j=0; i>=0;i--, j++){
            invertido[i]=array[j];
        }
        for(int i=0;i<invertido.lenght;i++){
            System.out.println(invertido[i]);
        }
    }
}
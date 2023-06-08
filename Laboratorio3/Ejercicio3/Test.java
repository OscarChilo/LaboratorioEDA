package ejercicio3;

public class Test {
	
	public static void main(String[] args) {
		
		Queue<Integer> myQueue=new Queue<>();
		
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.enQueue(4);
		myQueue.enQueue(5);
		
		System.out.println(myQueue);
		
		System.out.println(myQueue.getFirst());
		System.out.println(myQueue.deQueue());
		
		System.out.println(myQueue.getFirst());
		System.out.println(myQueue.isEmpty());
		
		System.out.println(myQueue.search(2));
	}

}

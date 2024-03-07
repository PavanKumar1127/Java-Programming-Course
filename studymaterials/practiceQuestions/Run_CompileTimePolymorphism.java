package practiceQuestions;

/**
 * Compile-time polymorphism can be achieved by method overloading in java. When
 * different functions in a class have the same name but different signatures,
 * it’s called method overloading
 * 
 */

/**
 * Run-time Polymorphism occurs when the compiler is not able to determine
 * whether it’s superclass method or sub-class method it’s called run-time
 * polymorphism. The run-time polymorphism is achieved by method overriding.
 */
public class Run_CompileTimePolymorphism {
	
}

/**
 * public class Car{ 
	
	public void speed() { 
	} 
	
	public void speed(String accelerator) { 
	} 
	
	public int speed(String accelerator, int speedUp) { 
		return carSpeed; 
	} 
}
*/


/**
 * import java.util.Random; 

class DeliveryBoy { 

	public void deliver() { 
		System.out.println("Delivering Item"); 
	} 

	public static void main(String[] args) { 
		DeliveryBoy deliveryBoy = getDeliveryBoy(); 
		deliveryBoy.deliver(); 
	} 

	private static DeliveryBoy getDeliveryBoy() { 
		Random random = new Random(); 
		int number = random.nextInt(5); 
		return number % 2 == 0 ? new Postman() : new FoodDeliveryBoy(); 
	} 
} 

class Postman extends DeliveryBoy { 
	@Override
	public void deliver() { 
		System.out.println("Delivering Letters"); 
	} 
} 

class FoodDeliveryBoy extends DeliveryBoy { 
	@Override
	public void deliver() { 
		System.out.println("Delivering Food"); 
	} 
}

 */ 

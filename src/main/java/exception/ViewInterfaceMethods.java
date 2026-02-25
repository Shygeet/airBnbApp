package exception;

	


	// Interface A
	interface Payment {

	    // 1️⃣ Abstract method
	    void pay(int amount);

	    // 2️⃣ Default method
	    default void receipt() {
	        System.out.println("Payment receipt default generated");
	    }

	    // 3️⃣ Static method
	    static void info() {
	        System.out.println("Payment interface static method");
	    }
	}

	// Interface B
	interface Refund {

	    // Abstract method
	    void pay(int amount);

	    // Default method (same name → ambiguity)
	    default void receipt() {
	        System.out.println("Refund receipt generated");
	    }
	    static void info() {
	        System.out.println("Refund interface static method");
	    }
	}

	// Implementing class
	class OnlinePayment implements Payment, Refund {

	    // Implement abstract methods
	    @Override
	    public void pay(int amount) {
	        System.out.println("Paid amount abstract method ambiguity rsolved by implementing the method: " + amount);
	    }

		/*
		 * @Override public void refund(int amount) {
		 * System.out.println("Refunded amount: " + amount); }
		 */

	    // 4️⃣ Resolve default method ambiguity
	    @Override
	    public void receipt() {
	        Payment.super.receipt();  // or Refund.super.receipt();
	        System.out.println("OnlinePayment receipt resolved using super call of duplicate default method");
	    }
	}

	// Main class
	public class ViewInterfaceMethods {

	    public static void main(String[] args) {

	        OnlinePayment op = new OnlinePayment();

	        // Abstract methods
	        op.pay(1000);
	        //op.refund(200);

	        // Default method
	        op.receipt();

	        // Static method (called using interface name)
	        Payment.info();
	        Refund.info();
	        
	        
	        // Abstract method ambiguity is resolved by providing a single implementation in the implementing class.
	       // Static methods in interfaces do not cause ambiguity because they are accessed using the interface name and are not inherited.
	    }
	


}

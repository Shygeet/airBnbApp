package exception;

@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

public class ViewCustomFunctionalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Calculator add = (a, b) -> a + b;
	        Calculator multiply = (a, b) -> a * b;

	        System.out.println(add.operate(10, 5));
	        System.out.println(multiply.operate(10, 5));

	}

}

import java.util.Scanner;

public class DoubleFactorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result = 1;
		
		if (n < 0) {
			System.out.println( "Undefined");
		}
		else if (n > 18) {
			System.out.println("Too large");
		}
		else {
			while (n >= 2 && n%2 == 0) {
				result *= n;
				n-=2;
			}
			
			while (n >= 1 && n%2 != 0) {
				result *= n;
				n-=2;
			}
			System.out.println( result);
		}
		
		
		scanner.close();
	}
}

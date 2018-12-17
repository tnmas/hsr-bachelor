import java.util.Scanner;

public class PrimeTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		boolean right = false;
		right = primeTester(num, right);
		if (!right) {
			System.out.println("Prime");
		}
		else {
			System.out.println("Not Prime");
		}
		
		scanner.close();
		
	}

	private static boolean primeTester(int num, boolean right) {
		for (int i = 2; i <= num/2; ++i) {
			if (num%i == 0) {
				right = true;
				break;
			}
		}
		return right;
	}
}

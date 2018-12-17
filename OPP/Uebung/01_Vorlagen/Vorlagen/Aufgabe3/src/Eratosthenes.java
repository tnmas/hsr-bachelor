import java.util.Scanner;

public class Eratosthenes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int n = 0, j = 0;
		int arr[] = new int[30];
		primeChecker(j, n, arr, num);
		for (int x : arr) {
			System.out.print(x + " ");
		}
			
		scanner.close();
	}
	private static void primeChecker(int k, int m, int[] array, int num) {
		for (int i = 1; i <= num; i++) {
			int counter = 0;
			for (m = i; m >= 1; m--) {
				if (i%m == 0) {
					counter++;
				}
			}
			if (counter == 2) {
				array[k] = i;
				k++;
			}
		}
	}
}

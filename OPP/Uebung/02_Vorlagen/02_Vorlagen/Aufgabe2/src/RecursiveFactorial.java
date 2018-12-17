public class RecursiveFactorial {
	public static void main(String[] args) {
		int number = 10;
		System.out.println(doubleFactorial(number));
		
	}
	public static int doubleFactorial(int num) {
		 if(num <= 0) {
			return 1;
		}
		 else {
			return num * doubleFactorial(num - 2);
		}
	}
}

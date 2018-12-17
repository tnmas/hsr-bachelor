public class ArrayFunctions {
	public static void main(String[] args) {
		int[] arrayToRevert = {1, 2, 3};
		int[] notsortedArray = {-1, 0, 7};
		
		revertArray(arrayToRevert);
		System.out.println("Ascending = " + ascendinglySorted(notsortedArray)); 
		System.out.println("Descending = " + descendinglySorted(notsortedArray));
		printArray(notsortedArray);
	}
	public static void revertArray(int[] array) {
		for (int index = array.length - 1; index >= 0; index--) {
			System.out.println(array[index]);
		}
	}
	public static boolean ascendinglySorted(int[] array) {
		int previous = array[0];
			for (int index = 0; index < array.length; index++) {
				if (array[index] < previous) {
					return false;
				}
				previous = array[index];
			}
		return true;
	}
	public static boolean descendinglySorted(int[] array) {
		int previous = array[0];
		for (int index = 0; index < array.length; index++) {
			if (array[index] > previous) {
				return false;
			}
			previous = array[index];
		}
	return true;
		
	}
	public static void printArray(int[] array) {
		for (int index = 0; index < array.length; index++) {
			System.out.println(array[index]);
		}
	}
}

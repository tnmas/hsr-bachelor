import java.util.Random;

public class RecursiveSum {
	public static void main(String[] args) {
		int[] series = randomSeries(1000);
		// Compute the sum of the series recursively
		System.out.println(sumArray(series, series.length - 1));
	}
	static int[] randomSeries(int amount) {
		Random random = new Random(4711);
		int[] series = new int[amount];
		for (int index = 0; index < amount; index++) {
			series[index] = random.nextInt(10);
		}
		return series;
	}
	static int sumArray(int[] array, int arrayLength) {
		if (arrayLength == 0) {
			return array[arrayLength];
		}
		else {
			return array[arrayLength] + sumArray(array, arrayLength - 1);
		}
	}
}

import java.util.Random;

public class Statistics {
	public static void main(String[] args) {
		double[] series = randomSeries(10000);
		// implement statistical analysis
		double min = series[0],  max = series[0];
		double sum = 0;
		double ave = 0;
		double var = 0;
		for (double d : series) {
			if (d <= min) {
				min = d;
			}
			if (d >= max) {
				max = d;
			}
			sum += d;
		}
		ave = sum/10000;
		for (double s : series) {
			var += Math.pow((s - ave), 2)/10000;
		}
		
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		System.out.println("Sum: " + sum);
		System.out.println("Ave: " + ave);
		System.out.println(Math.sqrt(var));
	}
	
	static double[] randomSeries(int amount) {
		double[] series = new double[amount];
		Random random = new Random(4711);
		for (int index = 0; index < amount; index++) {
			series[index] = random.nextDouble();
		}
		return series;
	}
}


public class ImageProcessing {
	static int[][] invert(int[][] pixels) {
		// implement image inversion (negate all pixels)
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels.length; j++) {
				pixels[i][j] = -pixels[i][j];
			}
		}
		return pixels;
	}
	
	static int[][] rotate(int[][] pixels) {
		// implement image rotation (90 degrees to the right)
		for (int i = 0; i < pixels.length; i++) {
			for (int j = i+1; j < pixels.length; j++) {
				int temp = pixels[i][j];
				pixels[i][j] = pixels[j][i];
				pixels[j][i] = temp;
				
			}
		}
		return pixels;
	}
	
	static int[][] mirror(int[][] pixels) {
		// implement image mirroring (horizontal, left <-> right)
		for (int i = 0; i < pixels.length; i++) {
			int[] row = pixels[i];
			for (int j = 0; j < row.length/2 ; j++) {
				int temp = row[j];
				row[j] = pixels[i][row.length - j - 1];
				row[row.length - j -1] = temp;
				
			}
		}
		
		return pixels;
	}
	
	static int[][] gray(int[][] pixels) {
		// optional task (advanced)
		
		return pixels;
	}
}

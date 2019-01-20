package compareAndLambda;

public class AgeComparator  {

	public static void main(String[] args) {
		
		//String[] places = new String[] {"Anna", "Hans", "Paul", "Susi", null,"Claudia", null, "Pia"};
		
		//System.out.println(allPlacesReserved(places));
		//rotateArray(places);
//		for (int i = 0; i < places.length; i++) {
//			System.out.println(places[i]);
//		}
		//freePlaceChecker(places, 2);
		
//		int a = 1;
//		long b = 2;
//		float c = 3;
//		boolean d = true;
//		String s = "";
//		
//		//var x = a + b * c;
		var e = -3.0;
		System.out.println();
//		System.out.println(s + a == a + s);
		
	}
	public static boolean allPlacesReserved(String[] array) {
		for (String place : array) {
			if(place == null) {
				return false;
			}
		}
		return true;
		}
	
	public static void rotateArray(String[] array) {
		String temp = array[array.length - 1];
		for(int i = array.length-1; i > 0; i--) {
			array[i] = array[i--];
		}
		array[0] = temp;
	}
	
	public static void freePlaceChecker(String[] array, int x) {
		int count = 0, temp = 0;
		boolean flag = true;
		for (int i = 0; i < array.length; i++) {
			if (x > 1) {
				if (count <= x && array[i] == null && array[i+1] == null ) {
					count+=2;
					temp = i + 1;
					if(x > count) {
						flag = false;
					}
				}
			}
			if (x == 1) {
				if(array[i] == null) {
					System.out.println(i);
					flag = false;
				}
			}
		}
		if (!flag) {
			System.out.println("Sorry, no places found!");
		}
		if(count == x || count == x+2) {
			System.out.println("From " + (temp-x+1) + " to " + (temp));
		}
	}
}

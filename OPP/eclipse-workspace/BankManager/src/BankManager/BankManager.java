package BankManager;


public class BankManager {

	public static void main(String[] args) {
//		SavingsAccount savingAccount = new SavingsAccount();
//		CheckingAccount checkingAccount = new CheckingAccount();
//		CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit();
//		
//		savingAccount.account = 100.0;
//		savingAccount.balance = 200.0;
//		checkingAccount.account = 10.0;
//		checkingAccount.balance = 20.0;
//		certificateOfDeposit.account = 30.0;
//		certificateOfDeposit.balance = 40.0;
		int[] a = {2, 3, 5, 8, 5, 9, 7};
	    int[] b = sortArray(a);
	    for (int i : b) {
			System.out.println(i);
		}
	    sortArray(a);
//	   int b = unsortedIndex(a);
//	   System.out.println(b);
	}
	
	
	public static int[] sortArray(int[] array) {
		int temp;
		int c = 0;
		for (int i = 0; i< array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					c++;
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					System.out.println(c + " : " + i + " " + j);
				}
				
			}
		}
		return array;

	}
	static int unsortedIndex(int[] array) {
		 for (int i = 0; i < array.length - 1; i++) {
		 if (array[i] > array[i + 1]) {
		if (i > 0 && array[i - 1] <= array[i + 1]) {
		 return i;
		} else if (i < array.length - 2 && array[i] <= array[i + 2]) {
		 return i + 1;
		} else if(i > 0) {
		 return i + 1;
		} else {
		 return i;
		}
		 }
		 }
		 throw new AssertionError("All sorted");
		}

}

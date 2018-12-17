
public class ListTest {

	public static void main(String[] args) {
		testInsertAndRemove();
		testEmptyList();
		testListEquals();
	}

	private static void testListEquals() {
		final int amount = 100;
		var list1 = createList(amount);
		var list2 = createList(amount);
		System.out.println("Equal lists? " + list1.equals(list2));
		System.out.println("Commutative equals? " + list2.equals(list1));
		System.out.println("Reflexive equals? " + list2.equals(list1));
		System.out.println("Correct hash code? " + (list1.hashCode() == list2.hashCode()));
		list1.remove("Test" + (amount - 1));
		System.out.println("Correct unequals? " + !list1.equals(list2));
		list1.add("ABC");
		list1.remove("ABC");
		list2.remove("Test" + (amount - 1));
		System.out.println("Correct equals after modification? " + list1.equals(list2));
		System.out.println("Correct hash code after modification? " + (list1.hashCode() == list2.hashCode()));
	}
	
	private static List createList(int amount) {
		var list = new List();
		for (int i = 0; i < amount; i++) {
			list.add("Test" + i);
		}
		return list;
	}
	

	private static void testEmptyList() {
		var list = new List();
		System.out.println("correct empty size? " + (list.size() == 0));
		System.out.println("null on invalid index? " + (list.get(0) == null));
		System.out.println("nothing contained in empty list? " + !list.contains(null));
	}

	private static void testInsertAndRemove() {
		final int amount = 1000;
		var list = createList(amount);
		System.out.println("list size matches? " + (list.size() == amount));
		for (int i = 0; i < amount; i++) {
			if (!list.get(i).equals("Test" + i)) {
				System.out.println("!!Incorrect list entry!!");
			}
			if (!list.contains("Test" + i)) {
				System.out.println("!!Incorrect list contains!!");
			}
		}
		for (int i = 0; i < amount; i++) {
			list.remove("Test" + i);
			for (int k = 0; k < amount - i - 1; k++) {
				if (!list.get(k).equals("Test" + (i + k + 1))) {
					System.out.println("!!Incorrect list entry after remove!!" + list.get(k) + ("Test" + (i + k + 1)));
				}
			}
		}
		System.out.println("correct final size? " + (list.size() == 0));
	}

}

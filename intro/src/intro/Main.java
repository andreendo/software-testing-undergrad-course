package intro;

public class Main {

	public static void main(String[] args) {
		// test 1
		NumFinder numFinder = new NumFinder();
		int[] a = { 1, 10 };
		numFinder.find(a);
		System.out.println("maior: " + numFinder.getLargest());
		System.out.println("menor: " + numFinder.getSmallest());
		
		// test 2		
	}
}
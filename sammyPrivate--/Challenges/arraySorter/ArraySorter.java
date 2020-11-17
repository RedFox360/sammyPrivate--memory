package arraySorter;

import java.util.ArrayList;

public class ArraySorter {
	public static void sort(int[] array) {
		boolean something = false;
		ArrayList<Integer> Array2 = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			Array2.add(array[i]);
		}
		for (int j = 0; j < array.length; j++) {
			array[j] = 0;
		}
		int leastNumber = 0;
		int index1 = Array2.get(0);
		int index2 = Array2.get(1);
		if (index1 > index2) {
			leastNumber = index2;
		} else {
			leastNumber = index1;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (leastNumber > Array2.get(j)) {
					leastNumber = Array2.get(j);
					array[i] = leastNumber;
					Array2.remove(j);
					leastNumber = 0;
					something = true;
				}
			}
			
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}

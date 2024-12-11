import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main (String[] args) {	
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		File file = new File("day1List.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				// reads two ints per iteration
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				list1.add(a);
				list2.add(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		// sort lists
		for (int i = 0; i < list1.size(); i++) {
			for (int j = i+1; j < list1.size(); j++) {
				if (list1.get(i) > list1.get(j)) {
					int temp = list1.get(i);
					list1.set(i, list1.get(j));
					list1.set(j, temp);
				}
			}
		}
		for (int i = 0; i < list2.size(); i++) {
			for (int j = i+1; j < list2.size(); j++) {
				if (list2.get(i) > list2.get(j)) {
					int temp = list2.get(i);
					list2.set(i, list2.get(j));
					list2.set(j, temp);
				}
			}
		}
		
		// find distance
		int totalDistance = 0;
		for (int i = 0; i < list1.size(); i++) {
			totalDistance += Math.abs(list1.get(i) - list2.get(i));
		}
		System.out.println("totalDistance = " + totalDistance);

		//find score
		int score = 0;
		for (int i = 0; i < list1.size(); i++) {
			int count = 0;
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i).equals(list2.get(j))) {
					count++;
				}
			}
			score += list1.get(i)*count;
		}
		System.out.println("score = " + score);
	}
} 

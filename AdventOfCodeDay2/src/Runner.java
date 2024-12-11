import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	
	public static boolean increasing(String[] list) {
		for (int i = 0; i < list.length-1; i++) {
			
			// check if it doesn't meet requirement, exit right away
			int a = Integer.valueOf(list[i]);
			int b = Integer.valueOf(list[i+1]);
			
			int distance = Math.abs(a-b);
			
			if (a > b) {
				return false;
			} else if (distance < 1 || distance > 3) {
				return false;
			} 
		}
		return true;
	}
	public static boolean decreasing(String[] list) {
		for (int i = 0; i < list.length-1; i++) {
			
			// check if it doesn't meet requirement, exit right away
			int a = Integer.valueOf(list[i]);
			int b = Integer.valueOf(list[i+1]);
			
			int distance = Math.abs(a-b);
			
			if (a < b) {
				return false;
			} else if (distance < 1 || distance > 3) {
				return false;
			} 
		}
		return true;
	}

	public static void main (String[] args) {			
		int countSafe = 0;
		
		File file = new File("day2List.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				String[] columns = row.split(" ");
				
				// increase count
				if (increasing(columns) || decreasing(columns)) {
					countSafe++;
				} else {
					for (int i = 0; i < columns.length; i++) {
						// create list2
						ArrayList<String> list2 = new ArrayList<String>();
						String[] list3 = new String[columns.length-1]; 
						
						for (int j = 0; j < columns.length; j++) {
							list2.add(columns[j]);
						}
						list2.remove(i);
						
						// create list 3
						for (int k = 0; k < columns.length-1; k++) {
							list3[k] = list2.get(k);
						}
						
						// increase count
						if (increasing(list3) || decreasing(list3)) {
							countSafe++;
							break;
						}	
					}
				}
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("countSafe = " + countSafe);
	}
} 

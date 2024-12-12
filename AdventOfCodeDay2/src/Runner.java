import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	
	static public String extractMul(String line, int startIndex) {
        int start = line.indexOf("mul(", startIndex); // Find "mul(" starting from index
        if (start == -1) {
            return ""; // No more "mul(" found
        }
        int end = line.indexOf(")", start); // Find the closing parenthesis
        if (end == -1) {
            return ""; // Malformed "mul(x,y)" (missing ')')
        }
        return line.substring(start, end + 1); // Return the full "mul(x,y)"
    }
	
	 // Converts "mul(x,y)" into the product of x and y
    static public int stringToProduct(String str) {
        if (str.isEmpty()) return 0; // Handle empty or invalid strings

        // Split into parts: mul(x, y)
        String[] parts = str.substring(4, str.length() - 1).split(","); // Remove "mul(" and ")"
        int x = Integer.parseInt(parts[0]); // Parse x
        int y = Integer.parseInt(parts[1]); // Parse y
        return x * y;
    }

	
//	public static void main (String[] args) {			
//		int sum = 0;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		File file = new File("day3List.txt");
//		try {
//			Scanner scanner = new Scanner(file);
//			
//			while (scanner.hasNextLine()) {
//				String line = scanner.next(); 
//				for (int i = 0; i < line.length()-12; i++) {
//					String str = extractMul(line.substring(i,i+12));
//					list.add(stringToProduct(str));
//					
//				}
//			}
//			for (int i = 0; i < list.size(); i++) {
//				sum += list.get(i);
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("sum = " + sum);
//	}
//} 
    public static void main(String[] args) {
        int sum = 0;

        File file = new File("day3List.txt");
        System.out.println("File exists: " + file.exists());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        try (Scanner scanner = new Scanner(file)) { // line 65
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read entire line
                int index = 0;

                // Extract and process all "mul(x,y)" in the current line
                while (index < line.length()) {
                    String mulString = extractMul(line, index);
                    if (mulString.isEmpty()) {
                        break; // No more "mul(x,y)" found in this line
                    }
                    sum += stringToProduct(mulString);
                    index = line.indexOf("mul(", index) + 4; // Move past the current "mul("
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Total Sum = " + sum);
    }
}
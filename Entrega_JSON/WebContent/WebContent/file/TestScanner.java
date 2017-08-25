package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestScanner {
	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		// open the Scanner
		Scanner scanner = new Scanner(new File("sample3.data"));
		// get integer
		int i = scanner.nextInt();
		// get integer
		long l = scanner.nextLong();
		// get float
		float f = scanner.nextFloat();
		// get double
		double d = scanner.nextDouble();
		// get char
		char c = scanner.next().charAt(0);
		// get boolean
		boolean b = scanner.nextBoolean();
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c);
		System.out.println(b);
		// input done, so close the scanner
		scanner.close();
	}
}

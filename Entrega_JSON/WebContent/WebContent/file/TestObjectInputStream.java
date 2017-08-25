package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectInputStream {
	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		// set up file and stream
		File inFile = new File("objects.dat");
		FileInputStream inFileStream = new FileInputStream(inFile);
		ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
		// read the Person objects from a file
		Person person;
		for (int i = 0; i < 10; i++) {
			person = (Person) inObjectStream.readObject();
			System.out.println(person.getName() + "      " + person.getAge()
					+ "     " + person.getGender());
		}
		// input done, so close the stream
		inObjectStream.close();
	}
}

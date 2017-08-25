package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectOutputStream {
	public static void main(String[] args) throws IOException {
		// set up the streams
		File outFile = new File("objects.dat");
		FileOutputStream outFileStream = new FileOutputStream(outFile);
		ObjectOutputStream outObjectStream = new ObjectOutputStream(
				outFileStream);
		// write serializable Person objects one at a time
		Person person;
		for (int i = 0; i < 10; i++) {
			person = new Person("Mr. Espresso" + i, 20 + i, 'M');
			outObjectStream.writeObject(person);
		}
		// output done, so close the stream
		outObjectStream.close();
	}
}

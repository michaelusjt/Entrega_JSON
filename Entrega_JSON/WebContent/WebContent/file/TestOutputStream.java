package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
	public static void main(String[] args) throws IOException {
		// set up file and stream
		File outFile = new File("sample1.data");
		FileOutputStream outStream = new FileOutputStream(outFile);
		// data to output
		byte[] byteArray = { 10, 20, 30, 40, 50, 60, 70, 80 }; // write data to
																// the stream
		outStream.write(byteArray);
		// output done, so close the stream
		outStream.close();
	}
}

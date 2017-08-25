package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
	public static void main(String[] args) throws IOException {
		// set up file and stream
		File outFile = new File("sample3.data");
		FileOutputStream outFileStream = new FileOutputStream(outFile);
		PrintWriter outStream = new PrintWriter(outFileStream);
		// write values of primitive data types to the stream
		outStream.println(987654321);
		outStream.println(11111111L);
		outStream.println(22222222F);
		outStream.println(33333333D);
		outStream.println('A');
		outStream.println(true);
		// output done, so close the stream
		outStream.close();
	}
}

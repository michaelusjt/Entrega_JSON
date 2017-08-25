package file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataOutputStream {
	public static void main(String[] args) throws IOException {
		// set up the streams
		File outFile = new File("sample2.data");
		FileOutputStream outFileStream = new FileOutputStream(outFile);
		DataOutputStream outDataStream = new DataOutputStream(outFileStream);
		// write values of primitive data types to the stream
		outDataStream.writeInt(987654321);
		outDataStream.writeLong(11111111L);
		outDataStream.writeFloat(22222222F);
		outDataStream.writeDouble(3333333D);
		outDataStream.writeChar('A');
		outDataStream.writeBoolean(true);
		// output done, so close the stream
		outDataStream.close();
	}
}

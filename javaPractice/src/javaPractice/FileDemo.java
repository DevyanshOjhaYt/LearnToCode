package javaPractice;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileDemo {

	public static void main(String[] args) throws Exception {

		FileOutputStream fos = new FileOutputStream("demo.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("Hello Demo from Dev");
	}

}

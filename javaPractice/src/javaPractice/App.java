package javaPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class App {

	public static void main(String[] args) throws Exception {
		Properties p=new Properties();
//		OutputStream os=new FileOutputStream("dataConfig.properties");
//		
//		p.setProperty("url", "http");
//		p.store(os, null);
		
		InputStream is=new FileInputStream("dataConfig.properties");
		p.load(is);
		System.out.println(p.getProperty("url"));
		
		p.list(System.out); // will print all on console
	}

}

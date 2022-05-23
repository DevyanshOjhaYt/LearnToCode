package javaPractice;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeXML {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Student s1 = new Student();
		s1.setRollNo(101);
		s1.setSname("Dev");

		Student s2 = new Student();
		s2.setRollNo(102);
		s2.setSname("Ayush");

		List<Student> s = new ArrayList<>();
		s.add(s1);
		s.add(s2);

		College c = new College();
		c.setStudents(s);

		try {
			XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("myCollege.xml")));
			x.writeObject(c);
			x.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

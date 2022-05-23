package multithreadingTest;

public class Demo {

	public static void main(String[] args) {

		System.out.println("Hello World Welcome");
		
		ChildDemo obj1=new ChildDemo();
		BabyChildDemo obj2=new BabyChildDemo();
		
		obj1.start();
		obj2.start();
	}

}



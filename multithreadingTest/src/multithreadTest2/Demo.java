package multithreadTest2;

public class Demo {

	public static void main(String[] args) {

		System.out.println("Hello World Welcome");
		
		ChildDemo obj1=new ChildDemo();
		BabyChildDemo obj2=new BabyChildDemo();
		
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		
		t1.start();
		t2.start();
	}

}



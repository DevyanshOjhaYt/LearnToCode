package multithreadTest2;

public class ChildDemo implements Runnable{
	
	@Override
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			}catch(Exception e) {};
		}
	}
	
}

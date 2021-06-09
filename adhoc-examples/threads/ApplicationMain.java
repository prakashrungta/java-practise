package javaThreads;

public class ApplicationMain
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread t = null;
		for (int i = 0; i < 3; i++)
		{
			t = new Thread(new VolatileFlag("PrakashThread-" + i));
			t.start();
			t.join();
		}
		System.out.println("Main thread exiting.");
	}
}

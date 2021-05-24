package javaThreads;

class VolatileFlag implements Runnable
{
	private String threadName;

	public VolatileFlag(String tName)
	{
		threadName = tName;
	}


	@Override
	public void run()
	{
		System.out.println(threadName + ": " + Thread.currentThread().getName());
	}
}

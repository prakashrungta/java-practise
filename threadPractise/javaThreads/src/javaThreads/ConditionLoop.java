package javaThreads;

public class ConditionLoop implements Runnable
{
	private boolean condition;

	synchronized void waitForCondition() throws InterruptedException
	{
		while (!condition)
		{
			System.out.println("Thread " + Thread.currentThread().getName() + " I am waiting ");
			wait();
		}
	}


	synchronized void satisfyCondition()
	{
		condition = true;
		System.out.println("Thread " + Thread.currentThread().getName() + " I am satisfyCondition ");
		notifyAll();
	}


	@Override
	public void run()
	{
	}
}

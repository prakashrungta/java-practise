package javaThreads;

class Hi
{
	public static void main(String[] args)
	{
		Hi j = new Hi();
		// Calling finalize method Explicitly.
		j.finalize();
		j = null;
		// Requesting JVM to call Garbage Collector method
		System.gc();
		System.out.println("Main Completes");
	}


	// Here overriding finalize method
	@Override
	public void finalize()
	{
		System.out.println("finalize method overriden");
		System.out.println(10 / 0);
	}
}

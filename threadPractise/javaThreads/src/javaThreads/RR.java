package javaThreads;

class RR
{
	public static void main(String[] args)
	{
		RR q = new RR();
		q = null;
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

package snippet;

class SampleImpl implements ExampleInterface1, SubInterface1
{
	/* A class should implement all the methods in an interface.
	If either of method1 or method2 is commented, it would
	result in compilation error.
	*/
	//	@Override
	//	public void method2()
	//	{
	//		System.out.println("Sample Implementation for Method2");
	//	}
	@Override
	public void method1()
	{
		System.out.println("Sample Implementation for Method1");
	}


	public static void main(String args[])
	{
		SampleImpl s1 = new SampleImpl();
		s1.method1();
	}


	@Override
	public void method5()
	{
		// TODO Auto-generated method stub
	}
}

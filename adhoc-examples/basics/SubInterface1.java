package snippet;

interface SubInterface1
{
	void method1();
}


interface ExampleInterface1
{
	//By default - public abstract. No other modifier allowed
	void method1();//method1 is public and abstract
	//private void method6();//COMPILER ERROR!
	//This method, uncommented, would have given COMPILER ERROR!


	//in Java 7. Allowed from Java 8.
	void method5();
}

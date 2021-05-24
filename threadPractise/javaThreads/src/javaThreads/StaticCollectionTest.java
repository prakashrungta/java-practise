package javaThreads;

import java.util.ArrayList;
import java.util.List;

public class StaticCollectionTest
{
	public static List<Student> list = new ArrayList<>();

	public void addStudentsToList()
	{
		for (int i = 0; i < 1E7; i++)
		{
			list.add(new Student("studentName_" + i));
		}
	}


	public static void main(String[] args) throws InterruptedException
	{
		new StaticCollectionTest().addStudentsToList();
		Thread.sleep(5000);
	}
}


class Student
{
	private String name;

	public Student(String name)
	{
		this.name = name;
	}
}

package com.avaya.kafka.springbootkafkaexample.model;

public class User
{
	public User(int id, String department, String name)
	{
		super();
		this.id = id;
		this.department = department;
		this.name = name;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getDepartment()
	{
		return department;
	}


	public void setDepartment(String department)
	{
		this.department = department;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}

	private int id;

	private String department;

	private String name;
}
package snippet;

class Animal
{
	public Animal(String name, String type)
	{
		this.name = name;
		this.type = type;
	}

	String name;

	String type;

	public static void main(String[] args)
	{
		Animal animal = new Animal("Tommy", "Dog");
		System.out.println(animal);
		//com.rithus.Animal@f7e6a96
	}


	@Override
	public String toString()
	{
		return "Animal [name=" + name + ", type=" + type + "]";
	}
}

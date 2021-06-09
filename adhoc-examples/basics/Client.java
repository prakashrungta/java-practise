package snippet;

class Client
{
	private int id;

	public Client(int id)
	{
		this.id = id;
	}


	public static void main(String args[])
	{
		Client C1 = new Client(25);
		Client C2 = new Client(25);
		Client C3 = C1;
		System.out.println(C1 == C2);
		System.out.println(C1.equals(C2));
		int m = 25;
		if (m > 20)
			if (m < 20)
				System.out.println("m>20");
			else
				System.out.println("Who am I?");
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

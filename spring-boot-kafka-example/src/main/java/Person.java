import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person
{
	private Long id;

	private String name;

	private String department;

	private Integer salary;

	public Person(Long id, String name, String department, Integer salary)
	{
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}


	public Person()
	{
		super();
	}


	@Id
	@GeneratedValue
	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getDepartment()
	{
		return department;
	}


	public void setDepartment(String department)
	{
		this.department = department;
	}


	public Integer getSalary()
	{
		return salary;
	}


	public void setSalary(Integer salary)
	{
		this.salary = salary;
	}
}

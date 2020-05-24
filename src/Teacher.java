
public class Teacher {
	private String name;
	
	public Teacher(String name)
	{
		setName(name);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString() { return name; }
}

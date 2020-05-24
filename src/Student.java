
public class Student {
	private String name;
	private int course;
	
	public Student(String name, int course)
	{
		setName(name);
		setCourse(course);
	}
	
	public Student()
	{
		setName("NoName");
		setCourse(1);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setCourse(int c)
	{
		if(c < 1 || c > 4)
			course = 1;
		else
			course = c;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCourse()
	{
		return course;
	}
	
	public String toString()
	{
		return name + " " + course;
	}
	
}

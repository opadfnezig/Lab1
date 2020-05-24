
public class Department {
	private String name;
	private Student students[];
	private Teacher teachers[];
	private Group groups[];
	
	public Department()
	{
		setName("NoName");
		students = null;
		teachers = null;
		groups = null;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
}

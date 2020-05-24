
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
	
	public Department(String name)
	{
		this.name = name;
		students = null;
		teachers = null;
		groups = null;
	}
	
	public void setName(String name) { name = name; }
	public void setStudents(Student students[]) { this.students = students; }
	public void setTeachers(Teacher teachers[]) { this.teachers = teachers; }
	public void setGroups(Group groups[]) { this.groups = groups; }
	public String getName() { return name; }
	
}

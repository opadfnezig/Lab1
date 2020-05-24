
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
	
	public void setName(String name) { this.name = name; }
	public void setStudents(Student students[]) { this.students = students; }
	public void setTeachers(Teacher teachers[]) { this.teachers = teachers; }
	public void setGroups(Group groups[]) { this.groups = groups; }
	public String getName() { return name; }
	public Student[] getStudents() { return students; }
	public Teacher[] getTeachers() { return teachers; }
	public Group[] getGroups() { return groups; }
	public Student getStudentByIndex(int i) { return students[i]; }
	public Teacher getTeacherByIndex(int i) { return teachers[i]; }
	public Group getGroupByIndex(int i) { return groups[i]; }
	
	public String toString()
	{
		String str = "";
		str += "teachers: ";
		for(int i = 0;i < teachers.length;++i)
			str += "\n" + i + "	" + teachers[i].toString();
		str += "\nstudents:";
		for(int i = 0;i < students.length;++i)
			str += "\n" + i + "	" + students[i].toString();
		str += "\ngroups";
		for(int i = 0;i < groups.length;++i)
			str += "\n" + i + "	" + groups[i].toString();
		return str;
	}
}

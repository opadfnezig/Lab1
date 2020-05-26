
public class Department {
	private String name;
	private Student students[];
	private Teacher teachers[];
	private Group groups[];
	
	public Department()
	{
		setName("NoName");
		students = new Student[0];
		teachers = new Teacher[0];
		groups = new Group[0];
	}
	
	public Department(String name)
	{
		this.name = name;
		students = new Student[0];
		teachers = new Teacher[0];
		groups = new Group[0];
	}
	
	public void setName(String name) { this.name = name; }
	public void setStudents(Student students[]) { this.students = students; }
	public void setTeachers(Teacher teachers[]) { this.teachers = teachers; }
	public void setGroups(Group groups[]) { this.groups = groups; }
	
	public void addStudent(Student s) 
	{
		Student newStd[] = new Student[students.length+1];
		for(int i = 0; i < students.length; i++)
			newStd[i] = students[i];
		newStd[students.length] = s;
		students = newStd;
	}
	
	public void addTeacher(Teacher t) 
	{
		Teacher newT[] = new Teacher[teachers.length+1];
		for(int i = 0; i < teachers.length; i++)
			newT[i] = teachers[i];
		newT[teachers.length] = t;
		teachers = newT;
	}
	
	public void addGroup(Group g) 
	{
		Group newG[] = new Group[groups.length+1];
		for(int i = 0; i < groups.length; i++)
			newG[i] = groups[i];
		newG[groups.length] = g;
		groups = newG;
	}
	
	public String getName() { return name; }
	public Student[] getStudents() { return students; }
	public Teacher[] getTeachers() { return teachers; }
	public Group[] getGroups() { return groups; }
	
	public Student studentAt(int i) { return students[i]; }
	public Teacher teacherAt(int i) { return teachers[i]; }
	public Group groupAt(int i) { return groups[i]; }
	
	
	
	public boolean studentIsExist(String name)
	{
		for(int i = 0; i < students.length; i++)
			if(students[i].getName().equalsIgnoreCase(name))
				return true;
		return false;
	}
	
	public boolean teacherIsExist(String name)
	{
		for(int i = 0; i < students.length; i++)
			if(students[i].getName().equalsIgnoreCase(name))
				return true;
		return false;
	}
	
	public boolean groupIsExist(int id)
	{
		for(int i = 0; i < groups.length; i++)
			if(groups[i].getID() == id)
				return true;
		return false;
	}
	
	public String toString()
	{
		String str = "	" + name + ":\n";
		
		str += "	Teachers: ";
		for(int i = 0;i < teachers.length;++i)
			str += "\n	" + teachers[i].toString();
		if(teachers.length == 0)
			str += "\n		null";	
		str += "\n	Students:";
		for(int i = 0;i < students.length;++i)
			str += "\n	" + students[i].toString();
		if(students.length == 0)
			str += "\n		null";
		str += "\n	Groups:";
		for(int i = 0;i < groups.length;++i)
			str += "\n	" + groups[i].toString();
		if(groups.length == 0)
			str += "\n		null";
		return str;
	}
}

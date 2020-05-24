
public class Group {
	private int ID;
	private Teacher teacher;
	private Student students[];
	
	public Group(int id)
	{
		ID = id;
		teacher = null;
		students = null;
	}
	
	public void setID(int id)
	{
		ID = id;
	}
	
	public void setTeacher(Teacher t)
	{
		teacher = t;
	}
	
	public void setStudents(Student[] s)
	{
		students = s;
	}
	
	public void addStudent(Student s)
	{
		Student newStd[] = new Student[students.length+1];
		for(int i = 0; i < students.length; i++)
			newStd[i] = students[i];
		newStd[students.length] = s;
		students = newStd;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public Teacher getTeacher()
	{
		return teacher;
	}
	
	public Student studentAt(int i)
	{
		return students[i];
	}
	
	public String toString()
	{
		String str = "Group ID: " + ID + "\n";
		if(teacher != null)
			str += "Teacher: " + teacher + "\n";
		else
			str += "Teacher: " + teacher + "\n";
		str += "Students:";
		if(students != null)
			for(int i = 0; i < students.length; i++)
				str += "\n" + students[i];
		else
			str += "\n" + "null";
		return str;
	}
}

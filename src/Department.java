
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
	
	public String sortedStudents()
	{
		Student buff;
		Student[] stdBuff = new Student[students.length];
		for(int i = 0;i < stdBuff.length;++i)
			stdBuff[i] = students[i];
        for(int i = 0; i < stdBuff.length; i++)
        {
            for(int j = i; j < stdBuff.length; j++)
            {
                for(int k = 0; k < Math.max(stdBuff[i].getName().length(), stdBuff[j].getName().length()); k++)
                {
                    if(stdBuff[i].getName().charAt(k) == stdBuff[j].getName().charAt(k))
                        continue;
                    if(stdBuff[i].getName().charAt(k) > stdBuff[j].getName().charAt(k))
                    {
                    	buff = stdBuff[i];
                    	stdBuff[i] = stdBuff[j];
                    	stdBuff[j] = buff;
                        break;
                    }
                    else
                        break;
                }
            }
        }
        String output = "";
        output+= stdBuff[0].toString();
        for(int i = 1; i < stdBuff.length; ++i)
       		output += "\n" + stdBuff[i].toString();
        return output;
	}
	
	public String sortedTeachers()
	{
		Teacher buff;
		Teacher[] tchBuff = new Teacher[students.length];
		for(int i = 0;i < tchBuff.length;++i)
			tchBuff[i] = teachers[i];
        for(int i = 0; i < tchBuff.length; i++)
        {
            for(int j = i; j < tchBuff.length; j++)
            {
                for(int k = 0; k < Math.max(tchBuff[i].getName().length(), tchBuff[j].getName().length()); k++)
                {
                    if(tchBuff[i].getName().charAt(k) == tchBuff[j].getName().charAt(k))
                        continue;
                    if(tchBuff[i].getName().charAt(k) > tchBuff[j].getName().charAt(k))
                    {
                    	buff = tchBuff[i];
                    	tchBuff[i] = tchBuff[j];
                    	tchBuff[j] = buff;
                        break;
                    }
                    else
                        break;
                }
            }
        }
        String output = "";
        output+= tchBuff[0].toString();
        for(int i = 1; i < tchBuff.length; ++i)
       		output += "\n" + tchBuff[i].toString();
        return output;
	}
	
	public String sortedGroups()
	{
		Group buff;
		Group[] grpBuff = new Group[students.length];
		for(int i = 0;i < grpBuff.length;++i)
			grpBuff[i] = groups[i];
        for(int i = 0; i < grpBuff.length; i++)
        {
            for(int j = i; j < grpBuff.length; j++)
            {
                 if(grpBuff[i].getID() > grpBuff[j].getID())
                 {
                 	buff = grpBuff[i];
                   	grpBuff[i] = grpBuff[j];
                   	grpBuff[j] = buff;
                   	break;
                 }
            }
        }
        String output = "";
        output+= grpBuff[0].toString();
        for(int i = 1; i < grpBuff.length; ++i)
       		output += "\n" + grpBuff[i].toString();
        return output;
	}
}

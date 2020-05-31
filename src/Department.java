
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
	
	public void deleteStudentByName(String name)
	{
		int index = -1;
		for(int i = 0; i < students.length; i++)
		{
			if(students[i].getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index < 0)
			return;
		else
		{
			Student newStd[] = new Student[students.length-1];
			for(int i = 0; i < students.length; i++)
			{
				if(i == index)
					continue;
				else if(index > i)
					newStd[i] = students[i];
				else
					newStd[i-1] = students[i];
			}
			students = newStd;
		}
	}
	
	public void deleteTeacherByName(String name)
	{
		int index = -1;
		for(int i = 0; i < teachers.length; i++)
		{
			if(teachers[i].getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index < 0)
			return;
		else
		{
			Teacher newTea[] = new Teacher[teachers.length-1];
			for(int i = 0; i < teachers.length; i++)
			{
				if(i == index)
					continue;
				else if(index > i)
					newTea[i] = teachers[i];
				else
					newTea[i-1] = teachers[i];
			}
			teachers = newTea;
		}
	}
	
	public void deleteGroupByID(int id)
	{
		int index = -1;
		for(int i = 0; i < groups.length; i++)
		{
			if(groups[i].getID() == id)
			{
				index = i;
				break;
			}
		}
		if(index < 0)
			return;
		else
		{
			Group newGrp[] = new Group[groups.length-1];
			for(int i = 0; i < groups.length; i++)
			{
				if(i == index)
					continue;
				else if(index > i)
					newGrp[i] = groups[i];
				else
					newGrp[i-1] = groups[i];
			}
			groups = newGrp;
		}
	}
	
	public Student studentByName(String name)
	{
		for(int i = 0; i < students.length; i++)
			if(students[i].getName().equalsIgnoreCase(name))
				return students[i];
		return null;
	}
	
	public Teacher teacherByName(String name)
	{
		for(int i = 0; i < teachers.length; i++)
			if(teachers[i].getName().equalsIgnoreCase(name))
				return teachers[i];
		return null;
	}
	
	public Group groupByID(int id)
	{
		for(int i = 0; i < groups.length; i++)
			if(groups[i].getID() == id)
				return groups[i];
		return null;
	}
	
	public String toString()
	{
		String str = "	" + name + ":\n";
		
		str += "	Teachers: ";
		for(int i = 0;i < teachers.length;++i)
			str += "\n		" + teachers[i].toString();
		if(teachers.length == 0)
			str += "\n		null";	
		str += "\n	Students:";
		for(int i = 0;i < students.length;++i)
			str += "\n		" + students[i].toString();
		if(students.length == 0)
			str += "\n		null";
		str += "\n	Groups:";
		for(int i = 0;i < groups.length;++i)
			str += "\n		" + groups[i].toString();
		if(groups.length == 0)
			str += "\n		null";
		return str;
	}
	
	public String sortedStudentsByName()
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

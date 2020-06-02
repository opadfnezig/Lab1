
public class Faculty {
	private String name;
	private Department departments[];
	
	public Faculty(String name)
	{
		setName(name);
		departments = new Department[0];
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setDepartments(Department[] dep)
	{
		departments = dep;
	}
	
	public void addDepartment(Department dep)
	{
		Department newDep[] = new Department[departments.length+1];
		for(int i = 0; i < departments.length; i++)
			newDep[i] = departments[i];
		newDep[departments.length] = dep;
		departments = newDep;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Department[] getDepartments()
	{
		return departments;
	}
	
	public Department departmentAt(int i)
	{
		return departments[i];
	}
	
	public boolean isExist(String name)
	{
		for(int i = 0; i < departments.length; i++)
			if(departments[i].getName().equalsIgnoreCase(name))
				return true;
		return false;
	}
	
	public Department departmentByName(String name)
	{
		for(int i = 0; i < departments.length; i++)
			if(departments[i].getName().equalsIgnoreCase(name))
				return departments[i];
		return null;
	}
	
	public void deleteDepartmentByName(String name)
	{
		int index = -1;
		for(int i = 0; i < departments.length; i++)
		{
			if(departments[i].getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index < 0)
			return;
		else
		{
			Department newDep[] = new Department[departments.length-1];
			for(int i = 0; i < departments.length; i++)
			{
				if(i == index)
					continue;
				else if(index > i)
					newDep[i] = departments[i];
				else
					newDep[i-1] = departments[i];
			}
			departments = newDep;
		}
	}
	
	public String toString()
	{
		String str = name + ":";
		if(departments.length == 0)
			str+="\n	null";
		for(int i = 0; i < departments.length; i++)
			str += "\n" + departments[i];
		return str;
	}
	public String sortedDepartments()
    {
		Department buff;
		Department[] depBuf = new Department[departments.length];
		for(int i = 0;i < depBuf.length;++i)
			depBuf[i] = departments[i];
        for(int i = 0; i < depBuf.length; i++)
        {
            for(int j = i; j < depBuf.length; j++)
            {
                for(int k = 0; k < Math.max(depBuf[i].getName().length(), depBuf[j].getName().length()); k++)
                {
                    if(depBuf[i].getName().charAt(k) == depBuf[j].getName().charAt(k))
                        continue;
                    if(depBuf[i].getName().charAt(k) > depBuf[j].getName().charAt(k))
                    {
                    	buff = depBuf[i];
                    	depBuf[i] = depBuf[j];
                    	depBuf[j] = buff;
                        break;
                    }
                    else
                        break;
                }
            }
        }
        String output = name +":\n";
        output+= depBuf[0].toString();
        for(int i = 1; i < depBuf.length; ++i)
       		output += "\n" + depBuf[i].toString();
        return output;
    }
	
	private Student[] getAllStudents()
	{
		Student allStd[] = new Student[0];
		for(Department dep:departments)
		{
			Student dopStd[] = new Student[allStd.length+dep.getStudents().length];
			for(int i = 0; i < dopStd.length; i++)
			{
				if(i < allStd.length)
					dopStd[i] = allStd[i];
				else
					dopStd[i] = dep.getStudents()[i-allStd.length];
			}
			allStd = dopStd;
		}
		return allStd;
	}
	
	private Teacher[] getAllTeachers()
	{
		Teacher allTea[] = new Teacher[0];
		for(Department dep:departments)
		{
			Teacher dopTea[] = new Teacher[allTea.length+dep.getTeachers().length];
			for(int i = 0; i < dopTea.length; i++)
			{
				if(i < allTea.length)
					dopTea[i] = allTea[i];
				else
					dopTea[i] = dep.getTeachers()[i-allTea.length];
			}
			allTea = dopTea;
		}
		return allTea;
	}
	
	public String students()
	{
		String str = name + ":";
		for(Student std:getAllStudents())
			str += "\n	" + std;
		return str;
	}
	
	public String sortedStudentsByName()
	{
		Student buff;
		Student[] stdBuff = new Student[getAllStudents().length];
		for(int i = 0;i < stdBuff.length;++i)
			stdBuff[i] = getAllStudents()[i];
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
	
	public String sortedStudentsByCourse()
	{
		Student buff;
		Student[] stdBuff = new Student[getAllStudents().length];
		for(int i = 0;i < stdBuff.length;++i)
			stdBuff[i] = getAllStudents()[i];
		  for(int i = 0; i < stdBuff.length; i++)
	            for(int j = i; j < stdBuff.length; j++)
	                 if(stdBuff[i].getCourse() > stdBuff[j].getCourse())
	                 {
	                 	buff = stdBuff[i];
	                 	stdBuff[i] = stdBuff[j];
	                 	stdBuff[j] = buff;
	                   	break;
	                 }
        String output = "";
        output+= stdBuff[0].toString();
        for(int i = 1; i < stdBuff.length; ++i)
       		output += "\n" + stdBuff[i].toString();
        return output;
	}
	
	public String teachers()
	{
		String str = name + ":";
		for(Teacher tea:getAllTeachers())
			str += "\n	" + tea;
		return str;
	}
	
	public String sortedTeachersByName()
	{
		Teacher allTea[] = getAllTeachers();
		for(int i = 0; i < allTea.length; i++)
		{
			for(int j = 0; j < allTea.length; j++)
			{
				for(int k = 0; k < Math.max(allTea[i].getName().length(), allTea[j].getName().length()); k++)
				{
					 if(allTea[i].getName().charAt(k) == allTea[j].getName().charAt(k))
						 continue;
	                 if(allTea[i].getName().charAt(k) > allTea[j].getName().charAt(k))
	                 {
	                    Teacher buff = allTea[i];
	                    allTea[i] = allTea[j];
	                    allTea[j] = buff;
	                    break;
	                 }
	                 else
	                	 break;
				}
			}
		}
		String str = name+":";
		for(Teacher tea:allTea)
			str+="\n"+tea;
		return str;
	}
	
	public String studentsByCourse(int course)
	{
		String str = name + ":";
		for(Student std:getAllStudents())
		{
			if(std.getCourse() == course)
				str+="\n	" + std;
		}
		return str;
	}
}
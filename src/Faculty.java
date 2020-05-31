
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
	
	//public String students()
	//{
	//	Student buff;
	//	Student[] stdBuff = new Student[0];
	//	
	//	
	//	
	//	
	//}
}

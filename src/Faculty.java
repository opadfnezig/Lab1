
public class Faculty {
	private String name;
	private Department departments[];
	
	public Faculty(String name)
	{
		setName(name);
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
	
	public String toString()
	{
		String str = name + ":";
		for(int i = 0; i < departments.length; i++)
			str += "\n" + departments[i];
		return str;
	}
	public String sortedDepartments()
    {
		Department buff;
		Department[] depBuf = new Department[departments.length];
		for(int i = 0;i < depBuf.length;++i)
			departments[i] = depBuf[i];
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
        String output = "";
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


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
	
	public String toString()
	{
		String str = name + ":";
		if(departments.length == 0)
			str+="\n	null";
		for(int i = 0; i < departments.length; i++)
			str += "\n" + departments[i];
		return str;
	}
}

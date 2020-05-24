
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
}

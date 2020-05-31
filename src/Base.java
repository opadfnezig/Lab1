import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Base
{
	String path;
	
	public Base(String path)
	{
		this.path = path;	
	}
	
	public Faculty[] read()
	{
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e)
		{
			return null;
		}
		String s = "", buf;
		boolean firstString = true;
		if (reader != null)
			try
			{
				while (true)
				{
					buf = reader.readLine();
					if (buf != null)
						if(!firstString)
							s += "\n" + buf;
						else
							{
								firstString = false;
								s += buf;
							}
					else 
						break;
				}
				reader.close();
			} catch (IOException e) { }
		Faculty faculties[] = new Faculty[0];
		if(s != "")
		{
			s.split("faculties\\[\\]\\{\\n((.*\\n)*)\\}$");
		}
		return faculties;
		
	}
	
	public void write(Faculty faculties[])
	{
		PrintWriter writer;
		try
		{
			writer = new PrintWriter(path);
			String str = "";
			str += "faculties[]={\n";
			for(int i = 0; i < faculties.length;++i)
			{
				str += "faculty[" + i + "]{\n";
				str += "name=" + faculties[i].getName() + "\n";
				str += "departments[]{\n";
				for(int j = 0; j < faculties[i].getDepartments().length;++j)
				{
					str += "department[" + j + "]{\n";
					str += "name=" + faculties[i].getDepartments()[j].getName() + "\n";
					str += "teachers[]{\n";
					for(int k = 0; k < faculties[i].getDepartments()[j].getTeachers().length;++k)
					{	
						str += "teacher[" + k + "]{\n";
						str += "name=" + faculties[i].getDepartments()[j].getTeachers()[k].getName() + "\n";
						str += "sbuject=" + faculties[i].getDepartments()[j].getTeachers()[k].getSubject() + "\n";
					}
					str += "}\n";
					str += "students[]{\n";
					for(int k = 0; k < faculties[i].getDepartments()[j].getStudents().length;++k)
					{	
						str += "student[" + k + "]{\n";
						str += "name=" + faculties[i].getDepartments()[j].getStudents()[k].getName() + "\n";
						str += "course=" + faculties[i].getDepartments()[j].getStudents()[k].getCourse() + "\n";
					}
					str += "}\n";
					str += "groups[]{\n";
					for(int k = 0; k < faculties[i].getDepartments()[j].getGroups().length;++k)
					{
						str += "group[" + k + "]{\n";
						str += "id=" + faculties[i].getDepartments()[j].getGroups()[k].getID();
						str += "teacher{\n";
						str += "name=" + faculties[i].getDepartments()[j].getGroups()[k].getTeacher().getName() + "\n";
						str += "subject=" + faculties[i].getDepartments()[j].getGroups()[k].getTeacher().getSubject() + "\n";
						str += "}\n";
						str += "students[]{\n";
						for(int l = 0;l < faculties[i].getDepartments()[j].getGroups()[k].getStudents().length;++l)
						{
							str += "student[" + l + "]{\n";
							str += "name=" + faculties[i].getDepartments()[j].getGroups()[k].getStudents()[l].getName();
							str += "course=" + faculties[i].getDepartments()[j].getGroups()[k].getStudents()[l].getCourse();
						}
						str += "}\n";
					}
					str += "}\n";
				}
				str += "}\n";
			}
			str += "}";
			writer.write(str);
			writer.close();
		} catch (FileNotFoundException e)
		{
		}
		
	}
	
	public int getRowCount()
	{
		int rows = 0;
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e)
		{
		}
		
		if (reader != null)
			try
			{
				while (true)
				{
					
					if (reader.readLine() == null)
						break;
					++rows;
				}
				reader.close();
			} catch (IOException e) { }
		return rows;
	}
	
	public boolean exists()
	{
		BufferedReader reader = null;
		try { reader = new BufferedReader(new FileReader(path)); } 
		catch (FileNotFoundException e) { return false; }
		return true;
	}
	
	public static boolean exists(String path)
	{
		BufferedReader reader = null;
		try { reader = new BufferedReader(new FileReader(path));}
		catch (FileNotFoundException e) { return false; }
		return true;
	}
}

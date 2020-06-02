import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static Faculty faculties[] = new Faculty[0];
	
	public static void main(String[] args) {
		boolean end = false;
		while(!end)
		{
			try {
				String str = getString(">");
				if(errorCheck(dellEmpty(str.split(" ")), 0))
					continue;
				String com = dellEmpty(str.split(" "))[0];
				switch(com)
				{
				case "help":
					help();
					break;
				case "add":
					add(str);
					break;
				case "dell":
					dell(str);
					break;
				case "edit":
					edit(str);
					break;
				case "print":
					print(str);
					break;
				case "printF":
					printF(str);
					break;
				case "appoint":
					appoint(str);
					break;
				case "exit":
					end = true;
					System.out.println("Exit");
					break;
				default:
					System.out.println("Error");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void help()
	{
		System.out.println("add - команда створення");
		System.out.println("Спосіб використання: add [/O] [назва/ID] [/R] [курс]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group)");
		System.out.println("/R - шлях([faculty]/[department]");
		System.out.println();
		System.out.println("del - команда видалення");
		System.out.println("Спосіб використання: del [/O] [назва/ID] [/R]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group)");
		System.out.println("/R - шлях([faculty]/[department]");
		System.out.println();
		System.out.println("edit - команда редагування");
		System.out.println("Спосіб використання: edit [/O] [назва/ID] [/R] [нова назва/ID] [новий курс]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group)");
		System.out.println("/R - шлях([faculty]/[department]");
		System.out.println();
		System.out.println("print - команда виводу інформації");
		System.out.println("Спосіб використання: print [/O] [назва/ID] [/R] [/S]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group, course)");
		System.out.println("/R - шлях([faculty]/[department]");
		System.out.println("/S - сортувати за(name, course)");
		System.out.println();
		System.out.println("printF [назва факультету] [/O] [/S]");
		System.out.println("/O - обєкт(student, teacher)");
		System.out.println("/S - сортувати за(name, course)");
		System.out.println();
		System.out.println("appoint - команда назначення студентів та викладачів до групи");
		System.out.println("Повторне назначення видаляє з групи, а викладачі переназначаються");
		System.out.println("appoint [/O] [назва] [/R] [ID]");
		System.out.println("/R - шлях([faculty]/[department]");
		System.out.println("/O - обєкт(student, teacher)");
	}
	
	private static void add(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "faculty":
			if(errorCheck(com, 2))
				break;
			if(com.length > 3)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[2]))
			{
				System.out.println("Error");
				break;
			}
			System.out.println("Success");
			addFaculty(new Faculty(com[2]));
			break;
		case "department":
			if(errorCheck(com, 3))
				break;
			if(isExist(com[3]))
			{
				if(facultyByName(com[3]).isExist(com[2]))
					System.out.println("Error");
				else
				{
					System.out.println("Success");
					facultyByName(com[3]).addDepartment(new Department(com[2]));
				}
			}
			else
				System.out.println("Error");
			break;
		case "student":
			if(errorCheck(com, 4))
				break;
			String roadS[] = com[3].split("/");
			if(errorCheck(roadS, 1))
				break;
			if(isExist(roadS[0]))
			{
				if(facultyByName(roadS[0]).isExist(roadS[1]))
				{
					if(facultyByName(roadS[0]).departmentByName(roadS[1]).studentIsExist(com[2]))
						System.out.println("Error");
					else
					{
						try
						{
							int course = Integer.valueOf(com[4]);
							System.out.println("Success");
							facultyByName(roadS[0]).departmentByName(roadS[1]).addStudent(new Student(com[2], course));
						}
						catch(NumberFormatException e)
						{
							System.out.println("Error");
						}
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "teacher":
			if(errorCheck(com, 3))
				break;
			String roadT[] = com[3].split("/");
			if(errorCheck(roadT, 1))
				break;
			if(isExist(roadT[0]))
			{
				if(facultyByName(roadT[0]).isExist(roadT[1]))
				{
					if(facultyByName(roadT[0]).departmentByName(roadT[1]).teacherIsExist(com[2]))
						System.out.println("Error");
					else
					{
						System.out.println("Success");
						facultyByName(roadT[0]).departmentByName(roadT[1]).addTeacher(new Teacher(com[2]));
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "group":
			if(errorCheck(com, 3))
				break;
			String roadG[] = com[3].split("/");
			if(errorCheck(roadG, 1))
				break;
			if(isExist(roadG[0]))
			{
				if(facultyByName(roadG[0]).isExist(roadG[1]))
				{
					try
					{
						int id = Integer.valueOf(com[2]);
						if(facultyByName(roadG[0]).departmentByName(roadG[1]).groupIsExist(id))
							System.out.println("Error");
						else
						{
							
								System.out.println("Success");
								facultyByName(roadG[0]).departmentByName(roadG[1]).addGroup(new Group(id));
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Error");
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void dell(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "faculty":
			if(errorCheck(com, 2))
				break;
			if(com.length > 3)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[2]))
			{
				deleteFacultyByName(com[2]);
				System.out.println("Success");
			}
			else
				System.out.println("Error");
			break;
		case "department":
			if(errorCheck(com, 3))
				break;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[3]))
			{
				if(facultyByName(com[3]).isExist(com[2]))
				{
					System.out.println("Success");
					facultyByName(com[3]).deleteDepartmentByName(com[2]);
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "student":
			if(errorCheck(com, 3))
				break;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadS[] = com[3].split("/");
			if(errorCheck(roadS, 1))
				break;
			if(isExist(roadS[0]))
			{
				if(facultyByName(roadS[0]).isExist(roadS[1]))
				{
					if(facultyByName(roadS[0]).departmentByName(roadS[1]).studentIsExist(com[2]))
					{
						System.out.println("Success");
						facultyByName(roadS[0]).departmentByName(roadS[1]).deleteStudentByName(com[2]);;
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "teacher":
			if(errorCheck(com, 3))
				break;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadT[] = com[3].split("/");
			if(errorCheck(roadT, 1))
				break;
			if(isExist(roadT[0]))
			{
				if(facultyByName(roadT[0]).isExist(roadT[1]))
				{
					if(facultyByName(roadT[0]).departmentByName(roadT[1]).teacherIsExist(com[2]))
					{
						System.out.println("Success");
						facultyByName(roadT[0]).departmentByName(roadT[1]).deleteTeacherByName(com[2]);;
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "group":
			if(errorCheck(com, 3))
				break;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadG[] = com[3].split("/");
			if(errorCheck(roadG, 1))
				break;
			if(isExist(roadG[0]))
			{
				if(facultyByName(roadG[0]).isExist(roadG[1]))
				{
					try
					{
						int id = Integer.valueOf(com[2]);
						if(facultyByName(roadG[0]).departmentByName(roadG[1]).groupIsExist(id))
						{
							
								System.out.println("Success");
								facultyByName(roadG[0]).departmentByName(roadG[1]).deleteGroupByID(id);
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Error");
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void edit(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "faculty":
			if(errorCheck(com, 3))
				break;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[2]))
			{
				facultyByName(com[2]).setName(com[3]);
				System.out.println("Success");
			}
			else
				System.out.println("Error");
			break;
		case "department":
			if(errorCheck(com, 4))
				break;
			if(com.length > 5)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[3]))
			{
				if(facultyByName(com[3]).isExist(com[2]))
				{
					System.out.println("Success");
					facultyByName(com[3]).departmentByName(com[2]).setName(com[4]);
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "student":
			if(errorCheck(com, 5))
				break;
			if(com.length > 6)
			{
				System.out.println("Error");
				break;
			}
			String roadS[] = com[3].split("/");
			if(errorCheck(roadS, 1))
				break;
			if(isExist(roadS[0]))
			{
				if(facultyByName(roadS[0]).isExist(roadS[1]))
				{
					if(facultyByName(roadS[0]).departmentByName(roadS[1]).studentIsExist(com[2]))
					{
						System.out.println("Success");
						facultyByName(roadS[0]).departmentByName(roadS[1]).studentByName(com[2]).setName(com[4]);
						try
						{
							int course = Integer.valueOf(com[5]);
							System.out.println("Success");
							facultyByName(roadS[0]).departmentByName(roadS[1]).studentByName(com[4]).setCourse(course);
						}
						catch(NumberFormatException e)
						{
							System.out.println("Error");
						}
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "teacher":
			if(errorCheck(com, 4))
				break;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadT[] = com[3].split("/");
			if(errorCheck(roadT, 1))
				break;
			if(isExist(roadT[0]))
			{
				if(facultyByName(roadT[0]).isExist(roadT[1]))
				{
					if(facultyByName(roadT[0]).departmentByName(roadT[1]).teacherIsExist(com[2]))
					{
						System.out.println("Success");
						facultyByName(roadT[0]).departmentByName(roadT[1]).teacherByName(com[2]).setName(com[4]);
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "group":
			if(errorCheck(com, 4))
				break;
			if(com.length > 5)
			{
				System.out.println("Error");
				break;
			}
			String roadG[] = com[3].split("/");
			if(errorCheck(roadG, 1))
				break;
			if(isExist(roadG[0]))
			{
				if(facultyByName(roadG[0]).isExist(roadG[1]))
				{
					try
					{
						int id1 = Integer.valueOf(com[2]);
						int id2 = Integer.valueOf(com[4]);
						if(facultyByName(roadG[0]).departmentByName(roadG[1]).groupIsExist(id1))
						{
							
								System.out.println("Success");
								facultyByName(roadG[0]).departmentByName(roadG[1]).groupByID(id1).setID(id2);;
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Error");
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void print(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "faculty":
			if(errorCheck(com, 2))
				return;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[2]))
			{
				if(com.length > 3)
				{
					if(com[3].equalsIgnoreCase("name"))
						System.out.println(facultyByName(com[2]).sortedDepartments());
					else
						System.out.println("Error");
				}
				else
					System.out.println(facultyByName(com[2]));
			}
			else
				System.out.println("Error");
			break;
		case "department":
			if(errorCheck(com, 3))
				return;
			if(com.length > 5)
			{
				System.out.println("Error");
				break;
			}
			if(isExist(com[3]))
			{
				if(facultyByName(com[3]).isExist(com[2]))
				{
					if(com.length > 4)
					{
						if(com[4].equalsIgnoreCase("name"))
							System.out.println(facultyByName(com[2]).departmentByName(com[2]).sortedByName());
						else if(com[4].equalsIgnoreCase("course"))
							System.out.println(facultyByName(com[2]).departmentByName(com[2]).sortedByCourse());
						else
							System.out.println("Error");
					}
					else
						System.out.println(facultyByName(com[3]).departmentByName(com[2]));
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "student":
			if(errorCheck(com, 3))
				return;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadS[] = com[3].split("/");
			if(errorCheck(roadS, 1))
				break;
			if(isExist(roadS[0]))
			{
				if(facultyByName(roadS[0]).isExist(roadS[1]))
				{
					if(facultyByName(roadS[0]).departmentByName(roadS[1]).studentIsExist(com[2]))
						System.out.println(facultyByName(roadS[0]).departmentByName(roadS[1]).studentByName(com[2]));
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "teacher":
			if(errorCheck(com, 3))
				return;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadT[] = com[3].split("/");
			if(errorCheck(roadT, 1))
				break;
			if(isExist(roadT[0]))
			{
				if(facultyByName(roadT[0]).isExist(roadT[1]))
				{
					if(facultyByName(roadT[0]).departmentByName(roadT[1]).teacherIsExist(com[2]))
						System.out.println(facultyByName(roadT[0]).departmentByName(roadT[1]).teacherByName(com[2]));
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "group":
			if(errorCheck(com, 3))
				return;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadG[] = com[3].split("/");
			if(errorCheck(roadG, 1))
				break;
			if(isExist(roadG[0]))
			{
				if(facultyByName(roadG[0]).isExist(roadG[1]))
				{
					try
					{
						int id = Integer.valueOf(com[2]);
						if(facultyByName(roadG[0]).departmentByName(roadG[1]).groupIsExist(id))
							System.out.println(facultyByName(roadG[0]).departmentByName(roadG[1]).groupByID(id));
						else
							System.out.println("Error");
					}
					catch(NumberFormatException e)
					{
						System.out.println("Error");
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "course":
			if(errorCheck(com, 3))
				return;
			if(com.length > 4)
			{
				System.out.println("Error");
				break;
			}
			String roadC[] = com[3].split("/");
			if(roadC.length == 1)
			{
				if(isExist(com[3]))
				{
					try
					{
						int course = Integer.valueOf(com[2]);
						System.out.println(facultyByName(com[3]).studentsByCourse(course));
					}
					catch(NumberFormatException e)
					{
						System.out.println("Error");
					}
				}
				else
					System.out.println("Error");
			}
			else if(roadC.length == 2)
			{
				if(isExist(roadC[0]))
				{
					if(facultyByName(roadC[0]).isExist(roadC[0])) 
					{
						try
						{
							int course = Integer.valueOf(com[2]);
							System.out.println(facultyByName(com[3]).studentsByCourse(course));
						}
						catch(NumberFormatException e)
						{
							System.out.println("Error");
						}
					}
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void printF(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 2))
			return;
		if(com.length > 4)
		{
			System.out.println("Error");
			return;
		}
		if(isExist(com[1]))
		{
			switch(com[2])
			{
			case "student":
				if(com.length > 3)
				{
					switch(com[3])
					{
					case "name":
						
						break;
					case "course":
						break;
					default:
						break;
					}
				}
				else
					System.out.println(facultyByName(com[1]).students());
				break;
			case "teacher":
				if(com.length > 3)
				{
					if(com[3].equalsIgnoreCase("name"))
						
					else
						System.out.println("Error");
				}
				else
					System.out.println(facultyByName(com[1]).teachers());
				break;
			default:
				System.out.println("Error");
				break;
			}
		}
		else
			System.out.println("Error");
	}
	
	private static void appoint(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "student":
			if(errorCheck(com, 4))
				return;
			if(com.length > 5)
			{
				System.out.println("Error");
				break;
			}
			String roadS[] = com[3].split("/");
			if(errorCheck(roadS, 1))
				break;
			if(isExist(roadS[0]))
			{
				if(facultyByName(roadS[0]).isExist(roadS[1]))
				{
					if(facultyByName(roadS[0]).departmentByName(roadS[1]).studentIsExist(com[2]))
					{
						try
						{
							int id = Integer.valueOf(com[4]);
							if(facultyByName(roadS[0]).departmentByName(roadS[1]).groupIsExist(id))
							{
								facultyByName(roadS[0]).departmentByName(roadS[1]).
								groupByID(id).addStudent(facultyByName(roadS[0]).
								departmentByName(roadS[1]).studentByName(com[2]));
							}
							else
								System.out.println("Error");
								
						}
						catch(NumberFormatException e)
						{
							System.out.println("Error");
						}
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		case "teacher":
			if(errorCheck(com, 4))
				return;
			if(com.length > 5)
			{
				System.out.println("Error");
				break;
			}
			String roadT[] = com[3].split("/");
			if(errorCheck(roadT, 1))
				break;
			if(isExist(roadT[0]))
			{
				if(facultyByName(roadT[0]).isExist(roadT[1]))
				{
					if(facultyByName(roadT[0]).departmentByName(roadT[1]).teacherIsExist(com[2]))
					{
						try
						{
							int id = Integer.valueOf(com[4]);
							if(facultyByName(roadT[0]).departmentByName(roadT[1]).groupIsExist(id))
							{
								facultyByName(roadT[0]).departmentByName(roadT[1]).
								groupByID(id).setTeacher(facultyByName(roadT[0]).
								departmentByName(roadT[1]).teacherByName(com[2]));
							}
							else
								System.out.println("Error");
								
						}
						catch(NumberFormatException e)
						{
							System.out.println("Error");
						}
					}
					else
						System.out.println("Error");
				}
				else
					System.out.println("Error");
			}
			else
				System.out.println("Error");
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	/**
	 * @param str
	 * @return
	 */
	private static String[] dellEmpty(String[] str)
	{
		String newStr[] = new String[str.length];
		int count = 0;
		for(int i = 0; i < str.length; i++)
		{
			if(str[i].equalsIgnoreCase("") || str[i] == null)
			{
				newStr = reduceArr(newStr);
				count++;
			}
			else
				newStr[i-count] = str[i];
		}
		return str;
	}
	
	private static String[] reduceArr(String[] str)
	{
		String newStr[] = new String[str.length-1];
		for(int i = 0; i < newStr.length; i++)
			newStr[i] = str[i];
		return newStr;
	}
	
	private static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	private static String getString(String wr) throws IOException{
		System.out.print(wr);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	private static boolean errorCheck(String[] com, int i)
	{
		if(com.length-1 >= i)
		{
			return false;
		}
		else
		{
			System.out.println("Error");
			return true;
		}
	}
	
	private static void addFaculty(Faculty f)
	{
		Faculty newFac[] = new Faculty[faculties.length+1];
		for(int i = 0; i < faculties.length; i++)
			newFac[i] = faculties[i];
		newFac[faculties.length] = f;
		faculties = newFac;
	}
	
	private static boolean isExist(String name)
	{
		for(int i = 0; i < faculties.length; i++)
			if(faculties[i].getName().equalsIgnoreCase(name))
				return true;
		return false;
	}
	
	private static Faculty facultyByName(String name)
	{
		for(int i = 0; i < faculties.length; i++)
			if(faculties[i].getName().equalsIgnoreCase(name))
				return faculties[i];
		return null;
	}
	
	private static void deleteFacultyByName(String name)
	{
		int index = -1;
		for(int i = 0; i < faculties.length; i++)
		{
			if(faculties[i].getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index < 0)
			return;
		else
		{
			Faculty newFac[] = new Faculty[faculties.length-1];
			for(int i = 0; i < faculties.length; i++)
			{
				if(i == index)
					continue;
				else if(index > i)
					newFac[i] = faculties[i];
				else
					newFac[i-1] = faculties[i];
			}
			faculties = newFac;
		}
	}
}

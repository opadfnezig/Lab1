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
				case "search":
					search(str);
					break;
				case "sort":
					sort(str);
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
		System.out.println("Спосіб використання: edit [/O] [назва/ID] [/R]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group)");
		System.out.println("/R - шлях([faculty]/[department]");
		System.out.println();
		System.out.println("print - команда виводу інформації");
		System.out.println("Спосіб використання: print [/O] [назва/ID]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group, course)");
		System.out.println();
		System.out.println("search - команда пошуку");
		System.out.println("Спосіб використання: search [/O] [назва/ID]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group)");
		System.out.println();
		System.out.println("sort - команда сортування");
		System.out.println("Спосіб використання: sort [/O] [назва/ID] [/B]");
		System.out.println("/O - обєкт(faculty, department)");
		System.out.println("/B - сортувати за(name, course)");
		System.out.println();
		System.out.println("appoint - команда назначення студентів та викладачів до групи");
		System.out.println("Повторне назначення видаляє з групи, а викладачі переназначаються");
		System.out.println("appoint [/O] [назва] [ID]");
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
			if(errorCheck(com, 3))
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
							e.getStackTrace();
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
						e.getStackTrace();
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
			break;
		case "department":
			break;
		case "student":
			break;
		case "teacher":
			break;
		case "group":
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
			break;
		case "department":
			break;
		case "student":
			break;
		case "teacher":
			break;
		case "group":
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
			break;
		case "department":
			break;
		case "student":
			break;
		case "teacher":
			break;
		case "group":
			break;
		case "course":
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void search(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "faculty":
			break;
		case "department":
			break;
		case "student":
			break;
		case "teacher":
			break;
		case "group":
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void sort(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "faculty":
			break;
		case "department":
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static void appoint(String str)
	{
		String com[] = dellEmpty(str.split(" "));
		if(errorCheck(com, 1))
			return;
		switch(com[1])
		{
		case "student":
			break;
		case "teacher":
			break;
		default:
			System.out.println("Error");
			return;
		}
	}
	
	private static String[] dellEmpty(String[] str)
	{
		String newStr[] = new String[str.length];
		int count = 0;
		for(int i = 0; i < str.length; i++)
		{
			if(str[i] == "" || str[i] == null)
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
}

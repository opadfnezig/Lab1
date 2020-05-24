import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		boolean end = false;
		Faculty faculties[] = new Faculty[0];
		while(!end)
		{
			try {
				String str = getString(">");
				String com = dellEmpty(str.split(" "))[0];
				switch(com)
				{
				case "help":
					help();
					break;
				case "add":
					add(str);
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
		System.out.println("Спосіб використання: add [/O] [назва/ID] [/R]");
		System.out.println("/O - обєкт(faculty, department, student, teacher, group)");
		System.out.println("/R - шлях([faculty]/[department]/...");
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
		System.out.println("appoint [/O] [назва] [ID]");
		System.out.println("/O - обєкт(student, teacher)");
	}
	
	private static void add(String str)
	{
		String com[] = dellEmpty(str.split(" "));
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
	
	private static void writeText(String wr){
		if (wr == null)
			System.out.print("Р’РІРµРґС–С‚СЊ РґР°РЅС–: ");
		else 
			System.out.print(wr);
	}
	
	private static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	private static String getString(String wr) throws IOException{
		writeText(wr);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}


public class Main {

	public static void main(String[] args) {
		boolean end = false;
		Faculty faculties[] = new Faculty[0];
		while(!end)
		{
			help();
			break;
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
	}
	
	private static void add(String str)
	{
		
	}

}

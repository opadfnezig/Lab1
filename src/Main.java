
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
		System.out.println("add - ������� ���������");
		System.out.println("����� ������������: add [/O] [�����/ID] [/R]");
		System.out.println("/O - ����(faculty, department, student, teacher, group)");
		System.out.println("/R - ����([faculty]/[department]/...");
		System.out.println();
		System.out.println("print - ������� ������ ����������");
		System.out.println("����� ������������: print [/O] [�����/ID]");
		System.out.println("/O - ����(faculty, department, student, teacher, group, course)");
		System.out.println();
		System.out.println("search - ������� ������");
		System.out.println("����� ������������: search [/O] [�����/ID]");
		System.out.println("/O - ����(faculty, department, student, teacher, group)");
		System.out.println();
		System.out.println("sort - ������� ����������");
		System.out.println("����� ������������: sort [/O] [�����/ID] [/B]");
		System.out.println("/O - ����(faculty, department)");
		System.out.println("/B - ��������� ��(name, course)");
	}
	
	private static void add(String str)
	{
		
	}

}

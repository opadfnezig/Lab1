
public class Teacher {
	private String name;
	private String subject;
	public Teacher() {}
	public Teacher(String name)
	{
		setName(name);
	}
	
	public void setName(String n) {	name = n;}	
	public String getName() { return name; }
	public void setSubject(String subject) { this.subject = subject; }
	public String getSubject() { return subject; }
	public String toString() { return name; }
}

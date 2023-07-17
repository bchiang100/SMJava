package homework;

public class Classroom {
	private String className;
	
	private Human[] roster;
	
	public Classroom(String className, int numStudents) {
		this.className = className;
		
		roster = new Human[numStudents];
	}
	
	public void addStudent(String name, int age, int height, int i) {
		if (i >= roster.length || i < 0) {
			System.out.println("Invalid index!");
			return;
		}
		roster[i] = new Human(age, height, name);
	}
	public void ages() {
		for (Human person : roster) {
			if (person != null) {
				System.out.println(person.getAge());
			}
			else {
				System.out.println("Empty slot!");
			}
		}
	}
	public static void main(String [] args) {
		Classroom c = new Classroom("CS", 2);
		c.addStudent("Condy", 10, 4, 0);
		
		c.ages();
	}
}

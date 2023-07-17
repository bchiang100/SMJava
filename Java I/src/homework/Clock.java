package homework;
public class Clock {
	int instanceTime;
	public void setTime(int time) {
		instanceTime = time;
	}
	
	public void displayTime() {
		System.out.println(instanceTime);
	}
	
	public void tick() {
		instanceTime = instanceTime + 1;
		instanceTime = instanceTime % 60;
	}
	
	public static void main(String[] args) {
		Clock tester = new Clock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
	}
}
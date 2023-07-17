package homework;

public class HumanMethods {
	int instAge;
	char instGender;
	public void setAge (int age){
		instAge=age;
	}
	public void setGender (char gender) {
		instGender=gender;
	}
	public void canVote (int age2) {
		if (age2>=18) {
			System.out.println("The person can vote");
		}
		else if (0<age2 && age2<18) {
			System.out.println("The person is underaged and therefore cannot vote");
		} else {
			System.out.println("Invalid input");
		}
	}
	public void tetanusShot (int age3) {
		if (age3 % 4 == 0) {
			System.out.println("The person needs a Tetanus shot");
		} else {
			System.out.println("The person does not need a Tetanus shot");
		}
	}
	public void toddler() {
		if (instAge<4) {
			if (instGender == 'b') {
				System.out.println("The toddler is a boy");
			}
			if (instGender == 'g') {
				System.out.println("The toddler is a girl");
			}
		} else {
			System.out.println("The person is not a toddler");
		}
	}
	public void movieDiscount() {
		if (instAge < 12 || instAge > 65) {
			System.out.println("The person is eligible for a movie discount");
		} else {
			System.out.println("The person is not eligible for a movie discount");
		}
	}
	public void teenagerChecker() {
		if (instAge > 12 && instAge < 18) {
			System.out.println("The person is a teenager");
		} else {
			System.out.println("The person is not a teenager");
		}
	}
	public void compareTeammates(int age4, char gender2) {
		if ((age4 -instAge >= 0 && age4-instAge<=2) || (instAge-age4 >= 0 && instAge-age4<=2)) {
			if (instGender == gender2) {
				System.out.println("They can be teammates");
			} 
		} else {
			System.out.println("They cannot be teammates");
		}
	}
	public static void main (String [] args) {
		HumanMethods runner = new HumanMethods();
		runner.setAge(14);
		runner.setGender('f');
		runner.canVote(16);
		runner.tetanusShot(13);
		runner.toddler();
		runner.movieDiscount();
		runner.teenagerChecker();
		runner.compareTeammates(17, 'f');
	}
}

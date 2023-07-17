package homework;

public class CoolBot extends ChatBot{
	public void sayHi() {
		System.out.println("Wassup, how's it going?");
	}
	public void sayBye() {
		System.out.println("Awesome. Anyways, I gotta blast. Cya later!");
	}
	public void startConversation() {
		System.out.println("So, what flavor of ice cream u like?");
	}
	public void askFirstQuestion() {
		System.out.println("Aw sick! That flavor is fire. U jam to music often?");
	}
	public void askSecondQuestion() {
		System.out.println("Let's go! My fav genre is rock. Hbu?");
	}
	public void askThirdQuestion() {
		System.out.println("Not bad, not bad. Oh yea, u play any sports?");
	}
}
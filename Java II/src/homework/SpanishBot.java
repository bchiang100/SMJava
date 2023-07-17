package homework;

public class SpanishBot extends ChatBot{
	public void sayHi() {
		System.out.println("¡Hola! ¿Còmo estas?");
	}
	public void sayBye() {
		System.out.println("¡Gracias! Estoy alegre. Necesisto salir ahora. ¡Chao!");
	}
	public void startConversation() {
		System.out.println("Estoy muy bien. ¿Entonces, que tipos de musica te gusta?");
	}
	public void askFirstQuestion() {
		System.out.println("Claro. Me gusta pop. Creo que pop sea el mejor de todos de los tipos de musica. ¿Juegas los deportes?");
	}
	public void askSecondQuestion() {
		System.out.println("Yo tambièn. Me encanta a nadar en el piscina tambièn. Es como me relajo. ¿Te gusta nadar?");
	}
	public void askThirdQuestion() {
		System.out.println("Sì. ¡Es muy saludable para tù salud, y es divertido! ¿Finalmente, crees que soy simpatico?");
	}
}
package pokemon;

public class Seel extends Pokemon{
	public Seel() {
		super("Seel", 2 , 60, "pokemon-seel.jpeg", new Move[] {new Move("Slip Slap", 2, 33, 3), new Move("Storm Drain", 0, 66, 0), new Move("Innocent Shock", 3, 16, 0), new Move("Seel Special", 1, 70, 4)});
	}
}

//types: normal, fire, water, grass
//effects: nothing, put to sleep, poisoned, confused, paralyzed

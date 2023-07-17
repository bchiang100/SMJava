package pokemon;

public class Geodude extends Pokemon{
	public Geodude() {
		super("Geodude", 0 , 110, "pokemon-geodude.jpeg", new Move[] {new Move("Rock Hard", 0, 30, 0), new Move("The Rock", 0, 27, 4), new Move("Shock", 0, 16, 1), new Move("J Chillin'", 0, 0, 0)});
	}
}


//name, type, damage, effect
//types: normal, fire, water, grass
//effects: nothing, put to sleep, poisoned, confused, paralyzed

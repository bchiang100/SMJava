package pokemon;

public class Snorlax extends Pokemon{
	public Snorlax() {
		super("Snorlax", 0 , 80, "pokemon-snorlax.png", new Move[] {new Move("Start Sleeping", 0, 33, 1), new Move("Snake Eyes", 3, 33, 0), new Move("Dead Stare", 1, 16, 1), new Move("Snore", 3, 0, 1)});
	}
}

//types: normal, fire, water, grass
//effects: nothing, put to sleep, poisoned, confused, paralyzed
package pokemon;
import java.util.ArrayList;

public class TeamBryan {
	public TeamBryan () {
		
	}
	public static ArrayList<Pokemon> createTeam() {
		ArrayList<Pokemon> team = new ArrayList<Pokemon> ();
		team.add(new Snorlax());
		team.add(new Seel());
		team.add(new Geodude());
		return team;
	}
}

package homework;

public class Wrestler {
	private String name;
	private double weight;
	private String outfitColor;
	private int wins = 0;
	
	public Wrestler (String name, int weight, String outfitColor, int wins) {
		this.name = name;
		this.weight = weight;
		this.outfitColor = outfitColor;
		this.wins = wins;
	}
	public void intimidate() {
		System.out.println("Fight me... you won't!");
	}
	public void fight(Wrestler fighter) {
		if (weight > fighter.weight) {
			System.out.println(name + " wins!");
			wins++;
		}
		else if (fighter.weight > weight) {
			System.out.println(fighter.name + " wins!");
			fighter.wins++;
		}
		else if (fighter.name.charAt(0) > name.charAt(0)) {
			System.out.println(fighter.name + " wins!");
			fighter.wins++;
		}
		else if (name.charAt(0) > fighter.name.charAt(0)) {
			System.out.println(name + " wins!");
			wins++;
		}
	}
	public void lift(int mins) {
		weight+=mins * 0.1;
	}
	public void tagTeam(Wrestler arr[], Wrestler arr2[]) {
		double totalWeight1 = weight;
		double totalWeight2 = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i].outfitColor = outfitColor;
			totalWeight1 += arr[i].weight;
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i].outfitColor = arr2[0].outfitColor;
			totalWeight2 += arr2[i].weight;
		}
		if (totalWeight1 >= totalWeight2) {
			System.out.println("Your tag team wins!");
			for (int i = 0; i < arr.length; i++) {
				arr[i].wins+=1;
			}
		}
		else if (totalWeight2 > totalWeight1) {
			System.out.println("The opponents tag team won...");
			for (int i = 0; i < arr2.length; i++) {
				arr2[i].wins+=1;
			}
		}
	}
	public String toString() {
		return "The wrestler's name is " + name + ", he/she weighs " + weight + "kg, his/her outfit color is " + outfitColor + ", and he/she has " + wins + " wins";
	}
	
	public static void main(String [] args) {
		
	}
}

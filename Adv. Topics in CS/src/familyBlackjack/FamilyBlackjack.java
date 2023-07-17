package familyBlackjack;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FamilyBlackjack {
	private ArrayList<String> gameMessages = new ArrayList<>();
	double currentWin;
	double currentLoss;
	//double currentDraw;
	String won;
	String doubled;
	String split;
	String insurance;
	int doubledCalc;
	int splitCalc;
	int insuranceCalc;
	double currentValue;
	double moneyGained;
	private int members;
	private int round = 0;
	private String startingMoneyReply;
	private boolean sameStartingMoney;
	private double startingMoney;
	private HashMap<Integer, String> names = new HashMap<Integer, String>();
	private HashMap<Integer, Double> money = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> wins = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> loss = new HashMap<Integer, Double>();
	//private HashMap<Integer, Double> draws = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> winRate = new HashMap<Integer, Double>();
	public void setup() {
		Scanner in = new Scanner(System.in);
		System.out.println("How many members");
		
		members = in.nextInt();
		in.nextLine();
		System.out.println("Same starting money for everyone?");
		startingMoneyReply = in.nextLine();
		if (startingMoneyReply.equals("yes") || startingMoneyReply.equals("y")) {
			sameStartingMoney = true;
		} else if (startingMoneyReply.equals("no") || startingMoneyReply.equals("n")) {
			sameStartingMoney = false;
		}
		for (int i = 0; i < members; i++) {
			System.out.println("Input name of player " + (i+1));
			names.put(i, in.nextLine());
		}
		if (sameStartingMoney) {
			System.out.println("Enter everyone's starting cash");
			startingMoney = in.nextDouble();
			for (int i = 0; i < members; i++) {
				money.put(i, startingMoney);
			}
		} else {
			for (int i = 0; i < members; i++) {
				System.out.println("Enter  " + names.get(i) + "'s starting money");
				startingMoney = in.nextDouble();
				money.put(i, startingMoney);
			}
		}
		for (int i = 0; i < members; i++) {
			wins.put(i, 0.0);
			loss.put(i, 0.0);
			//draws.put(i, 0.0);
		}
	}
	public void play() throws IOException {
		Scanner in = new Scanner(System.in);
		while (true) {
			currentValue = 0;
			moneyGained = 0;
			round++;
			System.out.println("Round " + round);
			gameMessages.add("Round " + round);
			for (int i = 0; i < members; i++) {
				System.out.println("How much did " + names.get(i) + " win/lose?");
				gameMessages.add("How much did " + names.get(i) + " win/lose?");
				gameMessages.add("");
			    try {
			        moneyGained = in.nextDouble();
			    } catch (InputMismatchException e) {
			        return; // Remove the parentheses after return
			    }
			    currentValue = money.get(i);
			    money.put(i, currentValue + moneyGained);
			    if (moneyGained > 0) {
			    	currentWin = wins.get(i);
			    	wins.put(i, currentWin + 1);
			    } else if (moneyGained < 0) {
			    	currentLoss = loss.get(i);
			    	loss.put(i, currentLoss + 1);
			    }
			    System.out.println(names.get(i) + " now has " + money.get(i) + " dollars");
			    gameMessages.add(names.get(i) + " now has " + money.get(i) + " dollars");
			    winRate.put(i, (wins.get(i)/(loss.get(i) + wins.get(i))));
			    System.out.println("wins " + wins.get(i));
			    System.out.println("losses " + loss.get(i));
				System.out.println(names.get(i) + "'s win rate is " + (100 * winRate.get(i)) + "%");
			    System.out.println("");
			    gameMessages.add(""); // Add an empty line
			}
			System.out.println("Proceeding to the next round...");
			gameMessages.add("Proceeding to the next round...");
			for (int i = 0; i < members; i++) {
//				System.out.println("Enter player round information (won/lost, doubled, split, insurance)");
//				String input = in.nextLine();
//				String[] parts = input.split(",");
//				if (parts.length >= 4) {
//					won = parts[0].trim();
//					doubled = parts[1].trim();
//					split = parts[2].trim();
//					insurance = parts[3].trim();
//					
//				} else {
//					System.out.println("Invalid format. Try again.");
//					if (i != 0) {
//						i--;
//					} else {
//						i = 0;
//					}
//				}
//				if (!doubled.equals("0")) {
//					doubledCalc = 2;
//				}
				
				
//				try {
//				moneyGained = in.nextDouble();
//				
//				if (moneyGained > 0) {
//					currentWin = wins.get(i);
//					wins.put(i, currentWin + 1);
//				} else if (moneyGained < 0) {
//					currentLoss = loss.get(i);
//					loss.put(i, currentLoss + 1);
//				} 
//				} catch (InputMismatchException e){
//					return;
//				}
//				currentValue = money.get(i);
//				money.put(i, currentValue + moneyGained);
			}
		
		}
		
	}
	public void printFile() throws IOException {
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("familyBlackjackScore.txt"));
	        for (String message : gameMessages) {
	            out.write(message);
	            out.newLine(); // Add a new line after each message
	        }
	        out.close();
	        System.out.println("Game messages saved to 'familyBlackjackScore.txt'.");
	    } catch (IOException e) {
	        System.out.println("Error writing to the file!");
	    }
	}
	
	public static void main(String[] args) {
	    FamilyBlackjack runner = new FamilyBlackjack();
	    try {
	        runner.setup();
	        runner.play();
	        runner.printFile();
	    } catch (IOException e) {
	        System.out.println("An error occurred during the execution: " + e.getMessage());
	    }
	}
}

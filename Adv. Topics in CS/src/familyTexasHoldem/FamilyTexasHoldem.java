package familyTexasHoldem;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FamilyTexasHoldem {
	private ArrayList<String> gameMessages = new ArrayList<>();
	//int currentValue;
	
	int maxNumber;
	boolean confirmFold = false;
	int temp;
	int variableFor;
	private int raiseAmount = 0;
	private int dealer = 1;
	private int smallBlind = 2;
	private int bigBlind = 3;
	private int members;
	private int round = 0;
	private boolean validity = false;
	private boolean validity2 = false;
	private String startingMoneyReply;
	private boolean sameStartingMoney;
	private double startingMoney;
	private ArrayList<Integer> foldedPeople = new ArrayList<Integer>();
	private HashMap<Integer, String> names = new HashMap<Integer, String>();
	private HashMap<Integer, Double> money = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> choices = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> dealers = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> smallBlinds = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> bigBlinds = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> roundBet = new HashMap<Integer, Integer>();
//	private HashMap<Integer, Double> wins = new HashMap<Integer, Double>();
//	private HashMap<Integer, Double> loss = new HashMap<Integer, Double>();
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
			dealers.put(i, 0);
			smallBlinds.put(i, 0);
			bigBlinds.put(i, 0);
			roundBet.put(i, 0);
		}
	}
	public void play() throws IOException {
		Scanner in = new Scanner(System.in);
		while (true) {
			maxNumber = Integer.MIN_VALUE;
			round++;
			System.out.println("Round " + round);
			System.out.println(names.get(dealer) + " is the dealer");
			System.out.println(names.get(smallBlind) + " has the small blind");
			System.out.println(names.get(bigBlind) + " has the big blind");
			dealers.put(dealer, 1);
			smallBlinds.put(smallBlind, 1);
			bigBlinds.put(bigBlind, 1);
			for (int i = 0; i < members; i++) {
				roundBet.put(i, 0);
			}
			roundBet.put(smallBlind, 25);
			roundBet.put(bigBlind, 50);
			
			// PROBLEM: MAKE SURE THAT EVERYONE WHO HASN'T FOLDED YET ARE ON THE SAME CALL
			for (int j = 0; j < 4; j++) {
				variableFor = members;
				boolean playerFolded = false;
			for (int i = 0; i < variableFor; i++) {
				if (foldedPeople.contains(i)) {
				
					//error here with wrong person folding - FIXED
					
						System.out.println(names.get(i) + " has folded");
						playerFolded = true;
						continue;
					
				
				}
				System.out.println(roundBet);
				for (int number : roundBet.values()) {
					
					if (number > maxNumber) {
						maxNumber = number;
						
					}
				}
				validity = false;
				
				//ERROR MESSAGE HERE - FIXED
				while (validity == false) {
				System.out.println(variableFor + "ldsjf");
				System.out.println(names.get(i % members) + ", choose an option:");
				System.out.println("1. Call/Check");
				System.out.println("2. Raise");
				System.out.println("3. Fold");
				Integer option = in.nextInt();
				
				if (option > 0 && option < 4) {
					choices.put(i % members, option);
					validity = true;
				} else {
					System.out.println("Invalid option. Choose again.");
				}
			}
				if (choices.get(i % members) == 1) {
					
					roundBet.put(i % members, maxNumber);
					System.out.println("Call to " + maxNumber);
					
				} else if (choices.get(i % members) == 2) {
					temp = i % members;
					while (validity2 == false) {
					System.out.println("Enter raise amount.");
					raiseAmount = in.nextInt();
					if (raiseAmount <= maxNumber) {
						System.out.println("Invalid number. Number must be greater than the bet amount");
					} else {
						validity2 = true;
					}
					}
					roundBet.put(i % members, raiseAmount);
					System.out.println("New bet is " + raiseAmount);
				
					//variableFor = (i + 4) % members; - FIX THIS
					System.out.println(i % members + " is i % members");
					System.out.println(variableFor + " is variablefor");
				} else if (choices.get(i % members) == 3) {
					System.out.println(names.get(i % members) + " has folded.");
					foldedPeople.add(i % members);
				}
				validity2 = false;
		}
		System.out.println("Next stage...");
			}
			dealer = (dealer + 1) % members;
			smallBlind = (smallBlind + 1) % members;
			bigBlind = (bigBlind + 1) % members;

			System.out.println("Proceeding to the next round...");
			gameMessages.add("Proceeding to the next round...");
			
		
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
	    FamilyTexasHoldem runner = new FamilyTexasHoldem();
	    try {
	        runner.setup();
	        runner.play();
	        //runner.printFile();
	    } catch (IOException e) {
	        System.out.println("An error occurred during the execution: " + e.getMessage());
	    }
	}
}
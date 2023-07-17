package blackjack;
import java.util.Scanner;

public class blackjack {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean replay = true;
    int consecutiveWins = 0;
    int money = 100;
    int betMoney;
    boolean blackjack = false;
    while (replay) {
      
      int playerScore = 0;
      int dealerScore = 0;
      boolean gameOver = false;

      System.out.println("Welcome to Blackjack! You have " + money + " dollars. How much do you want to bet?");
      betMoney = input.nextInt();
      while (betMoney > money || betMoney <= 0) {
    	  if (betMoney > money) {
    		  System.out.println("You bet too much money. Enter a smaller number");
    	  } else if (betMoney <= 0) {
    		  System.out.println("You bet too little money. Enter a valid number between 0 and " + money);
    	  }
    	  betMoney = input.nextInt();
      }
      // Initial deal
      playerScore += (int)(Math.random() * 11 + 1);
      dealerScore += (int)(Math.random() * 11 + 1);
      playerScore += (int)(Math.random() * 11 + 1);
      dealerScore += (int)(Math.random() * 11 + 1);
      if ((int)(Math.random() * 10) < consecutiveWins) {
    	  playerScore = 16;
      }
      if (playerScore == 22) {
    	  playerScore = 12;
      }
      if (dealerScore == 22) {
    	  dealerScore = 12;
      }
      if (playerScore == 21) {
    	  gameOver = true;
    	  if (dealerScore < 21) {
    		  blackjack = true;
    	  }
      }
      // Player's turn
      while (!gameOver) {
        System.out.println("Your current score is: " + playerScore);
        System.out.println("Do you want to hit or stay? (h/s)");
        char choice = input.next().charAt(0);
        if (choice == 'h') {
          playerScore += (int)(Math.random() * 11 + 1);
          if (playerScore > 21) {
            System.out.println("Busted! Your score is: " + playerScore);
            gameOver = true;
          }
        } else if (choice == 's') {
          gameOver = true;
        }
      }

      // Dealer's turn
      while (dealerScore < 17) {
        dealerScore += (int)(Math.random() * 11 + 1);
      }

      // Determine winner
      System.out.println("Your final score is: " + playerScore);
      System.out.println("Dealer's final score is: " + dealerScore);
      if (blackjack) {
    	  System.out.println("Blackjack! You earned 1.5X your bet money! You now have " + money + " dollars.");
    	  consecutiveWins++;
    	  money += (int)(1.5 * betMoney);
      } else if ((dealerScore > playerScore || playerScore > 21) && dealerScore <= 21) {
    	money -= betMoney;
        System.out.println("Dealer wins! You now have " + money + " dollars.");
        consecutiveWins = 0;
        
      } else if ((playerScore > dealerScore || dealerScore > 21) && playerScore <= 21) {
    	money += betMoney;
        System.out.println("You win! You earned " + betMoney + " dollars. You now have " + money + " dollars.");
        consecutiveWins++;
        if (consecutiveWins >= 3) {
        	System.out.println("You are on a roll! You currently have a " + consecutiveWins + " win streak");
        }
        
      } else if (playerScore == dealerScore){
        System.out.println("It's a tie! You money has been pushed. You still have " + money + " dollars.");
      }

      System.out.println("Do you want to play again? (y/n)");
      char replayChoice = input.next().charAt(0);
      if (replayChoice == 'n') {
        replay = false;
      }
    }
  }
}
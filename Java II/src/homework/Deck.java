package homework;

import java.util.Arrays;

public class Deck {
	private Card[] deck = new Card[52];
	private Card[] nArray;
	public Deck() {
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		int index = 0;
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < deck.length/4; j++) {
				deck[index] = new Card(suits[i], j+1);
				index++;
			}
		}
	}
	public Card getRandom() {
		return deck[(int)(Math.random() * 52)];
	}
	public Card[] getFirstN(int n) {
		nArray = new Card[n];
		for (int i = 0; i < n; i++) {
			nArray[i] = deck[i];
		}
		return nArray;
	}
	public Card[] shuffle() {
		int count = 0;
		Card[] sep1 = new Card[26];
		Card[] sep2 = new Card[26];
		for (int i = 0; i < deck.length/2; i++) {
			sep1[i] = deck[i];
		}
		for (int i = 26; i < deck.length; i++) {
			sep2[i-26] = deck[i];
		}
		for (int i = 0; i < deck.length; i++) {
			double rand1 = Math.random();
			double rand2 = Math.random();
			double rand3 = Math.random();
			if (i == deck.length-1) {
				continue;
			}
			if (rand1 > rand2) {
				deck[i] = sep1[count];
				deck[i+1] = sep2[count];
			}
			else if (rand2 >= rand1) {
				deck[i] = sep2[count];
				deck[i+1] = sep1[count];
			}
			i++;
			count++;
		}
		System.out.println(Arrays.toString(deck));
		return deck;
	}
	public Card[] sort() {
		for (int i = 0; i < deck.length; i++) {
			int min = i;
			for (int j = i+1; j < deck.length; j++) {
				if (deck[j].getNum() < deck[min].getNum()) {
					min = j;
				}
			}
			Card temp = deck[min];
			deck[min] = deck[i];
			deck[i] = temp;
		}
		System.out.println(Arrays.toString(deck));
		return deck;
		
	}
	public String toString() {
		return "The deck's contents is " + Arrays.toString(deck);
	}
}

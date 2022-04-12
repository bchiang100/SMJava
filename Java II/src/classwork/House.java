package classwork;

import java.util.ArrayList;

public class House {
	ArrayList<Room> rooms = new ArrayList<Room>();
	public House(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public void addRoom(Room room) {
		rooms.add(room);
	}
	public int determine() {
		int price = 0;
		for (Room a : rooms) {
			price += a.getPrice();
		}
		return price;
	}
	public int getVolume() {
		int volume = 0;
		for (Room a : rooms) {
			volume += a.getVolume();
		}
		return volume;
	}
	public int getSquareFootage() {
		int squareFootage = 0;
		for (Room a : rooms) {
			squareFootage += a.squareFootage();
		}
		return squareFootage;
	}
	public void clientMatcher() {
		int bedroom = 0;
		int bathroom = 0;
		int kitchen = 0;
		int livingRoom = 0;
		int wineCellar = 0;
		for (Room a : rooms) {
			if (a.getName().equals("Bedroom")) {
				bedroom++;
			}
			if (a.getName().equals("Bathroom")) {
				bathroom++;
			}
			if (a.getName().equals("Kitchen")) {
				kitchen++;
			}
			if (a.getName().equals("Living Room")) {
				livingRoom++;
			}
			if (a.getName().equals("Wine Cellar")) {
				wineCellar++;
			}
		}
		if (bedroom >= 5 && bathroom >= 2 && livingRoom >= 1) {
			System.out.println("This house is meant for big families");
		}
		if (kitchen >= 2) {
			System.out.println("This house has a big kitchen");
		}
		if (wineCellar >= 1) {
			System.out.println("This house is for wine enthusiasts");
		}
		if (bedroom > 3 && livingRoom >= 2) {
			System.out.println("This house is great for having guests over and conferences");
		}
	}
}


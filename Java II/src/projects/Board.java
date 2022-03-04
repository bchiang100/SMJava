package projects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] kingPositions = new int[2][2];
	// represents the entire board - make sure to initialize!.
	private Piece[][] board = new Piece [8][8];
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages();
		
		
		board[7][3] = new King(0, images.get("WhiteKing"));
		board[0][3] = new King(1, images.get("BlackKing"));
		board[7][4] = new Queen(0, images.get("WhiteQueen"));
		board[0][4] = new Queen(1, images.get("BlackQueen"));
		board[7][2] = new Bishop(0, images.get("WhiteBishop"));
		board[7][5] = new Bishop(0, images.get("WhiteBishop"));
		board[0][2] = new Bishop(1, images.get("BlackBishop"));
		board[0][5] = new Bishop(1, images.get("BlackBishop"));
		board[7][1] = new Horse(0, images.get("WhiteHorse"));
		board[7][6] = new Horse(0, images.get("WhiteHorse"));
		board[0][1] = new Horse(1, images.get("BlackHorse"));
		board[0][6] = new Horse(1, images.get("BlackHorse"));
		board[7][0] = new Rook(0, images.get("WhiteRook"));
		board[7][7] = new Rook(0, images.get("WhiteRook"));
		board[0][0] = new Rook(1, images.get("BlackRook"));
		board[0][7] = new Rook(1, images.get("BlackRook"));
		board[7][0] = new Pawn(0, images.get("WhitePawn"));
		board[7][1] = new Pawn(0, images.get("WhitePawn"));
		board[7][2] = new Pawn(0, images.get("WhitePawn"));
		board[7][3] = new Pawn(0, images.get("WhitePawn"));
		board[7][4] = new Pawn(0, images.get("WhitePawn"));
		board[7][5] = new Pawn(0, images.get("WhitePawn"));
		board[7][6] = new Pawn(0, images.get("WhitePawn"));
		board[7][7] = new Pawn(0, images.get("WhitePawn"));
		board[0][0] = new Pawn(0, images.get("BlackPawn"));
		board[0][1] = new Pawn(0, images.get("BlackPawn"));
		board[0][2] = new Pawn(0, images.get("BlackPawn"));
		board[0][3] = new Pawn(0, images.get("BlackPawn"));
		board[0][4] = new Pawn(0, images.get("BlackPawn"));
		board[0][5] = new Pawn(0, images.get("BlackPawn"));
		board[0][6] = new Pawn(0, images.get("BlackPawn"));
		board[0][7] = new Pawn(0, images.get("BlackPawn"));
		kingPositions[0] = new int[]{3, 0};
		kingPositions[1] = new int[] {3, 7};
		
		// fill in the rest of the chess board here
		
	}
	
	// draws the board. There should be a grid of 8x8 squares, and each piece in their location. 
	// the last clicked piece (curr) should be drawn on a yellow background.
	public void draw(Graphics g, Piece curr) {
		
		int sw = Chess.SQUARE_WIDTH;	// the width of each square on the board
		int xLoc = 0;
		int yLoc = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				g.drawRect(xLoc, yLoc, sw, sw);
				xLoc+=sw;
			}
			yLoc+=sw;
		}
		// your code here
		
	}
	
	// moves the piece currently at (r, c) to (newR, newC), filling 
	// in the vacated space with an empty square.
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		int team;
		int newKingArr[] = {newR, newC};
		if (board[r][c].isKing()) {
			team = board[r][c].getTeam();
			kingPositions[team] = newKingArr;
		}
		if (check() == true) {
			return 1;
		}
		if (check() == false) {
			return 0;
		}
		// your code here
		
	}
	
	// determines if the non-current team is in check. 
	public boolean check() {
		
		// your code here
	}
	
	
	/******** DON'T TOUCH THE BELOW CODE ****************/
	
	// loads all necessary images into a map. Key = piece name, value = corresponding image
	public HashMap<String, Image> loadImages() {
		String[] pieces = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		
		for (String p : pieces) {
			for (String color : new String[] {"Black", "White"}) {
				Image img = Toolkit.getDefaultToolkit().getImage("Images/" + color + p + ".png");	
				images.put(color + p, img.getScaledInstance(Chess.IMG_WIDTH, Chess.IMG_WIDTH, Image.SCALE_SMOOTH));
			}
		}
		return images;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
}

package projects;

import java.awt.Image;
import java.util.ArrayList;

public class Bishop extends Piece{

	public Bishop(int turn, Image img) {
		super(turn, img);
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		// moves up and right
		for (int i = 1; i < 8; i++) {
			if (r + i >= 0 && r + i < 8 && c + i >=0 && c+i <8) {
				if (board.getBoard()[r+i][c+i].getTeam() != getTeam()) {
					int[]move = {r+i,c+i};
					moves.add(move);
				}
				if (board.getBoard()[r+i][c+i].getTeam() != -1) {
					break;
				}
			}
		}
		// moves up and left
		for (int i = 1; i < 8; i++) {
			if (c + i >= 0 && c + i < 8  && r - i >=0 && r - i <8) {
				if (board.getBoard()[r-i][c+i].getTeam() != getTeam()) {
					int[]move = {r-i,c + i};
					moves.add(move);
				}
				if (board.getBoard()[r-i][c+i].getTeam() != -1) {
					break;
				}
			}
		}
		// moves down and right
		for (int i = 1; i < 8; i++) {
			if (r + i >= 0 && r + i < 8  && c - i >=0 && c-i <8) {
				if (board.getBoard()[r+i][c-i].getTeam() != getTeam()) {
					int[]move = {r+i,c-i};
					moves.add(move);
				}
				if (board.getBoard()[r+i][c-i].getTeam() != -1) {
					break;
				}
			}
		}
		// moves down and left
		for (int i = 1; i < 8; i++) {
			if (c - i >= 0 && c - i < 8  && r - i >=0 && r - i <8) {
				if (board.getBoard()[r-i][c-i].getTeam() != getTeam()) {
					int[]move = {r-i,c-i};
					moves.add(move);
				}
				if (board.getBoard()[r-i][c-i].getTeam() != -1) {
					break;
				}
			}
		}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		
		ArrayList<int[]> moves = getMoves(board, r, c);
		// checks each move to see if it reaches the king
		for (int[] m : moves) {
			
			if (m[0] == kingr && m[1] == kingc) {
				return true;
			}
			
		}
		return false;
	}

}

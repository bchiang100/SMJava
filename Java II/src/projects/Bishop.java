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
		int[][] arr = new int[][] {{1,1}, {1,-1}, {-1,1},{-1,-1}};
		for (int k = 0; k < arr.length; k++) {
			for (int i = r, j = c; i >= 0 && j >= 0 && i<8 && j<8; i+=arr[k][0], j+=arr[k][1]) {
				if (board.getBoard()[i][j].getTeam() == -1 || board.getBoard()[i][j].getTeam() == (getTeam()+1)%2) {
					int[]move = {i,j};
					moves.add(move);
				} else {
					break;
				}
			}
		}
	
//		for (int i = c; i < 8; i++) {
//			int j = r;
//			if (j < 8) {
//				if (board.getBoard()[r+i][c+j].getTeam() != getTeam()) {
//					int[]move = {r+1, c+1};
//					moves.add(move);
//					j++;
//				}
//			}
//		}
//		for (int i = c; i < 8; i++) {
//			int j = r;
//			if (j > 0) {
//				if (board.getBoard()[r-i][c+j].getTeam() != getTeam()) {
//					int[]move = {r-1, c+1};
//					moves.add(move);
//					j--;
//				}
//			}
//		}
//		for (int i = c; i > 0; i--) {
//			int j = r;
//			if (j > 0) {
//				if (board.getBoard()[r-i][c-j].getTeam() != getTeam()) {
//					int[]move = {r-1, c-1};
//					moves.add(move);
//					j--;
//				}
//			}
//		}
//		for (int i = c; i > 0; i--) {
//			int j = r;
//			if (j < 8) {
//				if (board.getBoard()[r+i][c-j].getTeam() != getTeam()) {
//					int[]move = {r+1, c-1};
//					moves.add(move);
//					j++;
//				}
//			}
//		}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

}

package projects;

import java.awt.Image;
import java.util.ArrayList;

public class Knight extends Piece{

	public Knight(int turn, Image img) {
		super(turn, img);
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		int[][] arr = new int[][] {{2,1}, {1,2}, {-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
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
//		if (board.getBoard()[r+2][c+1].getTeam() != getTeam()) {
//			int[]move = {r+2, c+1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r+2][c-1].getTeam() != getTeam()) {
//			int[]move = {r+2, c-1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r-2][c+1].getTeam() != getTeam()) {
//			int[]move = {r-2, c+1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r-2][c-1].getTeam() != getTeam()) {
//			int[]move = {r-2, c-1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r+1][c+2].getTeam() != getTeam()) {
//			int[]move = {r+2, c+1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r+1][c-2].getTeam() != getTeam()) {
//			int[]move = {r+2, c-1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r-1][c+2].getTeam() != getTeam()) {
//			int[]move = {r-2, c+1};
//			moves.add(move);
//		}
//		if (board.getBoard()[r-1][c-2].getTeam() != getTeam()) {
//			int[]move = {r-2, c-1};
//			moves.add(move);
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
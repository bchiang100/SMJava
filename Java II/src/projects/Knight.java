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
		// creates a move set in the array arr for all the possible 8 moves
		int[][] arr = new int[][] {{2,1}, {1,2}, {-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
		// goes through each move to see if it is possible. If it is then add it to the moves array list
		for (int i = 0; i < 8; i++) {
			if (r + arr[i][0] < 0 || r + arr[i][0] >= 8 || c + arr[i][1] < 0 || c + arr[i][1] >= 8) {
				continue;
			}
			if (board.getBoard()[r+arr[i][0]][c+arr[i][1]].getTeam() != getTeam()) {
				int move[] = {r+arr[i][0], c+arr[i][1]};
				moves.add(move);
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
		for (int[] m : moves) {
				
				if (m[0] == kingr && m[1] == kingc) {
					return true;
				}
				
			}
		return false;
	}
	
}
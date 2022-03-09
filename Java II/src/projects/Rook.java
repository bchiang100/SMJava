package projects;

import java.awt.Image;
import java.util.ArrayList;

public class Rook extends Piece{

	public Rook(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		int[][] arr = new int[][] {{1,0}, {0,1}, {-1,0},{0,-1}};
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

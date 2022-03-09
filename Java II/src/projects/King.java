package projects;

import java.awt.Image;
import java.util.ArrayList;

public class King extends Piece{
	public King(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	{
		
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		// TODO Auto-generated method stub
		return null;
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

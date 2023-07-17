package codewars;

import java.util.Arrays;
// CODE IS COMPLETE AND CORRECT
public class SudokuSolutionValidator {
    public boolean check(int[][] sudoku) {
    	int[] list = {1,2,3,4,5,6,7,8,9};
    	Boolean[] boolList = new Boolean[9];
    	for (int i = 0; i < boolList.length; i++) {
    		boolList[i] = false;
    	}
        for (int i = 0; i < sudoku.length; i++) {
        	for (int j = 0; j < sudoku[i].length; j++) {
        		for (int k = i; k < i+3; k++) {
        			for (int l = j; l < j+3; l++) {
        				for (int m = 0; m < 9; m++) {
        					if (sudoku[k][l] == 0) {
        	        			return false;
        	        		}
        					if (sudoku[k][l] == list[m] && boolList[m] == false) {
        					boolList[m] = true;
        					break;
        					}
        					if (sudoku[k][l] == list[m] && boolList[m] == true) {
            					return false;
            					}
        				}
        			}
        		}
        		for (int n = 0; n < boolList.length; n++) {
        			boolList[n] = false;
        		} 		
        		j+=2;
        	}
        	i+=2;
        }
        return true;
        
    }
    public static void main(String [] args) {
    	SudokuSolutionValidator runner = new SudokuSolutionValidator();
    	runner.check(new int[][]{{5, 0, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}});
    }
}

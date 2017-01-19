package sudoku;
import java.util.*;

public class Startup {

	public static int count;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuGrid sd = new SudokuGrid();
//		sd.initializeGrid();
//		sd.randomFillGrid();
//		sd.printGrid();
//		List<SudokuElement> sdlist = sd.getAdjacencyList(0, 0);
//		for(SudokuElement sde:sdlist) {
//			System.out.print(sde.getVal()+",");
//		}
//		System.out.print("\n");
//		List<SudokuElement> sdlist2 = sd.get3By3BlockRange(6, 7);
//		for(SudokuElement sde:sdlist2) {
//			System.out.print(sde.getVal()+",");
//		}
		sd.fillSudokuGrid();
		sd.printGrid();
		int sudokuVal[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//int sudokuVal[] = {1, 2, 3, 4};
		Startup.count = 0;
		SudokuElementTree set = new SudokuElementTree(sudokuVal);
		int sum = 1;
		int product = 1;
		for(int l = 8; l > 0; l--) {
			product = l*product;
			sum+=product;
		}
		System.out.println("Nodes Created: "+Startup.count);
		System.out.println("Nodes: "+sum);
		
	}
}

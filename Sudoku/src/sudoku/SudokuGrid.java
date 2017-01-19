package sudoku;
import java.util.*;

public class SudokuGrid {
	private SudokuElement grid[][];
	
	public SudokuGrid() {
		grid = new SudokuElement[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				grid[i][j] = new SudokuElement(0);
	}
	
	public void initializeGrid() {
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				grid[i][j].setVal(0);
	}
	
	public void set(int row, int col, int val) {
		grid[row][col].setVal(val);
	}
	
	public List<SudokuElement> getAdjacencyList(int row, int col) {
		List<SudokuElement> adjacencylist = new ArrayList<SudokuElement>(9);
		for(int i = 0; i < 9; i++) {
			adjacencylist.add(new SudokuElement(i+1));
		}		
		/* Remove all the numbers 1-9 that exist in the same row/col */
		for(int i=0; i < 9; i++) {
			adjacencylist.remove(grid[row][i]);
			adjacencylist.remove(grid[i][col]);
		}				
		List<SudokuElement> List3x3 = this.get3By3BlockRange(row, col);		
		/* Remove all the number 1-9 that exist in the same 3x3 box */
		adjacencylist.removeAll(List3x3);		
		shuffle(adjacencylist);		
		return adjacencylist;		
	}
	
	private void zero_row(int row) {
		for(int j = 0; j < 9; j++)
			grid[row][j].setVal(0);
	}
	
	private void shuffle(List<SudokuElement> sde) {
		for(int i = 0; i < 10; i++) {
			Random generator = new Random(System.nanoTime());
			if(sde.size() > 1) {
				int a = generator.nextInt(sde.size());
				int b = generator.nextInt(sde.size());
				SudokuElement temp;
				temp = sde.get(a);		
				sde.set(a, sde.get(b));
				sde.set(b, temp);
			}
		}
	}
	
	public void printGrid() {
		System.out.println();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(grid[i][j].getVal());
				if((j+1)%3 == 0)
					System.out.print("|");
			}
			System.out.print("\n");
			if((i+1)%3 == 0)
				System.out.print("------------\n");
		}		
	}
	
	public void fill_row(int row) {
		boolean row_populated = false;
		int passes = 0;
		while(!row_populated) {
			passes+=1;
			zero_row(row);
			row_populated = true;
			for(int j = 0; j < 9 && row_populated; j++) {
				List<SudokuElement> possibleNum = this.getAdjacencyList(row, j);
				Iterator<SudokuElement> it = possibleNum.iterator();
				if(it.hasNext()) {
					grid[row][j].setVal(it.next().getVal());					
				} else {
					row_populated = false;
				}
			}
		}
		System.out.println("Filled Row "+row+" in "+passes+" passes.");
	}
	
	public void fillSudokuGrid() {		
		this.initializeGrid();
		for(int i = 0; i < 9; i++) {
			this.fill_row(i);
		}
	}
	
	public void randomFillGrid() {		
		Random generator = new Random(System.nanoTime());		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				grid[i][j].setVal(generator.nextInt(9));				
			}
		}
	}
	
	public List<SudokuElement> get3By3BlockRange(int row, int col) {
		List<SudokuElement> blockrange = new ArrayList<SudokuElement>();		
		int start_row = 0;
		int start_col = 0;		
		if(row >= 0 && row <= 2)
			start_row = 0;
		else if (row >= 3 && row <= 5)
			start_row = 3;
		else if (row >= 6 && row <= 8)
			start_row = 6;		
		if(col >= 0 && col <= 2)
			start_col = 0;
		else if (col >= 3 && col <= 5)
			start_col = 3;
		else if (col >= 6 && col <= 8)
			start_col = 6;		
		for (int i = start_row; i < start_row+3; i++) {
			for(int j = start_col; j < start_col+3; j++) {
				blockrange.add(grid[i][j]);
			}
		}		
		return blockrange;		
	}
	
	@Override
	public String toString() {
		return "SudokuGrid [grid=" + Arrays.toString(grid) + "]";
	}
}
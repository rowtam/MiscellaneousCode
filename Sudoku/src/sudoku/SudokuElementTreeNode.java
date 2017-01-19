package sudoku;
import java.io.IOException;
import java.util.*;

public class SudokuElementTreeNode {
	public boolean is_dead_end;
	public int value;
	public List<SudokuElementTreeNode> sudokuElementChildren;
	
	public SudokuElementTreeNode(int value, List<SudokuElement> unused_range) {
		Startup.count++;
		if(unused_range.size() != 0)
			sudokuElementChildren = new ArrayList<SudokuElementTreeNode>(unused_range.size() - 1);
		else
			sudokuElementChildren = new ArrayList<SudokuElementTreeNode>(0);
		this.is_dead_end = false;
		this.value = value;
		List<SudokuElement> unused_range_copy = new ArrayList<SudokuElement>(unused_range);
		unused_range_copy.remove(new SudokuElement(value));
		System.out.print("Node Value: "+ value + " Children: ");
		for(SudokuElement sde:unused_range_copy)
			System.out.print(sde.getVal()+ ",");
//		try {
//			System.in.read();
//		} catch (e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println();
		for(SudokuElement sde:unused_range) {
			if(sde.getVal() != value) {
				sudokuElementChildren.add(new SudokuElementTreeNode(sde.getVal(), unused_range_copy));
			}
		}
	}

	public boolean isIs_dead_end() {
		return is_dead_end;
	}

	public void setIs_dead_end(boolean is_dead_end) {
		this.is_dead_end = is_dead_end;
	}

	public List<SudokuElementTreeNode> getSudokuElementChild() {
		return sudokuElementChildren;
	}

	public void setSudokuElementChild(List<SudokuElementTreeNode> sudokuElementChild) {
		this.sudokuElementChildren = sudokuElementChild;
	}

}

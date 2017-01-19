package sudoku;
import java.io.IOException;
import java.util.*;

public class SudokuElementTree {
	
	public List<SudokuElementTreeNode> rootElements;
	
	
	public SudokuElementTree(int rootAvailNum[]) {
		
		rootElements = new ArrayList<SudokuElementTreeNode>(rootAvailNum.length);
		for(int i = 0; i < rootAvailNum.length; i++) {
			List<SudokuElement> sdelist = new ArrayList<SudokuElement>(rootAvailNum.length);
			/* Build a list of numbers to pass to the root */
			for(int numElements=0; numElements<rootAvailNum.length; numElements++) {
				sdelist.add(new SudokuElement(rootAvailNum[numElements]));
			}
			System.out.println("Nodes Created: "+Startup.count);
			System.out.print("Tree Root: "+rootAvailNum[i]+" Children: ");
			for(SudokuElement sde:sdelist) {
				System.out.print(sde.getVal()+",");
			}
			System.out.println();
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rootElements.add(new SudokuElementTreeNode(rootAvailNum[i], sdelist));
		}
	}

}

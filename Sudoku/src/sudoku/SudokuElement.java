package sudoku;

public class SudokuElement {
	int value;
	
	public SudokuElement() {
		value = 0;
	}
	
	public SudokuElement(int value) {
		this.value = value;
	}
	
	public void setVal(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SudokuElement other = (SudokuElement) obj;
		if (value != other.value)
			return false;
		return true;
	}
}

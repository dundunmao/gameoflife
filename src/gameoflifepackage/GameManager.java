package gameoflifepackage;
public class GameManager {
	Grid grid;
	
	public GameManager(Grid grid) {
		this.grid = grid;
	}
	
	public int countLivingNeighbors(int row, int col) {
		int livingNeighbors = 0;

	  int[] dxArray = {-1, 0, 1};
	  int[] dyArray = {-1, 0, 1};
	  
	  for (int dx : dxArray) {
	    for (int dy : dyArray) {
	    	int neighborRow = row + dy;
	    	int neighborCol = col + dx;
	    	if ((dx != 0 || dy != 0)
	    			&& neighborRow >= 0 && neighborRow < grid.getNumRows()
	    			&& neighborCol >= 0 && neighborCol < grid.getNumCols()) {
	    		if (grid.getCell(neighborRow, neighborCol).isLiving()) {
	    			livingNeighbors++;
	    		}
	    	}
	    }
	  }
	  
    return livingNeighbors;
	}
	
	public void nextGeneration() {
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				int livingNeighbors = countLivingNeighbors(row, col);
				Cell cell = grid.getCell(row, col);
				if (cell.isLiving()) {
					if (livingNeighbors <= 1 || livingNeighbors >= 4) {
						cell.setWillLive(false);
					} else {
						cell.setWillLive(true);
					}
				} else {
					if (livingNeighbors == 3) {
						cell.setWillLive(true);
					} else {
						cell.setWillLive(false);
					}
				}
			}
		}
		
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				grid.getCell(row, col).updateIsLiving();
			}
		}
	}




	public void gliderView() {
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				int livingNeighbors = countLivingNeighbors(row, col);
				Cell cell = grid.getCell(row, col);
				if (cell.isLiving()) {
					if (livingNeighbors <= 1 || livingNeighbors >= 4) {
						cell.setWillLive(false);
					} else {
						cell.setWillLive(true);
					}
				} else {
					if (livingNeighbors == 3) {
						cell.setWillLive(true);
					} else {
						cell.setWillLive(false);
					}
				}
			}
		}

		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				grid.getCell(row, col).updateIsLiving();
			}
		}
	}
}

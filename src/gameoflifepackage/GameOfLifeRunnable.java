package gameoflifepackage;

import javax.swing.SwingUtilities;

public class GameOfLifeRunnable implements Runnable {
	public void run() {
		Grid grid = new Grid();
		GameManager gameManager = new GameManager(grid);
		SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
    	  new View(grid, gameManager);  
      }
    });
	}
}

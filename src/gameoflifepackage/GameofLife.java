package gameoflifepackage;
import javax.swing.SwingUtilities;

public class GameofLife {
	public static void main(String[] args) {
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
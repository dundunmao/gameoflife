package Test;

import static org.junit.Assert.*;
import gameoflifepackage.GameManager;
import gameoflifepackage.Grid;
import gameoflifepackage.Cell;

public class Case1 {

    Grid gTest = new Grid();
    Cell cell = gTest.getCell(1, 1);

    GameManager gm = new GameManager(gTest);

    @org.junit.Test
    public void countLivingNeighbors() {
        assertEquals(0, gm.countLivingNeighbors(1,1));
    }

    @org.junit.Test
    public void nextGeneration() {
        gm.nextGeneration();
        assertEquals(false, cell.isLiving());
    }
}
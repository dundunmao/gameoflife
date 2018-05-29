package Test;

import static org.junit.Assert.*;
import gameoflifepackage.GameManager;
import gameoflifepackage.Grid;
import gameoflifepackage.Cell;

public class Case2 {
    Grid gTest = new Grid();
    GameManager gm = new GameManager(gTest);

    public void setup() {
        Cell cell1 = gTest.getCell(0, 0);
        cell1.setWillLive(true);
        cell1.updateIsLiving();
        Cell cell2 = gTest.getCell(0, 1);
        cell2.setWillLive(true);
        cell2.updateIsLiving();
        Cell cell3 = gTest.getCell(0, 2);
        cell3.setWillLive(true);
        cell3.updateIsLiving();
    }

    @org.junit.Test
    public void countLivingNeighbors() {
        setup();
        assertEquals(3, gm.countLivingNeighbors(1, 1));
    }


    @org.junit.Test
    public void nextGeneration() {
        setup();
        gm.nextGeneration();
        Cell cell = gTest.getCell(1, 1);
        assertEquals(true, cell.isLiving());
    }
}

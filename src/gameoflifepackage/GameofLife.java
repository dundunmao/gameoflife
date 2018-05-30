package gameoflifepackage;

public class GameofLife {
	public static void main(String[] args) {
		Runnable r1 = new GameOfLifeRunnable();
		Runnable r2 = new GameOfLifeRunnable();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}
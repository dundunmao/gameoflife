package gameoflifepackage;

public class Cell {
	private boolean isLiving;
	private boolean willLive;

	public Cell(boolean isLiving) {
		this.isLiving = isLiving;
	}

	public boolean isLiving() {
		return isLiving;
	}

	public void updateIsLiving() {
		this.isLiving = willLive;
	}

	public void swapIsLiving() {
		this.isLiving = !isLiving;
	}

	public boolean getWillLive() {
		return willLive;
	}

	public void setWillLive(boolean willLive) {
		this.willLive = willLive;
	}
}


public class Item {

	int i;
	String name, positions;

	public Item() {
		i = 0;
		name = positions = "";
	}

	public Item(int i, String name, String positions) {
		this.i = i;
		this.name = name;
		this.positions = positions;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

}

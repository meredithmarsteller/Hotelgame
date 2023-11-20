import java.io.Serializable;

public class Item implements Serializable {
	
	private String name;//Item's name
	private String desc;//Item's description
	private boolean heavy;
	private boolean used;
	
	public Item(String n) {
		name = n;
		heavy = false;
		used = false;
	}
	
	public void setHeavy(boolean b) {
		heavy = b;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public void setDesc(String d) {
		desc = d;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = b;
	}
	
	public void take() {
			if (heavy)
				System.out.println("Thats too heavy to carry around");
			else { 
				Game.inventory.add(Game.getCurrentRoom().removeItem(name));
				System.out.println("You picked up" + name);
			}
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public String getName() {
		return name;

	}
	
	public String toString() {
		return name;
		
	}
	
	public void use() {
		Game.print("You cant use" + name + "yet...");
		
	}
	

}

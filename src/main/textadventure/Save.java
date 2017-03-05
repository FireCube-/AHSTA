package textadventure;

import java.util.Collection;
import java.util.ArrayList;

public class Save {
	
	private Location location;
	private ArrayList<Entity> inventory;
	
	public Save(Location location, Collection<Entity> inventory) {
		this.location = location;
		this.inventory = new ArrayList<>(inventory);
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public ArrayList<Entity> getInventory() {
		return this.inventory;
	}
	
}

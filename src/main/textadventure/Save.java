package textadventure;

import java.util.Collection;
import java.util.ArrayList;

public class Save {
	
	private Location location;
	private Inventory inventory;
	
	public Save(Location location, Collection<Entity> inventory) {
		this.location = location;
		this.inventory = new Inventory(inventory);
	}
	public Save(Location location, Inventory inventory) {
		this.location = location;
		this.inventory = inventory;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
}

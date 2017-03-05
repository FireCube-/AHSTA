package textadventure;
import java.util.*;

public class Inventory {

	private ArrayList<Entity> items;

	public Inventory() {
		this.items = new ArrayList<>();
	}	

	public Inventory(Collection<Entity> inventory) {
		// TODO Auto-generated constructor stub
	}

	public boolean add(String type) {
		return items.add(new Entity(type));
	}

	public boolean add(Entity e) {
		return items.add(e);
	}
	
	public boolean remove(String type) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() == type) {
				items.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String describe() {
		if (this.items.isEmpty()) {
			return "You have nothing in your inventory.";
		} else {
			String ret = "You have ";
			for (Entity e : this.items) {
				ret += "a " + e.getName() + ", ";
			}
			return ret + " in your inventory.";
		}
	}
	
	public int size(){
		return items.size();
	}
	
	public ArrayList<Entity> getEntities(){
		return items;
	}
	
	public Entity get(int x){
		return items.get(x);
	}

	public Entity getEntity(String name) throws InvalidEntityException {
		for (Entity e : this.items) {
			if (e.getName() == name)
				return e;
		}
		throw new InvalidEntityException("Invalid entity search");
	}
}

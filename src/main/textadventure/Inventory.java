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

	public boolean remove(String type) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() == type) {
				items.remove(i);
				return true;
			}
		}
		return false;
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

}

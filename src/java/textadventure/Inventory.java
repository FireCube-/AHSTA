package textadventure;
import java.util.*;

public class Inventory {

	private ArrayList<Item> items;

	public boolean addItem(String type) {
		return items.add(new Item(type));
	}

	public boolean removeItem(String type) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() == type) {
				items.remove(i);
				return true;
			}
		}
		return false;
	}

}

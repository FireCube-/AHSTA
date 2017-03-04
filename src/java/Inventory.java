public class Inventory {

	ArrayList<Item> items;

	boolean addItem(String type) {
		items.add(new Item(type));
	}

	boolean removeItem(String type) {
		for (int i = 0; i < items.size(); i++) {
			if (i.getType() == type) {
				items.remove(i);
				return true;
			}
		}
		return false;
	}

}

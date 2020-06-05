package mazegame.entity;

import java.util.HashMap;

public class ItemCollection {
		private HashMap <String, Item>items;

	public ItemCollection() {
			items = new HashMap<String, Item> ();
	}
	
	public boolean addItem (String itemLabel, Item item) {
		if (items.containsKey(itemLabel))
			return false;
		items.put(itemLabel, item);
		return true;
	}

	public Item getItem (String itemLabel) {
		return (Item) items.get(itemLabel);
	}
	
	public boolean containsItem (String itemLabel) {
		return items.containsKey(itemLabel);
	}
	
	public String availableItem () {
		StringBuilder returnMsg = new StringBuilder();
		for (Object label: this.items.keySet()) {
			returnMsg.append("[ " + label.toString() + " ]");
		}
		return returnMsg.toString();
	}
}

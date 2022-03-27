package edu.poniperro.items;

import java.util.HashMap;

public class ItemFactory {
	
	private static ItemFactory itemFactory;
	private static HashMap<Integer, Item> items = new HashMap<Integer, Item>();
	
	public static ItemFactory getItemFactory() {
		if (itemFactory == null) {
			ItemFactory.itemFactory = new ItemFactory();
		}
		return ItemFactory.itemFactory;
	}
	
	private ItemFactory() {};
	
	// Lo hago void para poder ir a la otra funci�n sin return
	public static void getItem(String name, double price) {
		ItemFactory.getItem(name, price, null);
	}
	
	public static Item getItem(String name, double price, String extra) {
		for (int i=0; i < items.size(); i++) {
			if (items.get(i).name() == name && items.get(i).price() == price && items.get(i).extra() == extra) {
				return items.get(i);
			}
		}
		// If not in items (adds it to the hashmap)
		Item newItem = new Item(name, price, extra);
		return newItem;
	}
	
	public static void addItem(int i, Item item) {
		items.put(i, item);
	}
	
	public static int size() {
		return items.size();
	}
	
	public static void clear() {
		items.clear();
	}

}

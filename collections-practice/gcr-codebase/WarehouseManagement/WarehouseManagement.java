package genrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class WarehouseItem{
	String name;
	int price;
	public WarehouseItem(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public abstract String getCategory();
	 public String getDetails() {
	        return "Name: " + name + ", Price: ₹" + price + ", Category: " + getCategory();
	    } 
}

class Storage<T extends WarehouseItem>{
	List<T> items = new ArrayList<>();
	
	public void addItem(T item) {
        items.add(item);
        System.out.println(item.name + " added to " + item.getCategory());
    }
	public void removeItem(String name) {
        Iterator<T> iterator = items.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            T item = iterator.next();
            if (item.name.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println(name + " removed from " + item.getCategory());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(name + " not found!");
        }
    }
	public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
	public List<T> getItems() {
        return items;
    }
	
}
class WarehouseUtil {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getDetails());
        }
    }
}
class Electronics extends WarehouseItem{

	public Electronics(String name, int price) {
		super(name, price);
	}

	@Override
	public String getCategory() {
		return "Electronics";
	}

}
class Groceries extends WarehouseItem{

	public Groceries(String name, int price) {
		super(name, price);
	}

	@Override
	public String getCategory() {
		return "Electronics";
	}
	
}
class Furniture extends WarehouseItem{

	public Furniture(String name, int price) {
		super(name, price);
	}

	@Override
	public String getCategory() {
		return "Furniture";
	}

	
}
public class WarehouseManagement {
	public static void main(String[] args) {
		Storage<Electronics> electronics = new Storage<>();
        Storage<Groceries> groceries = new Storage<>();
        Storage<Furniture> furniture = new Storage<>();


        electronics.addItem(new Electronics("Laptop", 70000));
        electronics.addItem(new Electronics("Headphones", 3000));

        groceries.addItem(new Groceries("Rice", 1200));
        groceries.addItem(new Groceries("Milk", 60));

        furniture.addItem(new Furniture("Chair", 2500));
        furniture.addItem(new Furniture("Table", 8000));
        
        System.out.println("Electronics Items");
        electronics.displayItems();
        
        WarehouseUtil.displayAllItems(furniture.getItems());

	}

	
}

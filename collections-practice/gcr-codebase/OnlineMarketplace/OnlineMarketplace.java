package genrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Abstract base class
abstract class Catalog {
    String name;
    int MRP;

    public Catalog(String name, int MRP) {
        this.name = name;
        this.MRP = MRP;
    }

    public abstract String getCategory();

    public String getDetails() {
        return "Name: " + name + ", Price: ₹" + MRP + ", Category: " + getCategory();
    }
}

// Books class
class Books extends Catalog {
    public Books(String name, int MRP) {
        super(name, MRP);
    }

    @Override
    public String getCategory() {
        return "Books";
    }
}

// Clothing class
class Clothing extends Catalog {
    public Clothing(String name, int MRP) {
        super(name, MRP);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}

// Gadgets class
class Gadgets extends Catalog {
    public Gadgets(String name, int MRP) {
        super(name, MRP);
    }

    @Override
    public String getCategory() {
        return "Gadgets";
    }
}

// Generic Product class
class Product<T extends Catalog> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println(item.name + " added successfully to " + item.getCategory());
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

    // Apply discount safely
    public void applyDiscount(T product, double percentage) {
        product.MRP -= (int) (product.MRP * percentage / 100);
        System.out.println("Discount applied to " + product.name);
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {

        Product<Books> books = new Product<>();
        Product<Gadgets> gadgets = new Product<>();
        Product<Clothing> clothing = new Product<>();

        gadgets.addItem(new Gadgets("PS5", 50000));
        gadgets.addItem(new Gadgets("Smartphone", 30000));

        books.addItem(new Books("Java Programming", 800));
        clothing.addItem(new Clothing("Jacket", 2500));

        System.out.println("\n--- Gadgets ---");
        gadgets.displayItems();

        gadgets.applyDiscount(gadgets.getItems().get(0), 10);

        System.out.println("\n--- After Discount ---");
        gadgets.displayItems();
    }
}

public class Main {
    public static void main(String[] args) {

        InventoryManager manager = InventoryManager.getInstance();

        // New products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Phone"));

        // Legacy items
        LegacyItem item1 = new LegacyItem(1, "Old Keyboard");
        LegacyItem item2 = new LegacyItem(2, "Old Mouse");

        manager.addProduct(new ProductAdapter(item1));
        manager.addProduct(new ProductAdapter(item2));

        // Iterator
        ProductIterator iterator = manager.returnInventory();

        while (iterator.hasNext()) {
            iterator.next().displayDetails();
        }
    }
}
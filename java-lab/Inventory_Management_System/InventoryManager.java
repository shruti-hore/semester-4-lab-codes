import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    private List<Product> productList;

    private InventoryManager() {
        productList = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public ProductIterator returnInventory() {
        return new InventoryIterator(productList);
    }
}
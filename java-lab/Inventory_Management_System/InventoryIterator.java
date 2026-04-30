import java.util.List;

public class InventoryIterator implements ProductIterator {
    private List<Product> products;
    private int index = 0;

    public InventoryIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Product next() {
        return products.get(index++);
    }
}
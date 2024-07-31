import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getId())) {
            inventory.put(product.getId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String id) {
        if (inventory.containsKey(id)) {
            inventory.remove(id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Stock: " + product.getStock());
            System.out.println("Cost: " + product.getCost());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product product1 = new Product("P001", "Product_no_1", 50, 999.99);
        Product product2 = new Product("P002", "Product_no_2", 30, 899.99);
        Product product3 = new Product("P003", "Product_no_3", 100, 349.99);
        Product product4 = new Product("P004", "Product_no_4", 25, 1249.99);
        Product product5 = new Product("P005", "Product_no_5", 15, 2399.99);

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        manager.displayProducts();

        Product updatedProduct1 = new Product("P001", "Product_no_1", 60, 949.99);
        manager.updateProduct(updatedProduct1);

        manager.displayProducts();

        manager.deleteProduct("P002");

        manager.displayProducts();
    }
}

class Product {
    private String id;
    private String name;
    private int stock;
    private double cost;

    public Product(String id, String name, int stock, double cost) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

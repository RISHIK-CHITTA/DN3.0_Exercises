class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;
    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer Name: " + customerName + ", Total Price: $" + totalPrice;
    }
}
class SortingAlgorithms {    // Bubble Sort Implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {    // Quick Sort Implementation
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
class SortCustomerOrder {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.10),
            new Order("O004", "David", 175.20),
            new Order("O005", "Eve", 210.80)
        };
        System.out.println("Before Bubble Sort:");
        printOrders(orders);
        SortingAlgorithms.bubbleSort(orders);         // Bubble Sort demonstration
        System.out.println("\nAfter Bubble Sort:");
        printOrders(orders);
        orders = new Order[]{ 	// Reset orders
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.75),
            new Order("O003", "Charlie", 300.10),
            new Order("O004", "David", 175.20),
            new Order("O005", "Eve", 210.80)
        };
        System.out.println("\nBefore Quick Sort:");
        printOrders(orders);        // Quick Sort demonstration
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1); 
        System.out.println("\nAfter Quick Sort:");
        printOrders(orders);
    }
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

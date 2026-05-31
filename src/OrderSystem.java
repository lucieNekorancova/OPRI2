import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class OrderSystem {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double getTotalOrdersValue() {
        return orders.stream().mapToDouble(Order::getOrderTotal).sum();
    }

    public double getAverageOrderValue() {
        if (orders.isEmpty()) return 0;
        return getTotalOrdersValue() / orders.size();
    }

    public String getMostSoldProduct() {
        if (orders.isEmpty()) return "No orders";

        Map<String, Integer> productSales = new HashMap<>();
        for (Order order : orders) {
            for (Product p : order.getProducts()) {
                productSales.put(p.getName(), productSales.getOrDefault(p.getName(), 0) + p.getQuantity());
            }
        }

        return productSales.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }

    public void exportToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Date,Customer,TotalPrice");
            for (Order order : orders) {
                writer.printf("%s,%s,%.2f%n",
                        order.getDate().toString(),
                        order.getCustomer().getName(),
                        order.getOrderTotal());
            }
            System.out.println("Export to CSV successful.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
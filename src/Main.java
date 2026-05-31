import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderSystem system = new OrderSystem();

        System.out.println("--- Welcome to the Order Entry System ---");

        while (true) {
            System.out.println("\nDo you want to enter a new order? (yes/no)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("no")) break;

            try {
                System.out.print("Customer name: ");
                String customerName = scanner.nextLine();

                System.out.print("Customer email: ");
                String customerEmail = scanner.nextLine();

                Customer customer = new Customer(customerName, customerEmail);
                Order order = new Order(LocalDate.now(), customer);

                while (true) {
                    System.out.print("Product name (or 'done' to finish items): ");
                    String prodName = scanner.nextLine();
                    if (prodName.equalsIgnoreCase("done")) break;

                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    System.out.print("Price per unit: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(prodName, quantity, price);
                    order.addProduct(product);
                    System.out.println("Item added.");
                }

                if (!order.getProducts().isEmpty()) {
                    system.addOrder(order);
                    System.out.println("Order successfully saved!");
                } else {
                    System.out.println("Order has no items, it was not saved.");
                }

            } catch (EmptyValueException | InvalidEmailException | ShortNameException | NegativeValueException e) {
                System.out.println("VALIDATION ERROR: " + e.getMessage());
                System.out.println("Try entering the order again.");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number format.");
            }
        }

        System.out.println("\n--- RESULTS ---");
        System.out.println("Total orders value: " + system.getTotalOrdersValue());
        System.out.println("Average order value: " + system.getAverageOrderValue());
        System.out.println("Most sold product: " + system.getMostSoldProduct());

        system.exportToCSV("orders.csv");
        scanner.close();
    }
}
